package asia.lhweb.skyassault.View;

import javax.swing.*;
import java.awt.*;

/**
 * @author :罗汉
 * @date : 2024/1/22
 */
public class RightJPanel extends JPanel  {
    /**
     * 分标签
     */
    private JLabel scoreLabel;
    /**
     * 梳子标签
     */
    private JLabel combLabel;
    /**
     * 倒计时秒
     */
    private JLabel countdownSeconds;
    public RightJPanel() {
        setLayout(null);
        scoreLabel=new JLabel("得分: 0");
        scoreLabel.setBounds(20,30,100,30);
        add(scoreLabel);


        combLabel=new JLabel("连击数: 0");
        combLabel.setBounds(20,100,100,30);

        countdownSeconds=new JLabel("倒计时：0");
        countdownSeconds.setBounds(20,200,100,30);
        add(countdownSeconds);
    }
    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(JLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public JLabel getCombLabel() {
        return combLabel;
    }

    public void setCombLabel(JLabel combLabel) {
        this.combLabel = combLabel;
    }

    public JLabel getCountdownSeconds() {
        return countdownSeconds;
    }

    public void setCountdownSeconds(JLabel countdownSeconds) {
        this.countdownSeconds = countdownSeconds;
    }
}
