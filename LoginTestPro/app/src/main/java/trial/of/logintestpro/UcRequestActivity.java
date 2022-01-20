package trial.of.logintestpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UcRequestActivity extends AppCompatActivity {

    Spinner spinner;
    Button submitBtn;
    TextView TVconditions;
    CheckBox upicheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc_request);

        spinner = findViewById(R.id.spinID);
        submitBtn = findViewById(R.id.submitBtn);
        TVconditions = findViewById(R.id.condtionsUC);
        upicheck = findViewById(R.id.upiCheckBox);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                    Toast.makeText(UcRequestActivity.this, "30UC is selected", Toast.LENGTH_SHORT).show();
                    TVconditions.setText(R.string.first30UC);
                    upicheck.setVisibility(View.INVISIBLE);

                    submitBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(UcRequestActivity.this, PaymentActivity.class);
                            startActivity(intent);
                        }
                    });
                } else if (position == 1) {

                    Toast.makeText(UcRequestActivity.this, "300 UC is selected", Toast.LENGTH_SHORT).show();
                    TVconditions.setText(R.string.second300UC);

                    upicheck.setVisibility(View.VISIBLE);
                    upicheck.setText("UPI-PAY 50rs");

                    submitBtn.setText("Pay Now");
                    submitBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (upicheck.isChecked()) {
                                Intent intent = new Intent(UcRequestActivity.this, PaymentActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(UcRequestActivity.this, "Please Accept charges", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                } else if (position == 2) {
                    Toast.makeText(UcRequestActivity.this, "600UC is Selected", Toast.LENGTH_SHORT).show();
                    TVconditions.setText(R.string.third600UC);

                    upicheck.setVisibility(View.VISIBLE);
                    submitBtn.setText("Pay Now");
                    upicheck.setText("UPI-PAY 100rs");

                    submitBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            if (upicheck.isChecked()) {
                                Intent intent = new Intent(UcRequestActivity.this, PaymentActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(UcRequestActivity.this, "100rs Please Accept charges", Toast.LENGTH_SHORT).show();
                            }


                        }
                    });
                } else {
                    Toast.makeText(UcRequestActivity.this, "Please select an appropriate Option", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                Toast.makeText(UcRequestActivity.this, "Please select a valid Option", Toast.LENGTH_SHORT).show();

            }

        });
    }
}
