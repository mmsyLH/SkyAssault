package asia.lhweb.skyassault.controller.time;

import asia.lhweb.skyassault.Util.BoomUtils;
import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class FlyObjTime {
    /**
     * 延迟
     */
    private int delay;
    private Timer bgTimer;
    private PlaneController planeController;
    private int myPlaneIndex = 0;// 控制喷火效果的计时器
    private int bulletCounter = 0;// 计时器
    private int bulletDelay = 10; // 控制子弹发射速度的延迟
    private List<FlyingObj> flyingObjs;
    private List<HeroPlane> heroPlaneList;
    private List<Bullet> enemyPlaneBullets;
    private List<FlyingObj> cleanList;
    private List<Bullet> myPlaneBullets;

    public FlyObjTime(PlaneController planeController) {
        this.planeController = planeController;
        this.delay = 35;//  1000/60=17
        this.bgTimer = new Timer(delay, actionListener);
    }

    public ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 得到子弹集合列表
            getBulletsList();

            // 计数器递增
            bulletCounter++;

            // 敌机移动
            flyingObjs = planeController.getFlyingObjects();
            for (FlyingObj flyingObj : flyingObjs) {
                flyingObj.move();
            }


            // 设置玩家飞机的喷火效果切换
            myPlaneIndex = (myPlaneIndex + 1) % 2;
            heroPlaneList.get(0).setFlyType((myPlaneIndex == 0) ? 1 : 2);


            if (bulletCounter % bulletDelay == 0) {
                // 我方飞机开火
                planeController.myPlaneFireRight();
            }
            if (bulletCounter % (5 * bulletDelay) == 0) {
                // 敌机飞机发射子弹
                Bullet bullet;
                for (FlyingObj flyingObj : flyingObjs) {
                    if (flyingObj instanceof EnemyPlane) {
                        EnemyPlane enemyPlane = (EnemyPlane) flyingObj;
                        bullet = new Bullet(enemyPlane.getFlyX() + enemyPlane.getFlyW() / 2 + GameConstant.ZIDAN_W / 2, enemyPlane.getFlyY() + enemyPlane.getFlyH());
                        bullet.setFlyType(2);
                        enemyPlaneBullets.add(bullet);
                    }
                }
            }

            // 检查我方飞机是否被击中
            if (planeController.checkMyPlaneHit()) {

            }

            // 检查敌机是否被击中
            if (planeController.checkEnemyHit()) {

            }
            // 检查我方飞机与其他物品的碰撞
            if (planeController.checkMyPlaneCollisions()) {

            }

            // 检查我方子弹与地方子弹的碰撞
            if (planeController.checkMyBulletHitEnemyBullet()) {

            }

            //绘制爆炸效果
            planeController.processExplosions();


            // 移动玩家飞机的子弹
            for (Bullet myPlaneBullet : myPlaneBullets) {
                myPlaneBullet.move();
                if (myPlaneBullet.isOutOfBound()) {
                    cleanList.add(myPlaneBullet);
                }
            }
            // 移动敌机飞机的子弹
            for (Bullet enemyPlaneBullet : enemyPlaneBullets) {
                enemyPlaneBullet.move();
                if (enemyPlaneBullet.isOutOfBound()) {
                    cleanList.add(enemyPlaneBullet);
                }
            }


            // 删除越界的子弹
            myPlaneBullets.removeAll(cleanList);
            enemyPlaneBullets.removeAll(cleanList);
            cleanList.clear();


        }
    };

    /**
     * 获取子弹列表
     */
    private void getBulletsList() {
        myPlaneBullets = planeController.getMyPlaneBullets();
        cleanList = planeController.getCleanList();
        enemyPlaneBullets = planeController.getEnemyPlaneBullets();
        heroPlaneList=planeController.getHeroPlaneList();
    }


    /**
     * 启动定时器
     */
    public void startTimer() {
        bgTimer.start();
    }

    /**
     * 停止计时器
     */
    public void stopTimer() {
        bgTimer.stop();
    }

    /**
     * 暂停计时器
     */
    public void pauseTimer() {
        bgTimer.stop();
    }

    /**
     * 重置计时器
     */
    public void resumeTimer() {
        bgTimer.start();
    }


    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public Timer getBgTimer() {
        return bgTimer;
    }

    public void setBgTimer(Timer bgTimer) {
        this.bgTimer = bgTimer;
    }

    public PlaneController getPlaneController() {
        return planeController;
    }

    public void setPlaneController(PlaneController planeController) {
        this.planeController = planeController;
    }
}
