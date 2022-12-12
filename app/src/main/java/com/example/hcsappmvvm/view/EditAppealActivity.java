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
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.Room.AppealRoom;
import com.example.hcsappmvvm.model.Appeal;
import com.example.hcsappmvvm.viewmodel.AddAppealViewModel;
import com.example.hcsappmvvm.viewmodel.EditAppealViewModel;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;

public class EditAppealActivity extends AppCompatActivity {

    private EditAppealViewModel editAppealViewModel;
    private TextView titletextview;
    private TextView descriptiontextview;
    private AutoCompleteTextView AddressAppeal;
    private ImageView imageView;
    Uri uriImage;
    int id;
    private String image;
    AppealRoom appealRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_appeal);

        editAppealViewModel = new ViewModelProvider(this).get(EditAppealViewModel.class);

        titletextview = findViewById(R.id.titleappeal);
        descriptiontextview = findViewById(R.id.descriptionappeal);
        AddressAppeal = findViewById(R.id.AppealAddress);
        imageView = findViewById(R.id.imageofappeal);
        CheckBox checkBox = findViewById(R.id.checkBox);




        Button confirmeditbtn = findViewById(R.id.confirmeditBtn);

        ActivityResultLauncher<String[]> getContentimage = getActivityResultRegistry().
                register("key", new ActivityResultContracts.OpenDocument(), result -> {
                    getContentResolver().takePersistableUriPermission(result, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    imageView.setImageURI(result);
                    uriImage = result;
                });


        Intent intent = getIntent();
        if(intent.hasExtra(AddAppealActivity.EXTRA_ID))
        {
            int id = intent.getIntExtra(AddAppealActivity.EXTRA_ID, -1);
            appealRoom = editAppealViewModel.getAppealById(id);
            titletextview.setText(appealRoom.getTitle());
            descriptiontextview.setText(appealRoom.getDescription());
            if(appealRoom.getImage() != null){
                imageView.setImageURI(Uri.parse(appealRoom.getImage()));
            }
            AddressAppeal.setText(appealRoom.getAddress());
            //image = imageView.getDrawable().toString();
            //допилить метод getAppealById(int id)
            //реализовать получение данных
        }

        Button deletebtn = findViewById(R.id.deleteimage);
        deletebtn.setOnClickListener(view -> imageView.setImageDrawable(null));

        confirmeditbtn.setOnClickListener(view -> {
            String titleofappeal = titletextview.getText().toString();
            String descriptionofappeal = descriptiontextview.getText().toString();
            if(titleofappeal.trim().isEmpty() || descriptionofappeal.trim().isEmpty()){
                Toast.makeText(getApplicationContext(),"Please enter title and description", Toast.LENGTH_SHORT).show();
                return;
            }
            if (imageView.getDrawable() != null && uriImage == null){
                String imageforappeal = imageView.toString();
                Appeal updateappeal = new Appeal();
                updateappeal.setAppealTitle(titleofappeal);
                updateappeal.setAppealDescription(descriptionofappeal);
                updateappeal.setImage(imageforappeal);
                String appealAddress = AddressAppeal.getText().toString();
                updateappeal.setAddress(appealAddress);
                updateappeal.setId(appealRoom.getId());
                if(checkBox.isChecked()){
                    updateappeal.setStatus("Accepted");
                } else {
                    updateappeal.setStatus("Rejected");
                }
                editAppealViewModel.update(updateappeal);
            } else if(imageView.getDrawable() != null && uriImage != null){
                image = uriImage.toString();
                Appeal updateappeal = new Appeal();
                updateappeal.setAppealTitle(titleofappeal);
                updateappeal.setAppealDescription(descriptionofappeal);
                updateappeal.setImage(image);
                String appealAddress = AddressAppeal.getText().toString();
                updateappeal.setAddress(appealAddress);
                updateappeal.setId(appealRoom.getId());
                if(checkBox.isChecked()){
                    updateappeal.setStatus("Accepted");
                } else {
                    updateappeal.setStatus("Rejected");
                }
                editAppealViewModel.update(updateappeal);
            } else if (imageView.getDrawable() == null && uriImage != null){
                image = uriImage.toString();
                Appeal updateappeal = new Appeal();
                updateappeal.setAppealTitle(titleofappeal);
                updateappeal.setAppealDescription(descriptionofappeal);
                updateappeal.setImage(image);
                String appealAddress = AddressAppeal.getText().toString();
                updateappeal.setAddress(appealAddress);
                updateappeal.setId(appealRoom.getId());
                if(checkBox.isChecked()){
                    updateappeal.setStatus("Accepted");
                } else {
                    updateappeal.setStatus("Rejected");
                }
                editAppealViewModel.update(updateappeal);
            } else {
                Appeal updateappeal = new Appeal();
                updateappeal.setAppealTitle(titleofappeal);
                updateappeal.setAppealDescription(descriptionofappeal);
                updateappeal.setImage(image);
                String appealAddress = AddressAppeal.getText().toString();
                updateappeal.setAddress(appealAddress);
                updateappeal.setId(appealRoom.getId());
                if(checkBox.isChecked()){
                    updateappeal.setStatus("Accepted");
                } else {
                    updateappeal.setStatus("Rejected");
                }
                editAppealViewModel.update(updateappeal);
            }
            Toast.makeText(getApplicationContext(),"Appeal updated", Toast.LENGTH_SHORT).show();
            finish();
        });


    }
}