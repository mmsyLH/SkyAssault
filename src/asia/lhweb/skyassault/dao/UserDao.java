package asia.lhweb.skyassault.dao;


import asia.lhweb.skyassault.Util.JDBCUtils;
import asia.lhweb.skyassault.model.bean.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection conn = null;
    private PreparedStatement pstat = null;
    private ResultSet res = null;

    // 添加玩家
    public int add(Player player) {
        int index = -1;
        try {
            conn = JDBCUtils.getConnection();
            String insertQuery = "INSERT INTO player (playaccount, playpwd, playname, playScore) VALUES (?, ?, ?, ?)";
            pstat = conn.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            pstat.setString(1, player.getUsername());
            pstat.setString(2, player.getPassword());
            pstat.setString(3, player.getPlayerName());
            pstat.setInt(4, player.getPlayerScore());

            int rowsAffected = pstat.executeUpdate();

            // 获取新插入行的ID
            if (rowsAffected > 0) {
                ResultSet generatedKeys = pstat.getGeneratedKeys();
                if (generatedKeys.next()) {
                    index = generatedKeys.getInt(1);
                }
            }

        } catch (SQLException e) {
            // TODO: 处理异常
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                JDBCUtils.close(conn, pstat, res);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return index;
    }

    // 查找所有用户
    public List<Player> findAllUser() {
        Player play = null;
        List<Player> players = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();

            String selectQuery = "SELECT * FROM player";
            pstat = conn.prepareStatement(selectQuery);
            res = pstat.executeQuery();
            // 处理查询结果
            while (res.next()) {
                play = new Player();
                play.setUsername(res.getString("playaccount"));
                play.setPassword(res.getString("playpwd"));
                play.setPlayerName(res.getString("playname"));
                play.setPlayerScore(res.getInt("playScore"));
                players.add(play);
            }

        } catch (SQLException e) {
            // TODO: 处理异常
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                JDBCUtils.close(conn, pstat, res);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return players;
    }

    // 根据用户名查找玩家
    public Player getByUsername(String username) {
        Player play = null;
        try {
            conn = JDBCUtils.getConnection();
            String selectQuery = "SELECT * FROM player WHERE playaccount = ?";
            pstat = conn.prepareStatement(selectQuery);
            pstat.setString(1, username);
            res = pstat.executeQuery();

            // 处理查询结果
            if (res.next()) {
                play = new Player();
                play.setUsername(res.getString("playaccount"));
                play.setPassword(res.getString("playpwd"));
                play.setPlayerName(res.getString("playname"));
                play.setPlayerScore(res.getInt("playScore"));
            }

        } catch (SQLException e) {
            // TODO: 处理异常
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                JDBCUtils.close(conn, pstat, res);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return play;
    }


}
