package com.example.notes_app;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {PojoOne.class},version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao getDao();
    public static UserDatabase INSTANCE;

    public static UserDatabase getInstance(Context context){
        if (INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context,UserDatabase.class,"userdatabase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
