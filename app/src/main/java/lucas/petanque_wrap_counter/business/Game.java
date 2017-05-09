package lucas.petanque_wrap_counter.business;

/**
 * Created by root on 5/9/17.
 */

public class Game {

    private long id;
    private Team t1;
    private Team t2;

    public Game() {
    }

    public Game(long id, Team t1, Team t2) {
        this.id = id;
        this.t1 = t1;
        this.t2 = t2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Team getT1() {
        return t1;
    }

    public void setT1(Team t1) {
        this.t1 = t1;
    }

    public Team getT2() {
        return t2;
    }

    public void setT2(Team t2) {
        this.t2 = t2;
    }
}
