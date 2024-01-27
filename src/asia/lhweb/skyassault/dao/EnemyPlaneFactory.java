package asia.lhweb.skyassault.dao;

import asia.lhweb.skyassault.model.bean.*;

/**
 * 敌机工厂类
 */
public class EnemyPlaneFactory {
    // 生成敌机
    public static FlyingObj createEnemyPlane(int x, int y) {
        EnemyPlane enemyPlane = new EnemyPlane();
        enemyPlane.setFlyX(x);
        enemyPlane.setFlyY(y);
        return enemyPlane;
    }

    // 生成小蜜蜂
    public static FlyingObj createBee(int x, int y) {
        Bee bee = new Bee(x, y);
        return bee;
    }

    // 生成双倍火力奖励
    public static FlyingObj createDoubleFirePower(int x, int y) {
        DoubleFirePower doubleFirePower = new DoubleFirePower(x, y);
        return doubleFirePower;
    }

    // 生成核弹奖励
    public static FlyingObj createNuclearBomb(int x, int y) {
        NuclearBomb nuclearBomb = new NuclearBomb(x, y);
        return nuclearBomb;
    }
}
