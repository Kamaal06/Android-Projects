package trial.of.homefacstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView stu, tea;
    TextView wel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stu=findViewById(R.id.student);
        tea=findViewById(R.id.teacher);
        wel=findViewById(R.id.welcome);


        tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teac = new Intent(MainActivity.this, HOmeScreen.class);
                startActivity(teac);
            }
        });

        stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stud= new Intent(MainActivity.this, HOmeScreen.class);
                startActivity(stud);
            }
        });
    }
}
