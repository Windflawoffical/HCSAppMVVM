package com.example.hcsappmvvm.view;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.Room.AppealRoom;
import com.example.hcsappmvvm.model.Appeal;
import com.example.hcsappmvvm.viewmodel.AddAppealViewModel;
import com.example.hcsappmvvm.viewmodel.AppealsViewModel;

import java.util.List;


public class AddAppealActivity extends AppCompatActivity {
    public static final String EXTRA_ID =
            "com.example.hcsappmvvm.view.EXTRA_ID";

    Uri uriImage;
    private EditText editTextTitle;
    private EditText editTextDescription;
    private EditText editTextAddress;
    private ImageView imageView;
    private AddAppealViewModel addAppealViewModel;
    private String image;
    AutoCompleteTextView mAutoCompleteTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appeal);

        editTextTitle = findViewById(R.id.TitleOfAppeal);
        editTextDescription = findViewById(R.id.AppealDescription);
        mAutoCompleteTextView = findViewById(R.id.AppealAddress);
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

        mAutoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                addAppealViewModel.getAddressList(s.toString()).observe(AddAppealActivity.this, (List<String> values) -> {
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                            getApplicationContext(), android.R.layout.simple_list_item_1,values);
                    arrayAdapter.getFilter().filter(null);
                    mAutoCompleteTextView.setAdapter(arrayAdapter);
                });
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        saveimage.setOnClickListener(view -> getContentimage.launch(new String[]{"image/*"}));

        savebutton.setOnClickListener(view -> {
            String title = editTextTitle.getText().toString();
            String description = editTextDescription.getText().toString();
            String appealAddress = mAutoCompleteTextView.getText().toString();
            if(title.trim().isEmpty() || description.trim().isEmpty() || appealAddress.trim().isEmpty()){
                Toast.makeText(getApplicationContext(),"Please enter title, description and address", Toast.LENGTH_SHORT).show();
                return;
            }
            if(imageView.getDrawable() == null){
                Appeal appeal = new Appeal(title, description,null, appealAddress);
                addAppealViewModel.insert(appeal);
            } else{
                image = uriImage.toString();
                Appeal appeal = new Appeal(title, description, image, appealAddress);
                addAppealViewModel.insert(appeal);
            }
            Toast.makeText(getApplicationContext(),"Appeal saved", Toast.LENGTH_SHORT).show();
            finish();

        });
    }
}
