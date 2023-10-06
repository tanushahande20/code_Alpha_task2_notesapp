package com.example.notes_app;

public interface AdapterListener {
    void OnUpdate(PojoOne pojo);
    void  OnDelete (int id , int pos);
}
