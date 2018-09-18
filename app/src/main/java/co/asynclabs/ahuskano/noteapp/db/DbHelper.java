package co.asynclabs.ahuskano.noteapp.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import co.asynclabs.ahuskano.noteapp.data.Note;
import co.asynclabs.ahuskano.noteapp.data.User;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "NoteApp";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_USER = "user";
    private static final String TABLE_NOTE = "note";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";
    private static final String KEY_UPDATED_AT = "updated_at";
    private static final String KEY_DELETED_AT = "deleted_at";

    // User column names
    private static final String KEY_EMAIL = "email";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASSWORD = "password";

    // Note column names
    private static final String KEY_DESCRIPTION = "description";

    private static final String CREATE_TABLE_USER = String.format(
            "CREATE TABLE `%s` (" +
                    "`%s` INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "`%s` TEXT," +
                    "`%s` TEXT," +
                    "`%s` TEXT," +
                    "`%s` TEXT," +
                    "`%s` TEXT," +
                    "`%s` TEXT" +
                    ");", TABLE_USER,
            KEY_ID,
            KEY_EMAIL,
            KEY_PASSWORD,
            KEY_NAME,
            KEY_CREATED_AT,
            KEY_UPDATED_AT,
            KEY_DELETED_AT);

    private static final String CREATE_TABLE_NOTE = String.format(
            "CREATE TABLE `%s` (" +
                    "`%s` INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "`%s` TEXT," +
                    "`%s` TEXT," +
                    "`%s` TEXT," +
                    "`%s` TEXT," +
                    "`%s` TEXT" +
                    ");", TABLE_NOTE,
            KEY_ID,
            KEY_NAME,
            KEY_DESCRIPTION,
            KEY_CREATED_AT,
            KEY_UPDATED_AT,
            KEY_DELETED_AT);

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getReadableDatabase();
        close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_NOTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void saveUser(User user){
        String sql = String
                .format("INSERT INTO %s (%s, %s, %s) VALUES ('%s','%s','%s')",
                        TABLE_USER,
                        KEY_NAME, KEY_EMAIL, KEY_PASSWORD, user.name, user.email, user.password);
        getWritableDatabase().execSQL(sql);
    }

    public User getUser(String email, String password) {
        String sql = String.format("SELECT * FROM %s where %s = '%s'", TABLE_USER, KEY_EMAIL, email);
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                 return mapCursorToUser(cursor);
            }
        }
        cursor.close();

        return null;
    }

    public void saveNote(Note note){
        String sql = String
                .format("INSERT INTO %s (%s, %s) VALUES ('%s','%s')",
                        TABLE_NOTE,
                        KEY_NAME, KEY_DESCRIPTION, note.name, note.description);
        getWritableDatabase().execSQL(sql);
    }

    public List<Note> getNotes() {
        List<Note> items = new ArrayList<Note>();
        String sql = String.format("SELECT * FROM %s", TABLE_NOTE);
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                items.add(mapCursorToNote(cursor));
                cursor.moveToNext();
            }
        }
        cursor.close();

        return items;
    }

    private User mapCursorToUser(Cursor cursor) {
        User user = new User();
        user.email = cursor.getString(cursor.getColumnIndex(KEY_EMAIL));
        user.name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
        return user;
    }

    private Note mapCursorToNote(Cursor cursor) {
        Note note = new Note();
        note.name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
        note.description = cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION));
        return note;
    }

}
