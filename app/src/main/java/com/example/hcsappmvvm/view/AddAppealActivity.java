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
import com.example.hcsappmvvm.model.Appeal;
import com.example.hcsappmvvm.viewmodel.AddAppealViewModel;
import com.example.hcsappmvvm.viewmodel.AppealsViewModel;


public class AddAppealActivity extends AppCompatActivity {
    public static final String EXTRA_ID =
            "com.example.hcsappmvvm.view.EXTRA_ID";

    Uri uriImage;
    private EditText editTextTitle;
    private EditText editTextDescription;
    private ImageView imageView;
    private AddAppealViewModel addAppealViewModel;
    private String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appeal);

        editTextTitle = findViewById(R.id.TitleOfAppeal);
        editTextDescription = findViewById(R.id.AppealDescription);
        imageView = findViewById(R.id.Image);

        Button savebutton = findViewById(R.id.confirmBtn);
        Button saveimage = findViewById(R.id.addimage);

        addAppealViewModel = new ViewModelProvider(this).get(AddAppealViewModel.class);


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
            if(title.trim().isEmpty() || description.trim().isEmpty()){
                Toast.makeText(getApplicationContext(),"Please enter title and description", Toast.LENGTH_SHORT).show();
                return;
            }
            if(imageView.getDrawable() == null){
                Appeal appeal = new Appeal(title, description,null);
                addAppealViewModel.insert(appeal);
            } else{
                image = uriImage.toString();
                Appeal appeal = new Appeal(title, description, image);
                addAppealViewModel.insert(appeal);
            }
            Toast.makeText(getApplicationContext(),"Appeal saved", Toast.LENGTH_SHORT).show();
            finish();

        });
    }
}
