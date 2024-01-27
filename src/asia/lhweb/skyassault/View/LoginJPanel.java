package asia.lhweb.skyassault.View;

import asia.lhweb.skyassault.controller.PlaneController;


import javax.swing.*;
import java.awt.*;

/**
 * @author :罗汉
 * @date : 2024/1/22
 */
public class LoginJPanel extends JPanel {
    private JLabel loginLabel;
    private JLabel accLabel;
    private JLabel passwordLabel;
    private JLabel code;
    private JTextField accText;
    private JTextField passwordText;
    private JTextField codeText;
    private JButton loginButton;
    private JButton codeButton;

    public LoginJPanel(PlaneController planeController) {
        setLayout(null);

        loginLabel=new JLabel("登录");
        loginLabel.setBounds(50,50,60,100);
        add(loginLabel);

        ////////////////////////////////
        accLabel=new JLabel("账号");
        accLabel.setBounds(110,175,80,50);
        add(accLabel);
        accText=new JTextField();
        accText.setBounds(170,180,150,40);
        add(accText);
        ////////////////////////////////
        passwordLabel=new JLabel("密码");
        passwordLabel.setBounds(110,255,80,50);
        add(passwordLabel);
        passwordText=new JTextField();
        passwordText.setBounds(170,255,150,40);
        add(passwordText);
        ///////////////////////////////
        code=new JLabel("验证码");
        code.setBounds(110,310,80,50);
        add(code);
        codeButton = new JButton("1234"); // 创建登录按钮
        codeButton.setBounds(350, 310, 80, 50);
        add(codeButton);
        codeText=new JTextField();
        codeText.setBounds(170,310,150,40);
        add(codeText);
        /////////////////////////////////
        loginButton = new JButton("登录"); // 创建登录按钮
        loginButton.setActionCommand("login"); // 设置按钮命令
        loginButton.setBounds(170, 400, 150, 40);
        add(loginButton);
    }

    public JLabel getLoginLabel() {
        return loginLabel;
    }

    public void setLoginLabel(JLabel loginLabel) {
        this.loginLabel = loginLabel;
    }

    public JLabel getAccLabel() {
        return accLabel;
    }

    public void setAccLabel(JLabel accLabel) {
        this.accLabel = accLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public JLabel getCode() {
        return code;
    }

    public void setCode(JLabel code) {
        this.code = code;
    }

    public JTextField getAccText() {
        return accText;
    }

    public void setAccText(JTextField accText) {
        this.accText = accText;
    }

    public JTextField getPasswordText() {
        return passwordText;
    }

    public void setPasswordText(JTextField passwordText) {
        this.passwordText = passwordText;
    }

    public JTextField getCodeText() {
        return codeText;
    }

    public void setCodeText(JTextField codeText) {
        this.codeText = codeText;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JButton getCodeButton() {
        return codeButton;
    }

    public void setCodeButton(JButton codeButton) {
        this.codeButton = codeButton;
    }
}
