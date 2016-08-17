package io.github.ceeck65.android.pyppysApp.email;

import android.content.Context;
import android.os.AsyncTask;

import javax.mail.Session;
import android.app.ProgressDialog;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import io.github.ceeck65.android.pyppysApp.R;
import io.github.ceeck65.android.pyppysApp.email.ConfigEmail;


/**
 * Created by mariofernandez on 12/8/16.
 */

public class SendMail extends AsyncTask<Void,Void,Void> {

    //Declarando las Variables
    private Context context;
    private Session session;

    //Informacion del email a enviar
    private String email;
    private String subject;
    private String message;

    //Progressdialog que se muestra mientras se envia el email
    private ProgressDialog progressDialog;

    //Constructor de la clase
    public SendMail(Context context, String email, String subject, String message){
        //Inicializa las variables
        this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Showing progress dialog while sending email
        progressDialog = ProgressDialog.show(context, context.getResources().getString(R.string.sendingMessage), context.getResources().getString(R.string.pleaseWait) ,false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Dismissing the progress dialog
        progressDialog.dismiss();
        //Showing a success message
        Toast.makeText(context, context.getResources().getString(R.string.sendMessage),Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        //Creating properties
        Properties props = new Properties();


        //Datos de configuracion del servidor de email, en este caso Gmail
        props.put("mail.smtp.host", ConfigEmail.SMTP_HOST);
        props.put("mail.smtp.socketFactory.port", ConfigEmail.SMTP_PORT_FACTORY);
        props.put("mail.smtp.socketFactory.class", ConfigEmail.SMTP_CLASS);
        props.put("mail.smtp.auth", ConfigEmail.SMTP_AUTH);
        props.put("mail.smtp.port", ConfigEmail.SMTP_PORT);

        //crea una nueva sesion
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    //Autentifica el usuario con su password
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(ConfigEmail.EMAIL, ConfigEmail.PASSWORD);
                    }
                });

        try {
            //Crea el cuerpo del mensaje
            MimeMessage mm = new MimeMessage(session);

            //Setting sender address
            mm.setFrom(new InternetAddress(ConfigEmail.EMAIL));
            //Adding receiver
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            //Adding subject
            mm.setSubject(subject);
            //Adding message
            mm.setText(message);

            //Envia el email
            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
