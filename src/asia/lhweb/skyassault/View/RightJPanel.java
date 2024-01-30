package asia.lhweb.skyassault.View;

import asia.lhweb.skyassault.constant.GameConstant;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏右侧信息面板
 *
 * @author 罗汉
 * @date 2024/1/22
 */
public class RightJPanel extends JPanel {
    private JLabel scoreLabel;// 得分
    private int score;

    private JLabel healthLabel;// 生命值
    private int health;

    private JLabel levelLabel;// 当前关卡
    private int level;

    private JLabel bombLabel;// 拥有核弹数
    private int bomb;

    private JLabel enemyPassedLabel;// 越过防线敌机数
    private int enemyPassedNums;

    private JLabel notSeeEnemyLabel;// 未出现敌机数
    private int notSeeEnemyNums;

    private JLabel basicEnemyLabel;// 初级敌机
    private int basicEnemyNums;

    private JLabel intermediateEnemyLabel;// 中级敌机
    private int intermediateEnemyNums;

    private JLabel bossEnemyLabel;// Boss敌机
    private int bossEnemyNums;

    /**
     * 雷达标签
     */
    private JLabel radarLabel;          // 我方电子侦测雷达
    private JLabel radarImageLabel;     // 雷达图

    public RightJPanel() {
        setLayout(null);

        scoreLabel = new JLabel(GameConstant.SCORE_TEXT + score);
        scoreLabel.setBounds(20, 30, 100, 30);

        healthLabel = new JLabel(GameConstant.HEALTH_TEXT + health);
        healthLabel.setBounds(20, 60, 100, 30);

        levelLabel = new JLabel(GameConstant.LEVEL_TEXT + level + GameConstant.GUAN);
        levelLabel.setBounds(20, 90, 100, 30);

        bombLabel = new JLabel(GameConstant.BOMB_TEXT + bomb + GameConstant.MEI);
        bombLabel.setBounds(20, 120, 100, 30);

        enemyPassedLabel = new JLabel(GameConstant.ENEMY_PASSED_TEXT + enemyPassedNums + GameConstant.JIA);
        enemyPassedLabel.setBounds(20, 150, 150, 30);

        notSeeEnemyLabel = new JLabel(GameConstant.NOT_SEE_ENEMY_TEXT + notSeeEnemyNums + GameConstant.JIA);
        notSeeEnemyLabel.setBounds(20, 180, 150, 30);

        basicEnemyLabel = new JLabel(GameConstant.BASIC_ENEMY_TEXT + basicEnemyNums + GameConstant.JIA);
        basicEnemyLabel.setBounds(20, 210, 100, 30);

        intermediateEnemyLabel = new JLabel(GameConstant.INTERMEDIATE_ENEMY_TEXT + intermediateEnemyNums + GameConstant.JIA);
        intermediateEnemyLabel.setBounds(20, 240, 100, 30);

        bossEnemyLabel = new JLabel(GameConstant.BOSS_ENEMY_TEXT + bossEnemyNums + GameConstant.JIA);
        bossEnemyLabel.setBounds(20, 270, 100, 30);

        radarLabel = new JLabel(GameConstant.RADAR_TEXT);
        radarLabel.setBounds(250 / 4, 300, 150, 30);
        setForeground(new Color(241, 83, 119));

        radarImageLabel = new JLabel("雷达图");
        radarImageLabel.setBounds(250 / 4, 330, 150, 150);

        //添加面板 把所有label添加到panel中
        addLabel();
    }

    private void addLabel() {
        add(scoreLabel);
        add(healthLabel);
        add(levelLabel);
        add(bombLabel);
        add(enemyPassedLabel);
        add(notSeeEnemyLabel);
        add(basicEnemyLabel);
        add(intermediateEnemyLabel);
        add(bossEnemyLabel);
        add(radarLabel);
        add(radarImageLabel);
    }

    // set方法
    /**
     * 设置得分信息
     * @param score 得分
     */
    public void setScore(int score) {
        this.score = score;
        scoreLabel.setText(GameConstant.SCORE_TEXT + score);
    }

    /**
     * 设置生命值信息
     * @param health 生命值
     */
    public void setHealth(int health) {
        this.health = health;
        healthLabel.setText(GameConstant.HEALTH_TEXT + health);
    }

    /**
     * 设置关卡信息
     * @param level 当前关卡
     */
    public void setLevel(int level) {
        this.level = level;
        levelLabel.setText(GameConstant.LEVEL_TEXT + level + GameConstant.GUAN);
    }

    /**
     * 设置核弹数信息
     * @param bomb 拥有核弹数
     */
    public void setBomb(int bomb) {
        this.bomb = bomb;
        bombLabel.setText(GameConstant.BOMB_TEXT + bomb + GameConstant.MEI);
    }

    /**
     * 设置越过防线敌机数信息
     * @param enemyPassedNums 越过防线敌机数
     */
    public void setEnemyPassedNums(int enemyPassedNums) {
        this.enemyPassedNums = enemyPassedNums;
        enemyPassedLabel.setText(GameConstant.ENEMY_PASSED_TEXT + enemyPassedNums + GameConstant.JIA);
    }

    /**
     * 设置未出现敌机数信息
     * @param notSeeEnemyNums 未出现敌机数
     */
    public void setNotSeeEnemyNums(int notSeeEnemyNums) {
        this.notSeeEnemyNums = notSeeEnemyNums;
        notSeeEnemyLabel.setText(GameConstant.NOT_SEE_ENEMY_TEXT + notSeeEnemyNums + GameConstant.JIA);
    }

    /**
     * 设置初级敌机数信息
     * @param basicEnemyNums 初级敌机数
     */
    public void setBasicEnemyNums(int basicEnemyNums) {
        this.basicEnemyNums = basicEnemyNums;
        basicEnemyLabel.setText(GameConstant.BASIC_ENEMY_TEXT + basicEnemyNums + GameConstant.JIA);
    }

    /**
     * 设置中级敌机数信息
     * @param intermediateEnemyNums 中级敌机数
     */
    public void setIntermediateEnemyNums(int intermediateEnemyNums) {
        this.intermediateEnemyNums = intermediateEnemyNums;
        intermediateEnemyLabel.setText(GameConstant.INTERMEDIATE_ENEMY_TEXT + intermediateEnemyNums + GameConstant.JIA);
    }

    /**
     * 设置Boss敌机数信息
     * @param bossEnemyNums Boss敌机数
     */
    public void setBossEnemyNums(int bossEnemyNums) {
        this.bossEnemyNums = bossEnemyNums;
        bossEnemyLabel.setText(GameConstant.BOSS_ENEMY_TEXT + bossEnemyNums + GameConstant.JIA);
    }


    public int getScore() {
        return score;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getBomb() {
        return bomb;
    }

    public int getEnemyPassedNums() {
        return enemyPassedNums;
    }

    public int getNotSeeEnemyNums() {
        return notSeeEnemyNums;
    }

    public int getBasicEnemyNums() {
        return basicEnemyNums;
    }

    public int getIntermediateEnemyNums() {
        return intermediateEnemyNums;
    }

    public int getBossEnemyNums() {
        return bossEnemyNums;
    }
}