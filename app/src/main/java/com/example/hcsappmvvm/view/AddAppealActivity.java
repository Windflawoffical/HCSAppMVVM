package com.example.hcsappmvvm.view;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.Toast;

import com.example.hcsappmvvm.R;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appeal);

        editTextTitle = findViewById(R.id.TitleOfAppeal);
        editTextDescription= findViewById(R.id.AppealDescription);

        Button savebutton = findViewById(R.id.confirmBtn);
        Button saveimage = findViewById(R.id.addimage);

        ActivityResultLauncher<String[]> getContentimage = getActivityResultRegistry().register("key", new ActivityResultContracts.OpenDocument(), result -> {
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
            Intent data = new Intent();
            data.putExtra(AddAppealActivity.EXTRA_TITLE,title);
            data.putExtra(AddAppealActivity.EXTRA_DESCRIPTION,description);
            data.putExtra(AddAppealActivity.EXTRA_IMAGE, image);
            int id = getIntent().getIntExtra(EXTRA_ID, -1);
            if(id != -1){
                data.putExtra(EXTRA_ID,id);
            }
            setResult(RESULT_OK,data);
            finish();
        });


        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_ID)){
            editTextTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            editTextDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));

        }
    }
}
