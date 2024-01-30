package asia.lhweb.skyassault.View;

import asia.lhweb.skyassault.Util.DataUtils;
import asia.lhweb.skyassault.constant.ResLoginConstant;
import asia.lhweb.skyassault.controller.Listener.LoginListener;
import asia.lhweb.skyassault.controller.PlaneController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
    private JButton goToRegisterButton;

    public LoginJPanel(PlaneController planeController) {
        setLayout(null);
        //设置监听器
        LoginListener loginListener = new LoginListener(this, planeController);
        ////////////////////////////////
        accLabel = new JLabel("账号");
        accLabel.setBounds(50, 20, ResLoginConstant.JLABEL_X, ResLoginConstant.JLABEL_Y);
        add(accLabel);
        accText = new JTextField();
        accText.setBounds(100, 20, ResLoginConstant.JLABEL_X, ResLoginConstant.JLABEL_Y);
        add(accText);
        ////////////////////////////////
        passwordLabel = new JLabel("密码");
        passwordLabel.setBounds(50, 75, ResLoginConstant.JLABEL_X, ResLoginConstant.JLABEL_Y);
        add(passwordLabel);
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 75, ResLoginConstant.JLABEL_X, ResLoginConstant.JLABEL_Y);
        add(passwordText);
        ///////////////////////////////
        code = new JLabel("验证码");
        code.setBounds(50, 130, ResLoginConstant.JLABEL_X, ResLoginConstant.JLABEL_Y);
        add(code);
        codeButton = new JButton(DataUtils.generateRandomCode()); // 使用随机生成的验证码
        codeButton.setBounds(200, 130, ResLoginConstant.JLABEL_X / 2, ResLoginConstant.JLABEL_Y);
        codeButton.setActionCommand("code"); // 设置按钮命令

        add(codeButton);
        codeText = new JTextField();
        codeText.setBounds(100, 130, ResLoginConstant.JLABEL_X / 2, ResLoginConstant.JLABEL_Y);
        add(codeText);
        /////////////////////////////////
        loginButton = new JButton("登录"); // 创建登录按钮
        loginButton.setActionCommand("login"); // 设置按钮命令
        loginButton.setBounds(100, 200, ResLoginConstant.JLABEL_X, 40);

        add(loginButton);

        // 添加去注册按钮
        goToRegisterButton = new JButton("去注册");
        goToRegisterButton.setActionCommand("goToRegister");
        goToRegisterButton.setBounds(100, 260, ResLoginConstant.JLABEL_X, 40);
        add(goToRegisterButton);


        //设置监听器
        loginButton.addActionListener(loginListener);
        codeButton.addActionListener(loginListener);
        goToRegisterButton.addActionListener(loginListener);
        setVisible(true);
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
