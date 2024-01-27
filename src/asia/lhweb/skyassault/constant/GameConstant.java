package asia.lhweb.skyassault.constant;

/**
 * 游戏常数接口，定义了各种类型的参数。
 */
public interface GameConstant {
    /////////////////////////////////////////////////////////////游戏界面参数
    /**
     * 游戏名称
     */
    String SKY_ASSAULT_NAME="雷霆战机";
    String GAME_BG1="images/bg/bg_0.jpg";
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
    int GAME_WINDOW_RIGHT_WIDTH = 250;
    /**
     * hero1
     *////////////////////////////////////////////////////////////飞机类别
    String HERO1="images/myplane/hero2_0.png";
    String HERO1_0="images/myplane/hero2_1.png";
    /**
     * 敌人plane1
     */
    String ENEMY_PLANE1="images/enemyplane/enemyPlane1_1_0.png";
    ////////////////////////////////////////////////////////////奖励类型
    /**
     * 蜜蜂1
     */
    String BEE1="images/jiangli/bee.png";
    /**
     * 核弹图像
     */
    String NUCLEAR_BOMB_IMAGE ="images/jiangli/atomBomb.png";
    /**
     * 双火力图像
     */
    String DOUBLE_FIREPOWER_IMAGE = "images/jiangli/doubleFire.png";
    ////////////////////////////////////////////////////////////子弹类别
    String ZIDAN_IMAGE="";
    /**
     * 子弹宽度
     */
    int ZIDAN_W=10;
    /**
     * 子弹高度
     */
    int ZIDAN_H=10;
}
