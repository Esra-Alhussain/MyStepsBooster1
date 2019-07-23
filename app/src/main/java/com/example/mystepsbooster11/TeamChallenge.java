package com.example.mystepsbooster11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TeamChallenge extends AppCompatActivity {
    EditText TNameYourChallenge,TStartDate,TEndDate,TLengthOfTheChallenge;
    Button bsave;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_challenge);

        TNameYourChallenge = (EditText) findViewById(R.id.TNameYourChallenge);
        TStartDate = (EditText) findViewById(R.id.TStartDate);
        TEndDate = (EditText) findViewById(R.id.TEndDate);
        TLengthOfTheChallenge = (EditText) findViewById(R.id.TLengthOfTheChallenge);
        bsave = (Button) findViewById(R.id.bsave);

        databaseReference = FirebaseDatabase.getInstance().getReference("TeamCh");



        bsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTeamCh();
            }
        });
    }
    private void addTeamCh(){
        String Tname = TNameYourChallenge.getText().toString().trim();
        String Tstart = TStartDate.getText().toString().trim();
        String Tend = TEndDate.getText().toString().trim();
        String Tlength = TLengthOfTheChallenge.getText().toString().trim();

        if (TextUtils.isEmpty(Tname)) {

            Toast.makeText(this, "Please enter a name of your challenge", Toast.LENGTH_LONG).show();

        } else if (TextUtils.isEmpty(Tstart)) {
            Toast.makeText(this, "Please enter a start date", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(Tend)) {
            Toast.makeText(this, "Please enter an end date", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(Tlength)) {
            Toast.makeText(this, "Please enter a length of the challenge", Toast.LENGTH_LONG).show();
        } else {
            String id = databaseReference.push().getKey();
            TeamCh T = new TeamCh(Tname, Tstart, Tend, Tlength);
            if (id != null) {
                databaseReference.child(id).setValue(T);
                Toast.makeText(this, "Challenge added", Toast.LENGTH_LONG).show();
                //startActivity(new Intent(getApplicationContext(), SearchTeam.class));
            }

        }


    }

    public void back(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}























