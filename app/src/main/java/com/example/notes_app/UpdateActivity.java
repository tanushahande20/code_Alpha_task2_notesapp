package com.example.notes_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    EditText names , emails;
    Button button;
    UserDatabase userDatabase;
    UserDao userDao;
    PojoOne pojoOne;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        userDatabase = UserDatabase.getInstance(this);
        userDao = userDatabase.getDao();

        names = findViewById(R.id.text9);
        emails = findViewById(R.id.text10);
        button = findViewById(R.id.btn4);

        pojoOne = (PojoOne) getIntent().getSerializableExtra("modal");
        names.setText(pojoOne.getName());
        emails.setText(pojoOne.getEmail());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PojoOne userModal = new PojoOne(pojoOne.getId(), names.getText().toString(),emails.getText().toString());
                userDao.Update(userModal);
                finish();
            }
        });
    }
}