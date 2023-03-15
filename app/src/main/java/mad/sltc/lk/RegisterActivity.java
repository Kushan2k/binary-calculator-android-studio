package mad.sltc.lk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText fname,lname,email,password,conformpass;
    private Button singup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fname=findViewById(R.id.fname);
        lname=findViewById(R.id.lname);
        email=findViewById(R.id.emailtxt);
        password=findViewById(R.id.passwordtxt);
        conformpass=findViewById(R.id.conpasstxt);
        singup=findViewById(R.id.subtn);

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }
    private void register(){
        String firstname,lastname,useremail,userpass,userconpass;
        firstname=fname.getText().toString();
        lastname=lname.getText().toString();
        useremail=email.getText().toString();
        userpass=password.getText().toString();
        userconpass=conformpass.getText().toString();

        if(firstname.isEmpty()){
            fname.setError("First name is needed!");

        }else if(lastname.isEmpty()){
            lname.setError("Last name is required");

        }else if(useremail.isEmpty()){
            email.setError("Email is required");
        }else if(userpass.isEmpty()){
            password.setError("Password is required");
        }else if(userconpass.isEmpty()){
            conformpass.setError("Conform passwrod is required!");
        }else if(!userpass.equals(userconpass)){
            conformpass.setError("Passwords do not match!");
        }else{

            Intent login=new Intent(RegisterActivity.this,LoginActivity.class);
            login.putExtra("EMAIL",useremail);
            login.putExtra("PASS",userpass);

            startActivity(login);
            finish();
        }

    }
}