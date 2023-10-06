package com.example.notes_app;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity
public class PojoOne implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PojoOne(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
