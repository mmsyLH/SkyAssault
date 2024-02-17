package asia.lhweb.skyassault.service;


import asia.lhweb.skyassault.Util.DataUtils;
import asia.lhweb.skyassault.Util.DialogUtils;
import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.dao.UserDao;
import asia.lhweb.skyassault.model.bean.Player;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserService {
    private static UserDao userDao = new UserDao();
    private PlaneController planeController;

    public UserService() {

    }

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return boolean
     */
    public boolean isExists(String username) {
        Player player = userDao.getByUsername(username);
        return player != null;
    }

    /**
     * 注册
     *
     * @param player 球员
     * @return boolean
     */
    public boolean register(Player player) {
        // 1 用户名效验
        String username = player.getUsername();
        if (username == null || username.trim().isEmpty()) {
            DialogUtils.showMessageDialog("用户名不能为空", "注册提示框");
            return false;
        }

        // 2 密码效验
        String password = player.getPassword();
        if (password == null || password.length() < 6) {
            DialogUtils.showMessageDialog("密码不能少于6位", "注册提示框");
            return false;
        }

        // 3 用户名是否存在效验
        boolean exists = isExists(player.getUsername());
        if (exists) {
            DialogUtils.showMessageDialog("用户名已经存在", "注册提示框");
        }
        // MD5加密
        player.setPassword(DataUtils.encryptPassword(player.getPassword()));

        return userDao.add(player) != -1;
    }

    /**
     * 登录
     *
     * @param loginUser 登录用户
     * @return {@link Player}
     */
    public Player login(Player loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        Player player = userDao.getByUsername(username);
        if (player == null) {
            DialogUtils.showMessageDialog("用户名不存在", "登录提示框");
            return null;
        }
        System.out.println(DataUtils.encryptPassword(password));
        System.out.println(player.getPassword());
        if (!DataUtils.verifyPassword(password, player.getPassword())) {
            DialogUtils.showMessageDialog("密码错误", "登录提示框");
            return null;
        }
        return player;
    }


    /**
     * 得到积分前三的玩家
     *
     * @return {@link List}<{@link Player}>
     */
    public List<Player> getTop3() {
        List<Player> allUser = userDao.findAllUser();

        // 对所有玩家根据积分进行排序
        allUser.sort((player1, player2) -> {
            // 降序排序
            return player2.getPlayerScore() - player1.getPlayerScore();
        });

        // 获取前三名玩家
        int size = Math.min(3, allUser.size()); // 如果玩家数量不足三人，只返回实际数量的玩家
        return allUser.subList(0, size);
    }
}
