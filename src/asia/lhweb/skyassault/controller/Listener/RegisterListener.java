package asia.lhweb.skyassault.controller.Listener;


import asia.lhweb.skyassault.View.RegisterFrame;
import asia.lhweb.skyassault.model.bean.Player;
import asia.lhweb.skyassault.service.UserService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterListener implements ActionListener {
    private RegisterFrame registerFrame;
    private UserService userService;

    public RegisterListener(RegisterFrame registerFrame) {
        this.registerFrame = registerFrame;
        userService=new UserService();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取文本框中的用户输入
        String userAccount = registerFrame.getQid().getText();
        String userPwd = registerFrame.getqPwd().getText();
        String userName = registerFrame.getQname().getText();
        int userScore = 0; // 初始分数为0

        Player player = new Player();
        player.setUsername(userAccount);
        player.setPassword(userPwd);
        player.setPlayerName(userName);
        player.setPlayerScore(userScore);
        switch (e.getActionCommand()) {
            case "register":
                boolean flag = userService.register(player);
                    System.out.println(flag?"注册成功":"注册失败");
                break;
            default:
                break;
        }
    }
}
