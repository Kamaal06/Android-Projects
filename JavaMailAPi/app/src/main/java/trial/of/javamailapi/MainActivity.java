package trial.of.javamailapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText toEmail, SubText, message;
    Button sendBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toEmail=findViewById(R.id.toMail);
        SubText=findViewById(R.id.Subject);
        message=findViewById(R.id.messageEt);

        sendBtn=findViewById(R.id.sendBut);


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mailTo = toEmail.getText().toString().trim();
                String subject = SubText.getText().toString().trim();
                String messageBox=message.getText().toString().trim();

                sendEmail(mailTo, subject, messageBox);
            }
        });

    }

    private void sendEmail(String mailTo, String subject, String messageBox){

        Intent EmailIntent = new Intent(Intent.ACTION_SEND);

        EmailIntent.setData(Uri.parse("mailto:"));
        EmailIntent.setType("text/plain");


        EmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{mailTo});

        EmailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);

        EmailIntent.putExtra(Intent.EXTRA_TEXT, messageBox);
        
        try{

            startActivity(Intent.createChooser(EmailIntent, "Choose and Email Client"));
        }
        
        catch (Exception e){

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
