package asia.lhweb.skyassault.View;



import asia.lhweb.skyassault.controller.Listener.RegisterListener;

import javax.swing.*;

public class RegisterFrame extends JFrame {
    private JTextField qid;
    private JTextField qPwd;
    private JTextField qname;
    private RegisterPanel registerPanel;
    private JButton registerBtn;

    public RegisterFrame() {
        registerPanel = new RegisterPanel();
        this.add(registerPanel);

        setTitle("注册窗口");
        setSize(400, 400); // 调整窗口大小
        setLocationRelativeTo(null);

        registerFunction();
    }

    public void registerFunction(){
        // 输入账号
        JLabel label1 = new JLabel("请输入账号：");
        label1.setBounds(50, 20, 200, 35);
        registerPanel.add(label1);
        qid = new JTextField();
        qid.setBounds(150, 20, 200, 35);
        registerPanel.add(qid);

        // 输入密码
        JLabel label2 = new JLabel("请输入密码：");
        label2.setBounds(50, 75, 200, 35);
        registerPanel.add(label2);
        qPwd = new JPasswordField();
        qPwd.setBounds(150, 75, 200, 35);
        registerPanel.add(qPwd);

        // 输入姓名
        JLabel label3 = new JLabel("请输入姓名：");
        label3.setBounds(50, 130, 200, 35);
        registerPanel.add(label3);
        qname = new JTextField();
        qname.setBounds(150, 130, 200, 35);
        registerPanel.add(qname);

        // 注册按钮
        registerBtn = new JButton("register");
        registerBtn.setBounds(140, 200, 100, 50); // 调整按钮位置
        registerPanel.add(registerBtn);

        // 动作监听
        RegisterListener registerListener = new RegisterListener(this);
        registerBtn.addActionListener(registerListener);

        setVisible(true);
    }

    public JTextField getQid() {
        return qid;
    }

    public JTextField getqPwd() {
        return qPwd;
    }

    public JTextField getQname() {
        return qname;
    }
}
