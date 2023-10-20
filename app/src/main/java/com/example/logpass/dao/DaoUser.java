package com.example.logpass.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.logpass.entity.User;

import java.util.List;

@Dao
public interface DaoUser {

    @Insert
    void insertOne(User user);

    @Delete
    void delete (User user);

    @Query("SELECT * from user ")
    List<User> getAll();


}
