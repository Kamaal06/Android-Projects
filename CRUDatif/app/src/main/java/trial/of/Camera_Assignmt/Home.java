package trial.of.Camera_Assignmt;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    Button Btn_Selfie, Btn_Upload;

    ImageView imageView;
    int Select_picture = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Btn_Selfie = findViewById(R.id.Btn_Selfie);
        Btn_Upload = findViewById(R.id.Btn_Upload);

        imageView = findViewById(R.id.imagePrv);

        Btn_Selfie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);

            }
        });

        Btn_Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                uploadGallery();

            }
        });

    }

    void uploadGallery() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Image"), Select_picture);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == Select_picture) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    imageView.setImageURI(selectedImageUri);



                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                                        imageView.setImageBitmap(bitmap);

                }
            }
        }
    }
}
