package com.example.hcsappmvvm.view;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.Room.AppealRoom;
import com.example.hcsappmvvm.viewmodel.AppealsViewModel;


public class AddAppealActivity extends AppCompatActivity {
    public static final String EXTRA_ID =
            "com.example.hcsappmvvm.view.EXTRA_ID";
    public static final String EXTRA_TITLE =
            "com.example.hcsappmvvm.view.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "com.example.hcsappmvvm.view.EXTRA_DESCRIPTION";
    public static final String EXTRA_IMAGE =
            "com.example.hcsappmvvm.view.EXTRA_IMAGE";

    Uri uriImage;
    private EditText editTextTitle;
    private EditText editTextDescription;
    private ImageView imageView;
    private AppealsViewModel appealsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appeal);

        editTextTitle = findViewById(R.id.TitleOfAppeal);
        editTextDescription = findViewById(R.id.AppealDescription);
        imageView = findViewById(R.id.Image);


        Button savebutton = findViewById(R.id.confirmBtn);
        Button saveimage = findViewById(R.id.addimage);

        appealsViewModel = new ViewModelProvider(this).get(AppealsViewModel.class);

        ActivityResultLauncher<String[]> getContentimage = getActivityResultRegistry().
                register("key", new ActivityResultContracts.OpenDocument(), result -> {
            getContentResolver().takePersistableUriPermission(result, Intent.FLAG_GRANT_READ_URI_PERMISSION);
            ImageView imageView = findViewById(R.id.Image);
            imageView.setImageURI(result);
            uriImage = result;
        });

        saveimage.setOnClickListener(view -> getContentimage.launch(new String[]{"image/*"}));

        savebutton.setOnClickListener(view -> {
            String title = editTextTitle.getText().toString();
            String description = editTextDescription.getText().toString();
            String image = uriImage.toString();
            if(title.trim().isEmpty() || description.trim().isEmpty()){
                Toast.makeText(getApplicationContext(),"Please enter title and description", Toast.LENGTH_SHORT).show();
                return;
            }
            AppealRoom appealRoom = new AppealRoom(title, description, image);
            appealsViewModel.insert(appealRoom);
            finish();
        });
    }
}
