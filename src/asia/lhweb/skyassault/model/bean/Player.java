package asia.lhweb.skyassault.model.bean;


/**
 * 玩家类
 *
 * @author 罗汉
 * @date 2024/01/26
 */
public class Player extends User {
    private String playerName;
    private int playerScore;
    private HeroPlane heroPlane;


    public Player() {
        heroPlane=new HeroPlane();
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

    public HeroPlane getHeroPlane() {
        return heroPlane;
    }

    public void setHeroPlane(HeroPlane heroPlane) {
        this.heroPlane = heroPlane;
    }
}
