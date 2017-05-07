package lucas.petanque_wrap_counter.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 5/7/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    //GAME TABLE
    public static final String GAME_KEY = "id";
    public static final String GAME_NB_PLAYER_TEAM_1 = "player_number_team_1";
    public static final String GAME_NB_PLAYER_TEAM_2 = "player_number_team_2";
    public static final String GAME_SCORE_TEAM_1 = "score_team_1";
    public static final String GAME_SCORE_TEAM_2 = "score_team_2";

    public static final String GAME_TABLE_NAME = "GAME";
    public static final String GAME_TABLE_CREATE =
            "CREATE TABLE " + GAME_TABLE_NAME + " (" +
                    GAME_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    GAME_NB_PLAYER_TEAM_1 + " INTEGER NOT NULL CHECK (" + GAME_NB_PLAYER_TEAM_1 + ">0), " +
                    GAME_NB_PLAYER_TEAM_2 + " INTEGER NOT NULL CHECK (" + GAME_NB_PLAYER_TEAM_2 + ">0), " +
                    GAME_SCORE_TEAM_1 + " INTEGER DEFAULT 0), " +
                    GAME_SCORE_TEAM_2 + " INTEGER DEFAULT 0), ";
    public static final String GAME_TABLE_DROP = "DROP TABLE IF EXISTS " + GAME_TABLE_NAME + ";";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(GAME_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(GAME_TABLE_DROP);
        onCreate(db);
    }
}
