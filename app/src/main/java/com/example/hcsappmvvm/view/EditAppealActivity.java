package com.example.hcsappmvvm.view;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.Room.AppealRoom;
import com.example.hcsappmvvm.viewmodel.AddAppealViewModel;
import com.example.hcsappmvvm.viewmodel.EditAppealViewModel;

import java.io.ByteArrayOutputStream;

public class EditAppealActivity extends AppCompatActivity {

    private EditAppealViewModel editAppealViewModel;
    private EditText titleedittext;
    private EditText descriptionedittext;
    private ImageView imageView;
    Uri uriImage;
    int appealid = -1;
    private String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_appeal);

        editAppealViewModel = new ViewModelProvider(this).get(EditAppealViewModel.class);

        titleedittext = findViewById(R.id.titleappeal);
        descriptionedittext = findViewById(R.id.descriptionappeal);
        imageView = findViewById(R.id.imageofappeal);

        Button confirmeditbtn = findViewById(R.id.confirmeditBtn);
        Button editimage = findViewById(R.id.editimage);

        ActivityResultLauncher<String[]> getContentimage = getActivityResultRegistry().
                register("key", new ActivityResultContracts.OpenDocument(), result -> {
                    getContentResolver().takePersistableUriPermission(result, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    imageView.setImageURI(result);
                    uriImage = result;
                });

        editimage.setOnClickListener(view -> getContentimage.launch(new String[]{"image/*"}));

        Intent intent = getIntent();
        if(intent.hasExtra(AddAppealActivity.EXTRA_ID))
        {
            titleedittext.setText(intent.getStringExtra("AppealTitle"));
            descriptionedittext.setText(intent.getStringExtra("AppealDescription"));
            if(intent.hasExtra("AppealImage")){
                imageView.setImageURI(Uri.parse(intent.getStringExtra("AppealImage")));
            }
            appealid = intent.getIntExtra(AddAppealActivity.EXTRA_ID, -1);

        }

        Button deletebtn = findViewById(R.id.deleteimage);
        deletebtn.setOnClickListener(view -> imageView.setImageDrawable(null));

        confirmeditbtn.setOnClickListener(view -> {
            String titleofappeal = titleedittext.getText().toString();
            String descriptionofappeal = descriptionedittext.getText().toString();
            if(titleofappeal.trim().isEmpty() || descriptionofappeal.trim().isEmpty()){
                Toast.makeText(getApplicationContext(),"Please enter title and description", Toast.LENGTH_SHORT).show();
                return;
            }
            if (imageView.getDrawable() != null && uriImage == null){
                image = imageView.getDrawable().toString();
                AppealRoom updatedappealRoom = new AppealRoom(titleofappeal, descriptionofappeal, image);
                updatedappealRoom.setId(appealid);
                editAppealViewModel.update(updatedappealRoom);
            } else if(imageView.getDrawable() != null && uriImage != null){
                image = uriImage.toString();
                AppealRoom updatedappealRoom = new AppealRoom(titleofappeal, descriptionofappeal, image);
                updatedappealRoom.setId(appealid);
                editAppealViewModel.update(updatedappealRoom);
            } else if (imageView.getDrawable() == null && uriImage != null){
                image = uriImage.toString();
                AppealRoom updatedappealRoom = new AppealRoom(titleofappeal, descriptionofappeal, null);
                updatedappealRoom.setId(appealid);
                editAppealViewModel.update(updatedappealRoom);
            } else {
                AppealRoom updatedappealRoom = new AppealRoom(titleofappeal, descriptionofappeal, null);
                updatedappealRoom.setId(appealid);
                editAppealViewModel.update(updatedappealRoom);
            }
            Toast.makeText(getApplicationContext(),"Appeal updated", Toast.LENGTH_SHORT).show();
            finish();
        });

    }
}