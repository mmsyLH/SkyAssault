package asia.lhweb.skyassault.model.bean;


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
        heroPlane1.setFlyX(0);
        HeroPlane heroPlane2 = new HeroPlane();
        heroPlaneList.add(heroPlane1);
        heroPlaneList.add(heroPlane2);
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
