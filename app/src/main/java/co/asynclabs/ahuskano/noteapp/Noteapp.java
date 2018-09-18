package co.asynclabs.ahuskano.noteapp;

import android.app.Application;

import co.asynclabs.ahuskano.noteapp.db.DbHelper;

public class Noteapp extends Application {

    protected static Noteapp instance;

    private DbHelper database;

    public Noteapp() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        database = new DbHelper(getApplicationContext());
    }

    public static Noteapp getInstance() {
        if (instance == null) {
            new Noteapp();
        }
        return instance;
    }

    public DbHelper getDatabase() {
        return database;
    }


}
