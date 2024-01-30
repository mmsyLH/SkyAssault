package asia.lhweb.skyassault.View;

import asia.lhweb.skyassault.controller.Listener.RegisterListener;

import asia.lhweb.skyassault.controller.PlaneController;

import javax.swing.*;

public class RegisterPanel extends JPanel {
    private JTextField account;
    private JTextField playPwd;
    private JTextField playName;
    private JButton registerBtn;
    private JButton goToLoginBtn;
    private PlaneController planeController;
    private RegisterFrame registerFrame;

    public RegisterPanel(RegisterFrame registerFrame) {
        RegisterListener registerListener = new RegisterListener(this);
        this.registerFrame = registerFrame;
        setLayout(null);
        // 输入账号
        JLabel label1 = new JLabel("请输入账号：");
        label1.setBounds(50, 20, 200, 35);
        add(label1);
        account = new JTextField();
        account.setBounds(150, 20, 200, 35);
        add(account);

        // 输入密码
        JLabel label2 = new JLabel("请输入密码：");
        label2.setBounds(50, 75, 200, 35);
        add(label2);
        playPwd = new JPasswordField();
        playPwd.setBounds(150, 75, 200, 35);
        add(playPwd);

        // 输入姓名
        JLabel label3 = new JLabel("请输入姓名：");
        label3.setBounds(50, 130, 200, 35);
        add(label3);
        playName = new JTextField();
        playName.setBounds(150, 130, 200, 35);
        add(playName);

        // 注册按钮
        registerBtn = new JButton("注册");
        registerBtn.setActionCommand("register"); // 设置按钮命令
        registerBtn.setBounds(150, 200, 200, 40); // 调整按钮位置
        add(registerBtn);

        // 去登录按钮
        goToLoginBtn = new JButton("去登录");
        goToLoginBtn.setActionCommand("goToLogin");
        goToLoginBtn.setBounds(150, 260, 200, 40);
        add(goToLoginBtn);
        // 动作监听
        System.out.println(planeController);


        //添加监听器
        registerBtn.addActionListener(registerListener);
        goToLoginBtn.addActionListener(registerListener);

    }

    public JTextField getAccount() {
        return account;
    }

    public void setAccount(JTextField account) {
        this.account = account;
    }

    public JTextField getPlayPwd() {
        return playPwd;
    }

    public void setPlayPwd(JTextField playPwd) {
        this.playPwd = playPwd;
    }

    public JTextField getPlayName() {
        return playName;
    }

    public void setPlayName(JTextField playName) {
        this.playName = playName;
    }

    public JButton getRegisterBtn() {
        return registerBtn;
    }

    public void setRegisterBtn(JButton registerBtn) {
        this.registerBtn = registerBtn;
    }
}
