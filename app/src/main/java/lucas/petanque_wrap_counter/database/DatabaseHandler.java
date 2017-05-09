package lucas.petanque_wrap_counter.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static lucas.petanque_wrap_counter.utils.Constants.GAME_TABLE_CREATE;
import static lucas.petanque_wrap_counter.utils.Constants.GAME_TABLE_DROP;

/**
 * Created by root on 5/7/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

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
