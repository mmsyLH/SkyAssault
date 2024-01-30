package asia.lhweb.skyassault.constant;

import sun.net.www.content.audio.wav;

/**
 * 游戏常数接口，定义了各种类型的参数。
 */
public interface GameConstant {
    String SALT="lh";
    /////////////////////////////////////////////////////////////游戏界面参数
    /**
     * 游戏名称
     */
    String SKY_ASSAULT_NAME = "雷霆战机";
    /**
     * 游戏bg1
     */
    String GAME_BG1 = "images/bg/bg_0.jpg";
    /**
     * 游戏bg2
     */
    String GAME_BG2 = "images/bg/bg_2.jpg";
    /**
     * 游戏bgr
     */
    String GAME_BGR = "images/bg/back_of_about.jpg";
    ////////菜单类
    /**
     * 游戏开始
     */
    String GAME_START = "start";
    /**
     * 游戏结束
     */
    String GAME_END = "end";
    /**
     * 游戏暂停
     */
    String GAME_PAUSE = "pause";
    /**
     * 自定义游戏
     */
    String GAME_CUSTOM = "custom";
    /**
     * 游戏操作
     */
    String GAME_OPERATE = "operate";
    /**
     * 关于游戏
     */
    String GAME_ABOUT = "about";
    /**
     * 游戏再次
     */
    String GAME_AGAIN = "again";
    String GAME_CONTINUE = "continue";
    ////////////////////////////////////菜单栏
    /**
     * 菜单栏高度
     */
    int MENU_BAR_HEIGHT =30 ;
    String MENU_NAME = "菜单";
    String MENU_NAME2 = "帮助";
    String MENU_START = "开始游戏";
    String MENU_END = "退出游戏";
    String MENU_PAUSE = "暂停游戏";
    String MENU_CONTINUE = "继续游戏";
    String MENU_AGAIN = "重新开始";
    String MENU_CUSTOM = "自定义";
    /**
     * 菜单操作
     */
    String MENU_OPERATE = "操作信息";
    /**
     * 关于游戏
     */
    String MENU_ABOUT = "关于游戏";
    /**
     * 菜单设置
     */
    String MENU_SETTING = "设置";
    /**
     * 游戏设置
     */
    String GAME_SETTING = "setting";

    ///////
    /**
     * 游戏窗口总宽度
     */
    int GAME_WINDOW_WIDTH = 1000;

    /**
     * 游戏窗口总高度
     */
    int GAME_WINDOW_HEIGHT = 750;
    /**
     * 游戏窗口左侧宽度
     */
    int GAME_WINDOW_LEFT_WIDTH = 750;
    int GAME_WINDOW_LEFT_HEIGHT = 680;
    /**
     * 游戏窗口右宽度
     */
    int GAME_WINDOW_RIGHT_WIDTH = 250;
    /**
     * 分数文本
     */////////////////////////////////////////////////////////////////游戏右侧面板信息类
    String SCORE_TEXT = "得分: ";
    /**
     * 健康文本
     */
    String HEALTH_TEXT = "生命值: ";
    String LEVEL_TEXT = "当前关卡: 第";
    /**
     * 炸弹文本
     */
    String BOMB_TEXT = "拥有核弹数: ";
    /**
     * 敌人传递文本
     */
    String ENEMY_PASSED_TEXT = "越过防线敌机数: ";
    /**
     * 看不到敌人文字
     */
    String NOT_SEE_ENEMY_TEXT = "未出现敌机数: ";
    /**
     * 基本敌人文本
     */
    String BASIC_ENEMY_TEXT = "初级敌机: ";
    /**
     * 中间敌人文本
     */
    String INTERMEDIATE_ENEMY_TEXT = "中级敌机: ";
    /**
     * Boss敌人文本
     */
    String BOSS_ENEMY_TEXT = "敌机Boss: ";
    /**
     * 雷达文本
     */
    String RADAR_TEXT = "我方电子侦测雷达:";
    String GUAN = "关";
    String MEI = "枚";
    String JIA = "架";
    /**
     * hero1
     *////////////////////////////////////////////////////////////飞机类别
    String HERO1 = "images/myplane/hero2_0.png";
    String HERO1_0 = "images/myplane/hero2_1.png";
    /**
     * hero1宽度
     */
    int HERO1_WIDTH =60;
    /**
     * hero1高度
     */
    int HERO1_HEIGHT =60;
    /**
     * hero1宽度
     */
    int Enemy_WIDTH =60;

    int Enemy_HEIGHT =60;
    /**
     * 敌人类型1 初级敌机
     */
    int Enemy_TYPE1 =1;
    /**
     * 敌人类型2 中级敌机
     */
    int Enemy_TYPE2 =2;
    /**
     * 老板宽度
     */
    int BOSS_WIDTH =400;
    /**
     * 老板高度
     */
    int BOSS_HEIGHT =120;
    /**
     * 敌机类型1-初始敌机
     */
    String ENEMY_PLANE1LV1 = "images/enemyplane/airplane1 (3).png";
    String ENEMY_PLANE1LV2 = "images/enemyplane/enemyPlane3_1_0.png";
    String ENEMY_PLANE2LV1 = "images/enemyplane/airplane2 (3).png";
    String ENEMY_PLANE2LV2 = "images/enemyplane/enemyPlane3_1_1.png";
    String ENEMY_PLANE3LV1 = "images/enemyplane/airplane3 (3).png";
    String ENEMY_PLANE3LV2 = "images/enemyplane/enemyPlane3_2_0.png";
    String BOSS_PLANE1 = "images/enemyplane/boss/boss9.png";
    String BOSS_PLANE2 = "images/enemyplane/boss/boss6.png";
    String BOSS_PLANE3 = "images/enemyplane/boss/boss4r_0.png";
    ////////////////////////////////////////////////////////////奖励类型
    /**
     * 蜜蜂1
     */
    String BEE1 = "images/jiangli/bee.png";
    String HERO_BULLET = "images/zidan/bullet (3).png";
    String ENEMY_BULLET = "images/zidan/enemybullet.png";

    /**
     * 核弹图像
     */
    String NUCLEAR_BOMB_IMAGE = "images/jiangli/atomBomb.png";
    /**
     * 双火力图像
     */
    String DOUBLE_FIREPOWER_IMAGE = "images/jiangli/doubleFire.png";
    ////////////////////////////////////////////////////////////子弹类别
    String ZIDAN_IMAGE = "";
    /**
     * 子弹宽度
     */
    int ZIDAN_W = 10;
    /**
     * 子弹高度
     */
    int ZIDAN_H = 10;

    int ZIDAN_SPEED = 7;
    /**
     * 子弹向上移动
     */
    int BULLET_MOVETYPE1=1;
    /**
     * 子弹向下移动
     */
    int BULLET_MOVETYPE0=0;
    /**
     * 子弹向左上移动
     */
    int BULLET_MOVETYPE2=2;
    /**
     * 子弹向右上移动
     */
    int BULLET_MOVETYPE3=3;
    /**
     * 飞行默认速度
     *////////////////////////////////////////////////////////////////飞行物类别
    int FLY_DEFAULT_SPEED = 3;
    /**
     * 飞台速度
     */
    int FLY_BOSS_SPEED = 1;
    /**
     * defaule w
     */
    int DEFAULE_W = 50;

    ////////////////////////////////////////////////////////////////爆炸类

    /**
     * 爆炸宽度
     */
    int BOOM_W = 100;
    /**
     * 爆炸高度
     */
    int BOOM_H = 100;
    /**
     * 默认boom数组
     */
    String[] DEFAULT_BOOMS = {
            "images/boom/blast_0_1.png",
            "images/boom/blast_0_2.png",
            "images/boom/blast_0_3.png",
            "images/boom/blast_0_4.png",
            "images/boom/blast_0_5.png"
    };

    /**
     * 敌机被击毁
     */
    String [] ENEMY_OVER_BOOMS ={
            "images/boom/EnemyBoom/blast_2_3.png",
            "images/boom/EnemyBoom/blast_2_4.png",
            "images/boom/EnemyBoom/blast_2_5.png",
            "images/boom/EnemyBoom/blast_2_6.png",
    };

    /**
     * 英雄机被击毁
     */
    String [] HERO_OVER_BOOMS ={
            "images/boom/heroBoom/airplane2 (2).png",
            "images/boom/heroBoom/bigairplane3.png",
            "images/boom/heroBoom/bigairplane4.png",
            "images/boom/heroBoom/bigairplane5.png",
            "images/boom/heroBoom/bigairplane6.png",
            "images/boom/heroBoom/bigairplane7.png",
    };

    /**
     * 子弹打到敌机的爆炸
     */
    String ZIDANTO_ENEMYPLANE = "ZIDANTO_ENEMYPLANE";
    /**
     * 雷达
     */
    String RADAR = "RADAR";
    /**
     * 子弹打到子弹的爆炸
     */
    String ZIDANTO_ZIDAN = "ZIDANTO_ZIDAN";
    /**
     * 子弹打到我方飞机的爆炸
     */
    String ZIDANTO_HEREOPLANE = "ZIDANTO_HEREOPLANE";
    /**
     * 英雄机坠毁
     */
    String HEREOPLANE_OVER = "ZIDANTO_ZIDAN";
    /**
     * 敌机坠毁
     */
    String ENEMYPLANE_OVER = "ENEMYPLANE_OVER";

    /////////////////////////////////////////////////雷达图
    /**
     * 雷达图数组
     */
    String[] RADAR_IMAGES = {
            "images/radar/1.png",
            "images/radar/2.png",
            "images/radar/3.png",
            "images/radar/4.png",
            "images/radar/5.png",
            "images/radar/6.png",
            "images/radar/7.png",
            "images/radar/8.png",
            "images/radar/9.png",
            "images/radar/10.png",
            "images/radar/11.png",
            "images/radar/12.png",
            "images/radar/13.png",
            "images/radar/14.png",
            "images/radar/15.png",
            "images/radar/16.png",
            "images/radar/17.png",
            "images/radar/18.png",
            "images/radar/19.png",
            "images/radar/20.png",
            "images/radar/21.png",
            "images/radar/22.png",
            "images/radar/23.png",
            "images/radar/24.png",
            "images/radar/25.png",
            "images/radar/26.png",
            "images/radar/27.png",
            "images/radar/28.png",
            "images/radar/29.png",
            "images/radar/30.png",
    };
    /**
     * 开火等级1
     */
    int FIRE_LEVEL1 = 1;
    /**
     * 开火等级2 三枚子弹
     */
    int FIRE_LEVEL2 = 2;
    /**
     * 开火等级3 子弹变成跟踪蛋
     */
    int FIRE_LEVEL3 = 3;
    /////////////////////////////////////////////////////////////游戏音乐类
    /**
     * 音乐bg
     */
    String MUSIC_BG="music/战火.wav";
    /**
     * 音乐boss
     */
    String MUSIC_BOSS_BG="music/start.wav";
    /**
     * 添加生命
     */
    String MUSIC_ADD_LIFE="music/addLife.wav";
    String MUSIC_FIRE="music/fire.wav";//开火
    String MUSIC_ENEMY_BOOM="music/enemyBoom.wav";//敌机坠毁
    String MUSIC_GAME_OVER="music/gameover.wav";//游戏结束
    String MUSIC_BOSS_BOOM="music/mytankBoom.wav";//boss级坠毁
    /**
     * 音乐重生/吃到奖励物
     */
    String MUSIC_REBORN="music/reborn.wav";



}
