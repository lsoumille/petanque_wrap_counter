package lucas.petanque_wrap_counter.utils;

/**
 * Created by root on 5/9/17.
 */

public class Constants {

    //Game
    public static final String GAME_KEY = "id";
    public static final String GAME_NB_PLAYER_TEAM_1 = "player_number_team_1";
    public static final String GAME_NB_PLAYER_TEAM_2 = "player_number_team_2";
    public static final String GAME_SCORE_TEAM_1 = "score_team_1";
    public static final String GAME_SCORE_TEAM_2 = "score_team_2";
    public static final String GAME_TEAM1_STREAK = "streak_team_1";
    public static final String GAME_TEAM2_STREAK = "streak_team_2";

    public static final String GAME_TABLE_NAME = "GAME";
    public static final String GAME_TABLE_CREATE =
            "CREATE TABLE " + GAME_TABLE_NAME + " (" +
                    GAME_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    GAME_NB_PLAYER_TEAM_1 + " INTEGER NOT NULL CHECK (" + GAME_NB_PLAYER_TEAM_1 + ">0), " +
                    GAME_NB_PLAYER_TEAM_2 + " INTEGER NOT NULL CHECK (" + GAME_NB_PLAYER_TEAM_2 + ">0), " +
                    GAME_SCORE_TEAM_1 + " INTEGER DEFAULT 0), " +
                    GAME_SCORE_TEAM_2 + " INTEGER DEFAULT 0), " +
                    GAME_TEAM1_STREAK + " INTEGER DEFAULT 1), " +
                    GAME_TEAM2_STREAK + " INTEGER DEFAULT 1), ";
    public static final String GAME_TABLE_DROP = "DROP TABLE IF EXISTS " + GAME_TABLE_NAME + ";";
}
