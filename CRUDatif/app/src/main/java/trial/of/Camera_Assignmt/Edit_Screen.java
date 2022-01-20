package trial.of.Camera_Assignmt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Edit_Screen extends AppCompatActivity {

    Button Undo, Save, Crop, Rotate;
    ImageView editImageView;

    int Select_picture=200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__screen);

        Undo = findViewById(R.id.edit_Undo);
        Save = findViewById(R.id.edit_Save_Img);
        Crop = findViewById(R.id.edit_Crop);
        Rotate = findViewById(R.id.edit_Rotate);



        editImageView = findViewById(R.id.edit_ImagePrv);





    }
}
