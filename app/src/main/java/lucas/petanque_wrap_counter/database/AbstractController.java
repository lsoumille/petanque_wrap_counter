package lucas.petanque_wrap_counter.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by root on 5/9/17.
 */

public class AbstractController {

    //DB version
    //Increment if there are some changes in the db scheme
    protected final static int VERSION = 1;
    //DB file name
    protected final static String NOM = "database.db";

    protected SQLiteDatabase mDb;
    protected DatabaseHandler mHandler;

    public AbstractController(Context pContext) {
        this.mHandler = new DatabaseHandler(pContext, NOM, null, VERSION);
    }

    public SQLiteDatabase open() {
        mDb = mHandler.getWritableDatabase();
        return mDb;
    }

    public void close() {
        mDb.close();
    }

    public SQLiteDatabase getDb() {
        return mDb;
    }
}
