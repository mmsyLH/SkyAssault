package asia.lhweb.skyassault.model.bean;


import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.model.bean.plane.HeroPlane;

import java.util.ArrayList;
import java.util.List;

/**
 * 玩家类
 *
 * @author 罗汉
 * @date 2024/01/26
 */
public class Player extends User {
    private String playerName;
    private int playerScore;
    private List<HeroPlane> heroPlaneList=new ArrayList<>();


    public Player() {
        HeroPlane heroPlane1 = new HeroPlane();
        heroPlane1.setFlyX(GameConstant.GAME_WINDOW_LEFT_WIDTH/4);
        heroPlane1.setFlyY(GameConstant.GAME_WINDOW_LEFT_HEIGHT/4*3);
        heroPlaneList.add(heroPlane1);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public List<HeroPlane> getHeroPlaneList() {
        return heroPlaneList;
    }

    public void setHeroPlaneList(List<HeroPlane> heroPlaneList) {
        this.heroPlaneList = heroPlaneList;
    }
}
