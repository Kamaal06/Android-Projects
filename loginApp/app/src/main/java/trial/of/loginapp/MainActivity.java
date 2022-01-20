package trial.of.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText _user, _pswrd;
    Button _login;
    Spinner _spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _user=(EditText)findViewById(R.id.user);
        _pswrd=(EditText)findViewById(R.id.pswrd);
        _login=(Button)findViewById(R.id.login);
        _spinner=(Spinner)findViewById(R.id.spinner);

    }
}
