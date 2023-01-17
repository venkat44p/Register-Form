package com.example.feedbackform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    TextInputLayout name, phone, caste, subCaste, education, employment, epicNum, serialNum;
    TextInputLayout partNum, boothName, wardName, constitution, city, council, address, postalNum;
    TextInputLayout family, totalVotes, politicalParty, schemes;

    TextInputEditText nameEt, phoneEt, epicNumEt, serialNumEt, partNumEt, addressEt;
    TextInputEditText postalNumEt, totalVotesEt;

    AutoCompleteTextView casteTv, subCasteTv, educationTv, employmentTv, boothNameTv, wardNameTv;
    AutoCompleteTextView constitutionTv, cityTv, councilTv, familyTv, politicalPartyTv, schemesTv;

    ImageView date;
    TextView age;
    private int year, month, day;
    Button maleBtn, femaleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = findViewById(R.id.date);
        age = findViewById(R.id.age);

        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog picker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        age.setText(day+"/"+(month+1)+"/"+year);
                    }
                }, year, month,day);
                picker.show();
            }
        });


    }
}