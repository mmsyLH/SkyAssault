package asia.lhweb.skyassault.config;

/**
 * 游戏配置类（单例模式）
 * 包含英雄速度等游戏相关配置
 *
 * @author 罗汉
 * @date 2024/1/29
 */
public class GameConfig {
    private static int heroSpeed;

    private static GameConfig instance;

    private GameConfig() {

    }

    public static void init(){
        heroSpeed =10;
    }

    public static GameConfig getInstance() {
        if (instance == null) {
            instance = new GameConfig();
        }
        return instance;
    }

    public static int getHeroSpeed() {
        return heroSpeed;
    }

    public static void setHeroSpeed(int heroSpeed) {
        GameConfig.heroSpeed = heroSpeed;
    }
}
