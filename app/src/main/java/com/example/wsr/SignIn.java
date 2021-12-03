package com.example.wsr;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();
    }
    public void SignInOnClick(View view) throws InterruptedException {
        EditText mailField = findViewById(R.id.mailf);
        EditText passField = findViewById(R.id.passwordf);

        if (mailField.getText().toString().equals("") || passField.getText().toString().equals(""))
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Ошибка").setMessage("Необходимо заполнить все поля").show();
        }
        postTask sendPost = new postTask();
        sendPost.execute(mailField.getText().toString(), passField.getText().toString());

        while (DBhelper.response == null)
        {
            Thread.sleep(500);
        }
        AlertDialog.Builder alert =  new AlertDialog.Builder(this);
        if(DBhelper.response.code() == 200)
        {
            alert.setMessage("Успешная авторизация").setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(getApplicationContext(), Main.class);
                    startActivity(i);
                    finish();
                }
            });

        } else if (DBhelper.response.code () != 200)
        {
            alert.setTitle("Ошибка").setMessage("Проблемы с подключением к серверу").show();
        }

    }

    public void SignUpOnClick(View view)
    {
        Intent i = new Intent(getApplicationContext(), SignUp.class);
        startActivity(i);
        finish();
    }
    public void test (View view)
    {
        Intent i = new Intent(getApplicationContext(), Main.class);
        startActivity(i);
        finish();
    }
}