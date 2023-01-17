package com.example.feedbackform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {

    TextInputLayout name, phone, caste, subCaste, education, employment, epicNum, serialNum;
    TextInputLayout partNum, boothName, wardName, constitution, city, council, address, postalNum;
    TextInputLayout family, totalVotes, politicalParty, schemes;

    TextInputEditText nameEt, phoneEt, epicNumEt, serialNumEt, partNumEt, addressEt;
    TextInputEditText postalNumEt, totalVotesEt;

    AutoCompleteTextView casteTv, subCasteTv, educationTv, employmentTv, boothNameTv, wardNameTv;
    AutoCompleteTextView constitutionTv, cityTv, councilTv, familyTv, politicalPartyTv, schemesTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}