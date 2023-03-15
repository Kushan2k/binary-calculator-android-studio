package mad.sltc.lk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText email,password;

    private Button loginbtn;

    private Intent sender;

    private String useremail,userpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginbtn=findViewById(R.id.loginbtn);
        email=findViewById(R.id.emailtxtlogin);
        password=findViewById(R.id.passwordtxtlogin);

        sender=getIntent();
        useremail=sender.getStringExtra("EMAIL");
        userpass=sender.getStringExtra("PASS");





        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login(){
        if(useremail.equals(email.getText().toString()) && userpass.equals(password.getText().toString())){

            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            finish();
        }else{
            email.setError("Do not match");
            password.setError("Do Not match");
        }
    }
}