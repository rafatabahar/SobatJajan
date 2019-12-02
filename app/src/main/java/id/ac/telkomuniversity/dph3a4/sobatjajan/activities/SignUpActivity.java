package id.ac.telkomuniversity.dph3a4.sobatjajan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import id.ac.telkomuniversity.dph3a4.sobatjajan.R;

public class SignUpActivity extends AppCompatActivity {
    TextView signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signin = findViewById(R.id.signInLink);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (SignUpActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
