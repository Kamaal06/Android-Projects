package trial.of.authreg;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_RQST=1;
    private Button mButtonChooseImage;
    private Button mButtoneUpload;
    private TextView mTextViewShow;
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private EditText mEditTextFile;

    private Uri mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonChooseImage=findViewById(R.id.button1);
        mButtoneUpload=findViewById(R.id.uploadBtn);
        mTextViewShow=findViewById(R.id.showV);
        mEditTextFile=findViewById(R.id.fileName);
        mProgressBar=findViewById(R.id.progress);


        mButtonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        mButtoneUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    mTextViewShow.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });
    }

    private void openFileChooser(){
        Intent intent =new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_RQST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==PICK_IMAGE_RQST && requestCode == RESULT_OK && data !=null && data.getData() !=null){
            mImageUri=data.getData();

            Picasso.with(this).load(mImageUri).into(mImageView);

            //mImageView.setImageURI(mImageUri);

        }

    }
}
