package io.github.ceeck65.android.pyppysApp.contacts;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.github.ceeck65.android.pyppysApp.R;
import io.github.ceeck65.android.pyppysApp.email.SendMail;

public class ContactsActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private EditText txtName, txtEmail, txtMessage;
    private Button btnSendEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle(getResources().getString(R.string.titleForm));

        txtName = (EditText) findViewById(R.id.txtName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtMessage = (EditText) findViewById(R.id.txtMessage);

        btnSendEmail = (Button) findViewById(R.id.btnRegisterContact);
        //  Acción botón enviar email
        btnSendEmail.setOnClickListener(this);
    }


    public void sendEmail(){
        // Obteniendo los campos del email
        String name  = txtName.getText().toString().trim();
        String email = txtEmail.getText().toString().trim();
        String message = txtMessage.getText().toString();

        // Creando el objeto del email para luego enviarlo en el metodo execute.
        SendMail sendMail = new SendMail(this, email, name, message);
        sendMail.execute();
        // Limpiando los campos luego de enviado el mensaje
        txtName.setText("");
        txtEmail.setText("");
        txtMessage.setText("");
    }


    @Override
    public void onClick(View view) {
        sendEmail();
    }
}
