package com.example.mystepsbooster11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.lang.String.valueOf;

public class Challengeyourself extends AppCompatActivity {


    EditText NameYourChallenge,StartDate,EndDate,DailyStepGoal,LengthOfTheChallenge;
    Button savedata;
    DatabaseReference databasechyourself;
    long maxid =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challengeyourself);

        NameYourChallenge = (EditText) findViewById(R.id.NameYourChallenge);
        DailyStepGoal = (EditText) findViewById(R.id.DailyStepGoal);
        StartDate = (EditText) findViewById(R.id.StartDate);
        EndDate = (EditText) findViewById(R.id.EndDate);
        LengthOfTheChallenge = (EditText) findViewById(R.id.LengthOfTheChallenge);
        savedata = (Button) findViewById(R.id.savedata);
        databasechyourself= FirebaseDatabase.getInstance().getReference("CHYourself");

        databasechyourself.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                    maxid= (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCHYourself();

            }
        });
    }
    private void addCHYourself(){

        String name = NameYourChallenge.getText().toString().trim();
        String step =  DailyStepGoal.getText().toString().trim();
        String start = StartDate.getText().toString().trim();
        String end =  EndDate.getText().toString().trim();
        String length =  LengthOfTheChallenge.getText().toString().trim();




        if (TextUtils.isEmpty(name)) {

            Toast.makeText(this, "Please enter a name of your challenge", Toast.LENGTH_LONG).show();

        } else if (TextUtils.isEmpty(step)) {
            Toast.makeText(this, "Please enter a daily step goal", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(start)) {
            Toast.makeText(this, "Please enter a start date", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(end)) {
            Toast.makeText(this, "Please enter an end date", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(length)) {
            Toast.makeText(this, "Please enter a length of the challenge", Toast.LENGTH_LONG).show();}



        else {
            String id = databasechyourself.push().getKey();
            CHYourself chyourself = new CHYourself(name,start,end,step,length);
            if (id != null) {
                databasechyourself.child(valueOf(maxid + 1)).setValue(chyourself);
                Toast.makeText(this, "Challenge added", Toast.LENGTH_LONG).show();
               // startActivity(new Intent(Challengeyourself.this, ChallengeInfo.class));
                finish();

            }

        }










    }

    public void back(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}




