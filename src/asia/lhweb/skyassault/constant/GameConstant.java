package asia.lhweb.skyassault.constant;

/**
 * 游戏常数接口，定义了各种类型的参数。
 */
public interface GameConstant {
    /////////////////////////////////////////////////////////////游戏界面参数
    /**
     * 游戏名称
     */
    String SKY_ASSAULT_NAME = "雷霆战机";
    /**
     * 游戏bg1
     */
    String GAME_BG1 = "images/bg/bg_0.jpg";
    ////////菜单类
    String GAME_START = "start";
    String GAME_END = "end";
    String GAME_PAUSE = "pause";
    ////////////////////////////////////菜单栏
    /**
     * 菜单栏高度
     */
    int MENU_BAR_HEIGHT =30 ;
    String MENU_NAME = "菜单";
    String MENU_START = "开始游戏";
    String MENU_END = "结束游戏";
    String MENU_PAUSE = "暂停游戏";

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
     * 敌人plane1
     */
    String ENEMY_PLANE1 = "images/enemyplane/enemyPlane1_1_0.png";
    ////////////////////////////////////////////////////////////奖励类型
    /**
     * 蜜蜂1
     */
    String BEE1 = "images/jiangli/bee.png";
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
    ///////////////////////////////////////////////////////////////飞行物类别
    int FLY_DEFAULT_SPEED = 3;
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
    String DEFAULT_BOOM1 = "images/boom/blast_0_1.png";
    /**
     * 默认boom2
     */
    String DEFAULT_BOOM2 = "images/boom/blast_0_2.png";
    /**
     * 默认boom3
     */
    String DEFAULT_BOOM3 = "images/boom/blast_0_3.png";
    /**
     * 默认boom4
     */
    String DEFAULT_BOOM4 = "images/boom/blast_0_4.png";
    /**
     * 默认boom5
     */
    String DEFAULT_BOOM5 = "images/boom/blast_0_5.png";
    //// 敌机被击毁
    String ENEMY_OVER_BOOM1 = "images/boom/blast_0_1.png";
    /**
     * 默认boom2
     */
    String ENEMY_OVER_BOOM2 = "images/boom/blast_0_2.png";
    /**
     * 默认boom3
     */
    String ENEMY_OVER_BOOM3 = "images/boom/blast_0_3.png";
    /**
     * 默认boom4
     */
    String ENEMY_OVER_BOOM4 = "images/boom/blast_0_4.png";
    /**
     * 默认boom5
     */
    String ENEMY_OVER_BOOM5 = "images/boom/blast_0_5.png";
    ////

    /**
     * 子弹打到敌机的爆炸
     */
    String ZIDANTO_ENEMYPLANE = "ZIDANTO_ENEMYPLANE";
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

}
