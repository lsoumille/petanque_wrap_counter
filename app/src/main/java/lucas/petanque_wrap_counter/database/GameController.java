package lucas.petanque_wrap_counter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import lucas.petanque_wrap_counter.business.Game;
import lucas.petanque_wrap_counter.business.Team;
import lucas.petanque_wrap_counter.utils.Constants;

/**
 * Created by root on 5/9/17.
 */

public class GameController extends AbstractController {

    public GameController(Context pContext) {
        super(pContext);
    }

    /**
     * @param g Game to store in the db
     */
    public void add(Game g) {
        ContentValues values = new ContentValues();
        values.put(Constants.GAME_NB_PLAYER_TEAM_1, g.getT1().getNbPlayer());
        values.put(Constants.GAME_NB_PLAYER_TEAM_2, g.getT2().getNbPlayer());
        values.put(Constants.GAME_SCORE_TEAM_1, g.getT1().getScore());
        values.put(Constants.GAME_SCORE_TEAM_2, g.getT2().getScore());
        values.put(Constants.GAME_TEAM1_STREAK, g.getT1().isInStreak());
        values.put(Constants.GAME_TEAM2_STREAK, g.getT2().isInStreak());
        mDb.insert(Constants.GAME_TABLE_NAME, null, values);
    }

    /**
     * @param id Game id to delete
     */
    public void delete(long id) {
        mDb.delete(Constants.GAME_TABLE_NAME, Constants.GAME_KEY + " = ?", new String[] {String.valueOf(id)});
    }

    /**
     * @param g Game to update
     */
    public void update(Game g) {
        ContentValues values = new ContentValues();
        values.put(Constants.GAME_SCORE_TEAM_1, g.getT1().getScore());
        values.put(Constants.GAME_SCORE_TEAM_2, g.getT2().getScore());
        values.put(Constants.GAME_TEAM1_STREAK, g.getT1().isInStreak());
        values.put(Constants.GAME_TEAM2_STREAK, g.getT2().isInStreak());
        mDb.update(Constants.GAME_KEY, values, Constants.GAME_KEY  + " = ?", new String[] {String.valueOf(g.getId())});
    }

    /**
     * @param id Game id to retrieve
     */
    public Game selectionner(long id) {
        Cursor c = mDb.rawQuery("select * from " + Constants.GAME_TABLE_NAME + " where " + Constants.GAME_KEY + " = ?", new String[]{String.valueOf(id)});
        //Only one result in the cursor
        Game g = new Game();
        while (c.moveToNext()) {
            //Create two teams
            Team t1 = new Team(c.getColumnIndex(Constants.GAME_NB_PLAYER_TEAM_1), c.getColumnIndex(Constants.GAME_SCORE_TEAM_1), c.getColumnIndex(Constants.GAME_TEAM1_STREAK));
            Team t2 = new Team(c.getColumnIndex(Constants.GAME_NB_PLAYER_TEAM_2), c.getColumnIndex(Constants.GAME_SCORE_TEAM_2), c.getColumnIndex(Constants.GAME_TEAM2_STREAK));
            //Update Game object
            g.setId(c.getLong(0));
            g.setT1(t1);
            g.setT2(t2);
        }
        c.close();
        return g;
    }
}
