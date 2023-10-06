package com.example.notes_app;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void Insert (PojoOne pojo);


    @Update
    void Update (PojoOne pojo);

    @Query("delete from PojoOne where id = :id")
    void delete (int id);

    @Query("Select * from PojoOne")
    List<PojoOne> getAllUsers();
}
