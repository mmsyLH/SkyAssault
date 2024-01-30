package asia.lhweb.skyassault.Util;

import asia.lhweb.skyassault.config.GameConfig;

/**
 * 音乐工具类
 *
 * @author 罗汉
 * @date 2024/02/02
 */
public class MusicUtils {
    private static MusicThread bgMusicThread;

    public MusicUtils() {
    }

    /**
     * 初始化 第一个参数是音频路径、第二个参数是否停止、第三个参数是否循环播放
     */
    public static void init() {
        if (bgMusicThread==null){
            bgMusicThread=new MusicThread(GameConfig.getBgMusic(),true,true);
            bgMusicThread.start();
        }
    }

    public static MusicThread getBgMusicThread() {
        return bgMusicThread;
    }

    /**
     * 启动开火线程
     *
     * @return {@link MusicThread}
     */
    public static void startFireMusicThread() {
      new MusicThread(GameConfig.getFire(), false, false).start();
    }

    /**
     * 启动游戏结束线程游戏
     */
    public static void startGameOverMusicThread() {
        new MusicThread(GameConfig.getGameOver(), false, false).start();
    }

    /**
     * 开始添加生活音乐线程
     */
    public static void startAddLifeMusicThread() {
        new MusicThread(GameConfig.getAddLife(), false, false).start();
    }

    /**
     * 启动吃到奖励物音乐线程
     */
    public static void startRebornMusicThread() {
        new MusicThread(GameConfig.getReborn(), false, false).start();
    }

    /**
     * 启动击毁敌人音乐线程
     */
    public static void startEnemyMusicThread() {
        new MusicThread(GameConfig.getEnemyBoom(), false, false).start();
    }

    /**
     * 启动击毁敌人线程
     */
    public static void startBossOverMusicThread() {
        new MusicThread(GameConfig.getBossBoom(), false, false).start();
    }
}
