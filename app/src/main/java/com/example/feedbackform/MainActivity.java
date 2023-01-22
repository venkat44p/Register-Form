package com.example.feedbackform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextInputLayout nameInputLayout,phoneInputLayout,casteInputLayout;

    private TextInputEditText nameEditText,phoneEditText;

    private AutoCompleteTextView casteTextView;

    TextInputLayout subCaste, education, employment, epicNum, serialNum;
    TextInputLayout partNum, boothName, wardName, constitution, city, council, address, postalNum;
    TextInputLayout family, totalVotes, politicalParty, schemes;

    TextInputEditText epicNumEt, serialNumEt, partNumEt, addressEt;
    TextInputEditText postalNumEt, totalVotesEt;

    AutoCompleteTextView subCasteTv, educationTv, employmentTv, boothNameTv, wardNameTv;
    AutoCompleteTextView constitutionTv, cityTv, councilTv, familyTv, politicalPartyTv, schemesTv;

    ImageView date;
    TextView age;
    private int year, month, day;
    Button maleBtn, femaleBtn;

    String[] city_array = { "Bangalore", "Tumkur", "Chitradurga", "Hassan", "Mandya", "Mysore" };
    String[] caste_array = {"Brahmin", "Kshatriya", "Vaishya", "Shudra", "Other"};
    String[] subCaste_array = {"Choose Sub-caste","subCaste1"};
    String[] education_array = {"Choose Education","BSC","BE","BCom"};
    String[] party_array = {"Congress","BJP","JDS","AAP","CPI","NEUTRAL"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Name Hooks
        nameInputLayout = findViewById(R.id.name);
        nameEditText = findViewById(R.id.nameEt);

        //Phone Hooks
        phoneInputLayout = findViewById(R.id.phone);
        phoneEditText =findViewById(R.id.phoneEt);

        date = findViewById(R.id.date);
        age = findViewById(R.id.age);

        cityTv = findViewById(R.id.cityTv);
        cityTv.setOnItemSelectedListener(MainActivity.this);
        casteTextView = findViewById(R.id.casteTv);
        subCasteTv = findViewById(R.id.subCasteTv);
        educationTv = findViewById(R.id.educationTv);
        politicalPartyTv = findViewById(R.id.politicalPartyTv);


        //Name Validation

        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!isValidName(s.toString())) {
                    nameInputLayout.setError("Invalid name format");
                } else {
                    nameInputLayout.setError(null);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        // Phone Validation

        phoneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!isValidPhoneNumber(s.toString())) {
                    phoneInputLayout.setError("Invalid phone number");
                } else {
                    phoneInputLayout.setError(null);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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

        ArrayAdapter partyAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, party_array);
        partyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        politicalPartyTv.setAdapter(partyAdapter);

        ArrayAdapter cityAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, city_array);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cityTv.setAdapter(cityAdapter);

        ArrayAdapter casteAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, caste_array);
        casteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        casteTextView.setAdapter(casteAdapter);

        ArrayAdapter subcasteAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, subCaste_array);
        subcasteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subCasteTv.setAdapter(subcasteAdapter);

        ArrayAdapter educationAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, education_array);
        educationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        educationTv.setAdapter(educationAdapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // Button Click
    public void callSignUpScreen(View view) {
        // Perform the action you want when the button is clicked
        // For example, start a new activity:
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    private boolean isValidName(String name) {
        // Validation logic
        return name.matches("[A-Z][a-zA-Z]*");
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Validation logic
        return android.util.Patterns.PHONE.matcher(phoneNumber).matches();
    }

}