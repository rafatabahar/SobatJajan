package id.ac.telkomuniversity.dph3a4.sobatjajan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import id.ac.telkomuniversity.dph3a4.sobatjajan.R;

public class LoginActivity extends AppCompatActivity {
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup = findViewById(R.id.linkSignUp);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (LoginActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });
    }
}
