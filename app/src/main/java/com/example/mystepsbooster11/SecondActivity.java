package com.example.mystepsbooster11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firebaseAuth = FirebaseAuth.getInstance();

        //logout = (Button)findViewById(R.id.btnLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });
    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(SecondActivity.this, MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.logoutMenu:{
                Logout();
                break;
            }
            case R.id.challengeTeam:{
                startActivity(new Intent(SecondActivity.this, TeamChallenge.class));
                break;

        }
            case R.id.challengeYourself:{
                startActivity(new Intent(SecondActivity.this, Challengeyourself.class));
                break;

            }

            //case R.id.Freinds:{
             //   startActivity(new Intent(SecondActivity.this, ProfileActivity.class));
              //  break;

           // }

            case R.id.profileMenu:{
                startActivity(new Intent(SecondActivity.this, ProfileActivity.class));
                break;

            }
            case R.id.refreshMenu:{
                startActivity(new Intent(SecondActivity.this, Settings.class));
                break;

            }
        }
        return super.onOptionsItemSelected(item);
    }
}