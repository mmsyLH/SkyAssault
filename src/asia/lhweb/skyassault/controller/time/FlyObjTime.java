package asia.lhweb.skyassault.controller.time;

import asia.lhweb.skyassault.Util.DataUtils;
import asia.lhweb.skyassault.Util.MusicUtils;
import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.fly.Bullet;
import asia.lhweb.skyassault.model.bean.fly.FlyingObj;
import asia.lhweb.skyassault.model.bean.plane.HeroPlane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FlyObjTime {
    /**
     * 延迟
     */
    private int delay;
    private Timer bgTimer;
    private PlaneController planeController;
    private int bulletCounter = 0;// 计时器
    private int bulletDelay = 10; // 控制子弹发射速度的延迟
    private List<FlyingObj> flyingObjs;
    private List<HeroPlane> heroPlaneList;
    private List<Bullet> enemyPlaneBulletList;
    private List<FlyingObj> cleanList;
    private List<Bullet> myPlaneBulletList;


    public FlyObjTime(PlaneController planeController) {
        this.planeController = planeController;
        this.delay = 35;//  1000/60=17
        this.bgTimer = new Timer(delay, actionListener);
    }

    public ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 计数器递增
            bulletCounter++;

            // 得到各种飞行物列表
            getFlyList();

            // 绘制雷达
            planeController.getRadar().switchImage();

            // 敌机移动
            flyingObjs.forEach(FlyingObj::move);

            if (bulletCounter % bulletDelay == 0) {// 我方飞机开火
                planeController.myPlaneFireRight();
                MusicUtils.startFireMusicThread();
            }
            if (bulletCounter % (5 * bulletDelay) == 0) {// 敌机开火
                planeController.enemyFire();
            }
            if (bulletCounter % (10 * bulletDelay) == 0) {// boss开火
                planeController.bossFire();
            }

            // 检查我方飞机是否被击中
            if (planeController.checkMyPlaneHit()) {
                MusicUtils.startEnemyMusicThread();
            }

            // 检查敌机是否被击中
            if (planeController.checkEnemyHit()) {

                MusicUtils.startEnemyMusicThread();
            }

            // 检查boss是否被击中
            if (planeController.checkBossHit()) {

                MusicUtils.startEnemyMusicThread();
            }

            // 检查我方飞机与其他物品的碰撞
            if (planeController.checkMyPlaneCollisions()) {

                MusicUtils.startRebornMusicThread();
            }

            // 检查我方子弹与地方子弹的碰撞
            if (planeController.checkMyBulletHitEnemyBullet()) {
                // todo 播放碰撞子弹的音效

            }

            // 绘制爆炸效果
            planeController.processExplosions();

            // 移动玩家飞机的子弹
            DataUtils.drawBullet(myPlaneBulletList, cleanList);
            // 移动敌机飞机的子弹
            DataUtils.drawBullet(enemyPlaneBulletList, cleanList);


            // 删除越界的子弹
            myPlaneBulletList.removeAll(cleanList);
            enemyPlaneBulletList.removeAll(cleanList);
            cleanList.clear();

            // 测试
            // System.out.println("flyingObjs长度"+flyingObjs.size());
            // System.out.println("heroPlaneList长度"+heroPlaneList.size());
            // System.out.println("enemyPlaneBulletList长度"+enemyPlaneBulletList.size());
            // System.out.println("cleanList长度"+cleanList.size());
            // System.out.println("myPlaneBulletList长度"+myPlaneBulletList.size());
        }
    };

    /**
     * 获取子弹列表
     */
    private void getFlyList() {
        myPlaneBulletList = planeController.getmyPlaneBulletList();
        cleanList = planeController.getCleanList();
        enemyPlaneBulletList = planeController.getenemyPlaneBulletList();
        flyingObjs = planeController.getflyingObjectList();
        heroPlaneList = planeController.getHeroPlaneList();
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
