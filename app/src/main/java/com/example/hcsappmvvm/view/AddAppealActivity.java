package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.model.Appeal;
import com.example.hcsappmvvm.network.retrofit.AppealAPI;
import com.example.hcsappmvvm.network.retrofit.RetrofitService;
import com.example.hcsappmvvm.viewmodel.AddAppealViewModel;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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

        Button savebutton = findViewById(R.id.confirmBtn);

        addAppealViewModel = new ViewModelProvider(this).get(AddAppealViewModel.class);

        //TODO: Реализовать функцию добавления изображения в БД
        /*imageView = findViewById(R.id.Image);
        Button saveimage = findViewById(R.id.addimage);
        ActivityResultLauncher<String[]> getContentimage = getActivityResultRegistry().
                register("key", new ActivityResultContracts.OpenDocument(), result -> {
            getContentResolver().takePersistableUriPermission(result, Intent.FLAG_GRANT_READ_URI_PERMISSION);
            ImageView imageView = findViewById(R.id.Image);
            imageView.setImageURI(result);
            uriImage = result;
        });
        saveimage.setOnClickListener(view -> getContentimage.launch(new String[]{"image/*"}));
        */

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

        RetrofitService retrofitService = new RetrofitService();
        AppealAPI appealAPI = retrofitService.getRetrofit().create(AppealAPI.class);

        savebutton.setOnClickListener(view -> {
            String title = editTextTitle.getText().toString();
            String description = editTextDescription.getText().toString();
            String appealAddress = mAutoCompleteTextView.getText().toString();
            Appeal appeal = new Appeal();
            appeal.setTitle(title);
            appeal.setDescription(description);
            appeal.setAddress(appealAddress);
            if(title.trim().isEmpty() || description.trim().isEmpty() || appealAddress.trim().isEmpty()){
                Toast.makeText(getApplicationContext(),"Please enter title, description and address", Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                appealAPI.saveAppeal(appeal).enqueue(new Callback<Appeal>() {
                    @Override
                    public void onResponse(Call<Appeal> call, Response<Appeal> response) {
                        Toast.makeText(getApplicationContext(),"Appeal saved!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Appeal> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Save failed!", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(AddAppealActivity.class.getName()).log(Level.SEVERE, "Error occurred: ", t);
                    }
                });
            }
            finish();

            //TODO: Реализовать функцию добавления изображения в БД
            /*if(imageView.getDrawable() == null){
                Appeal appeal = new Appeal(title, description,null, appealAddress, null);
                addAppealViewModel.insert(appeal);
            } else{
                image = uriImage.toString();
                Appeal appeal = new Appeal(title, description, image, appealAddress, null);
                addAppealViewModel.insert(appeal);
            }
            Toast.makeText(getApplicationContext(),"Appeal saved", Toast.LENGTH_SHORT).show();
            finish();*/

        });
    }
}
