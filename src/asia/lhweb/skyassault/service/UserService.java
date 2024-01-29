package asia.lhweb.skyassault.service;


import asia.lhweb.skyassault.common.ErrorCode;
import asia.lhweb.skyassault.dao.UserDao;
import asia.lhweb.skyassault.exception.BusinessException;
import asia.lhweb.skyassault.model.bean.Player;

public class UserService {
    private static UserDao userDao = new UserDao();

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return boolean
     */
    public boolean isExists(String username) {
       Player player= userDao.getByUsername(username);
        return player != null;
    }

    /**
     * 注册
     *
     * @param player 球员
     * @return boolean
     */
    public boolean register(Player player) {
        boolean exists = isExists(player.getUsername());
        if (!exists) {
            return userDao.add(player) != -1;
        }
        return false;
    }
    public void register2(Player player) {
        boolean exists = isExists(player.getUsername());
        if (!exists) {
            try {
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"注册失败");
            } catch (BusinessException e) {
                //调用swing弹窗
            }
        }
    }

    public Player login(Player loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        Player player=userDao.getByUsername(username);
        if (player==null) return null;
        if (!password.equals(player.getPassword()))return null;
        return player;
    }
}
