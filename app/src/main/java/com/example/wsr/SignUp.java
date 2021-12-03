package com.example.wsr;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
    }

    public void SignUpOnClick(View view) throws InterruptedException {
        EditText regEmailField = findViewById(R.id.mail);
        EditText regPasswordField = findViewById(R.id.pass);
        EditText regPasswordField2 = findViewById(R.id.regPass);
        EditText nameField = findViewById(R.id.name);
        EditText surnameField = findViewById(R.id.secname);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (regEmailField.getText().toString().equals("")
                || regPasswordField.getText().toString().equals("")
                || regPasswordField2.getText().toString().equals("")
                || nameField.getText().toString().equals("")
                || surnameField.getText().toString().equals(""))
        {
            builder.setTitle("Ошибка!").setMessage("Необходимо заполнить все поля!");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        if (!DBhelper.checkmail(regEmailField.getText().toString()))
        {
            builder.setTitle("Ошибка!").setMessage("Неверный email!");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }
        if (!regPasswordField.getText().toString().equals(regPasswordField2.getText().toString()))
        {
            builder.setTitle("Ошибка!").setMessage("Пароли не совпадают!");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        builder.setTitle("Успех!").setMessage("Вы зарегестрированы!");
        AlertDialog dialog = builder.create();
        dialog.show();

        postTask sendPost = new postTask ();
        sendPost.execute (regEmailField.getText ().toString (), regPasswordField.getText ().toString (), nameField.getText ().toString (), surnameField.getText ().toString ());

        while ( DBhelper.response == null )
        {
            Thread.sleep (500);
        }

        if (DBhelper.response.code () == 200)
        {
            builder.setTitle("Успех!").setMessage("Вы зарегестрированы!").setNegativeButton ("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish ();
                }

            }).setOnCancelListener (new DialogInterface.OnCancelListener ( ) {
                @Override
                public void onCancel (DialogInterface dialog) {
                    finish ();
                }
            });
            dialog = builder.create();
            dialog.show();
        }
        else if (DBhelper.response.code () != 200)
        {
            builder.setTitle("Ошибка!").setMessage("Проблема при регистрации!");
            dialog = builder.create();
            dialog.show();
        }
    }

    public void SignInOnClick(View view)
    {
        finish();
    }
}