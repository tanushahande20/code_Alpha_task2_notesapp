package com.example.notes_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InsertActivity extends AppCompatActivity implements AdapterListener{
EditText name , email;
Button btn;
RecyclerView rv;
UserDatabase userDatabase;
UserDao userDao;
Rd_adapter rd_adapter;
LinearLayoutManager linearLayoutManager;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        userDatabase = UserDatabase.getInstance(this);
        userDao = userDatabase.getDao();

        name = findViewById(R.id.text6);
        email = findViewById(R.id.text7);
        btn = findViewById(R.id.btn3);
        rv = findViewById(R.id.rv4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String names = name.getText().toString();
                String emails = email.getText().toString();

                PojoOne pojoOne = new PojoOne(0,names,emails);
                rd_adapter.addUser(pojoOne);
                userDao.Insert(pojoOne);
                name.setText("");
                email.setText("");
                Toast.makeText(InsertActivity.this, "Inserted", Toast.LENGTH_SHORT).show();

            }
        });
        rd_adapter = new Rd_adapter(this,this);
        linearLayoutManager = new LinearLayoutManager(this);
        rv.setAdapter(rd_adapter);
        rv.setLayoutManager(linearLayoutManager);



    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }

    private void fetchData() {
        rd_adapter.clearData();
        List<PojoOne> pojos = userDao.getAllUsers();
        for(int i=0;i<pojos.size(); i++){
            PojoOne pojo = pojos.get(i);
            rd_adapter.addUser(pojo);
        }

    }

    @Override
    public void OnUpdate(PojoOne pojo) {
        Intent i =  new Intent(InsertActivity.this,UpdateActivity.class);
        i.putExtra("modal",pojo);
        startActivity(i);

    }

    @Override
    public void OnDelete(int id, int pos) {
        userDao.delete(id);
        rd_adapter.removeUser(pos);

    }
}