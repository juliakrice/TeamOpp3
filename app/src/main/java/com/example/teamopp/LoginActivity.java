package com.example.teamopp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG= "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    private FirebaseAuth mAuth;



// she is doing login
// he ih doing the layouts for all the pages




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

















































        //     if (ParseUser.getCurrentUser() != null){
        //        goMainActivity();
        //    }

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);


//TODO: Move progress bar for placeholder when loading image + layout from login.xml
        // on some click or some loading we need to wait for...
        ProgressBar pb = (ProgressBar) findViewById(R.id.pbLoading);
        pb.setVisibility(ProgressBar.VISIBLE);
        // run a background job and once complete
        pb.setVisibility(ProgressBar.INVISIBLE);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username, password);

            }
        });



        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);





    }

    private void loginUser(String username, String password) {
        Log.i(TAG, "Attempting to login user " + username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if ( e != null) {
                    Log.e(TAG, "Issue with login", e);
                    Toast.makeText(LoginActivity.this, "Issue with log in", Toast.LENGTH_SHORT).show();
                    return;
                }
                //TODO: navigate to the main activity if the user has signed in properly
                goMainActivity();
                Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT).show();


            }
        });

    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}