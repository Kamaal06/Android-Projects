package trial.of.messagealert;

import android.icu.text.CaseMap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlertDialog dialog = new AlertDialog.Builder(this)
        .setTitle("Heading")
                .setMessage("Example OF ALert Message")
                .setPositiveButton("OK", null)
                .setNegativeButton("cancel", null)
                .show();

        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"not Closing",Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        Button negativeButton =dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

    }
}
