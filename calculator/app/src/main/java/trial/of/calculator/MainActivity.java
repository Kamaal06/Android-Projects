package trial.of.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equal;
    private final char Addition='+';
    private final char Subtraction='-';
    private final char Multiplication='*';
    private final char Division='/';
    private double val1=Double.NaN;
    private double val2;
    private char Action;
    private final char equ=0;
    private Button clr;


    private TextView info;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"0");
            }
        });

                one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        info.setText(info.getText().toString()+"1");

                    }
                });

                two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        info.setText(info.getText().toString()+"2");
                    }
                });


        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"7");
            }
        });



        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"8");
            }
        });


        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"9");
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action=Addition;
                result.setText(String.valueOf(val1) +"+");
                info.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action=Subtraction;
                result.setText(String.valueOf(val1)+"-");
                info.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action=Multiplication;
                result.setText(String.valueOf(val1)+"*");
                info.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action=Division;
                result.setText(String.valueOf(val1)+"/");
                info.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action=equ;
                result.setText(result.getText().toString()+String.valueOf(val2)+ "=" +String.valueOf(val1));
                info.setText(null);
            }
        });

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length() > 0){
                    CharSequence TotalNO=info.getText().toString();
                    info.setText(TotalNO.subSequence(0, TotalNO.length()-1));
                }
                else {
                    val1=Double.NaN;
                    val2=Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });
    }
    private void setup(){
        zero=(Button)findViewById(R.id.btn0);
        one=(Button)findViewById(R.id.btn1);
        two=(Button)findViewById(R.id.btn2);
        three=(Button)findViewById(R.id.btn3);
        four=(Button)findViewById(R.id.btn4);
        five=(Button)findViewById(R.id.btn5);
        six=(Button)findViewById(R.id.btn6);
        seven=(Button)findViewById(R.id.btn7);
        eight=(Button)findViewById(R.id.btn8);
        nine=(Button)findViewById(R.id.btn9);
        add=(Button)findViewById(R.id.btnadd);
        sub=(Button)findViewById(R.id.btnsub);
        mul=(Button)findViewById(R.id.btnmul);
        div=(Button)findViewById(R.id.btndiv);
        equal=(Button)findViewById(R.id.equal1);
        info=(TextView)findViewById(R.id.tvcntrl);
        result=(TextView)findViewById(R.id.tvrslt);
        clr=(Button)findViewById(R.id.clr);
    }
    private void compute(){
        if(!Double.isNaN(val1)){
            val2=Double.parseDouble(info.getText().toString());

            switch (Action){
                case Addition:
                    val1=val1+val2;
                    break;

                case Subtraction:
                    val1=val1-val2;
                    break;

                case Multiplication:
                    val1=val1*val2;
                    break;

                case Division:
                    val1=val1/val2;
                    break;

                case equ:

                    break;

            }
        }
        else {
            val1=Double.parseDouble(info.getText().toString());
        }
    }
}
