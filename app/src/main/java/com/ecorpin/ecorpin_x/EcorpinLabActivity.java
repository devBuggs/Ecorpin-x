package com.ecorpin.ecorpin_x;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import de.hdodenhof.circleimageview.CircleImageView;

public class EcorpinLabActivity extends AppCompatActivity {

    Toolbar mToolbar;

    CircleImageView user_profile_image;
    TextView user_name;
    TextView user_type;

    private FirebaseAuth mAuth;
    //private DatabaseReference mReferenceDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecorpin_lab);

        mToolbar = (Toolbar) findViewById(R.id.eclorpinlabtoolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Ecorpin Lab. </>");

        // Firebase Auth
        //mAuth = FirebaseAuth.getInstance();

        user_profile_image = (CircleImageView) findViewById(R.id.userProfile_image);

        user_name = (TextView) findViewById(R.id.user_name);

        user_type = (TextView) findViewById(R.id.user_type);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser == null) {
            sendForAuth();
        }
    }

    private void sendForAuth() {
        Intent intent = new Intent(EcorpinLabActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    // Function for Creating Options Menu -- Ecorpin Lab. Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.ecorpinlab_menu, menu);
        return true;
    }

    // Function for operating Options Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_notification:
                // User click the "Notification" icon, check out hot deals here...
                return true;

            case R.id.action_settings:
                // User choose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_privacy:
                // User choose the "Privacy policy" item, read our data privacy and policy
                return true;

            case R.id.action_feedback:
                // User choose the "Feedback" item, manage the feedback operation with System Log file or Bug Report.
                return true;

            case R.id.action_logout:
                // User choose the "Logout" item, manage logout operation
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}
