package lucas.petanque_wrap_counter.business;

/**
 * Created by root on 5/9/17.
 */

public class Team {

    private int nbPlayer;
    private int score;
    private boolean inStreak;

    public Team(int nbPlayer, int score, int inStreak) {
        this.nbPlayer = nbPlayer;
        this.score = score;
        this.inStreak = (inStreak != 0);
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    public void setNbPlayer(int nbPlayer) {
        this.nbPlayer = nbPlayer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isInStreak() {
        return inStreak;
    }

    public void setInStreak(boolean inStreak) {
        this.inStreak = inStreak;
    }
}
