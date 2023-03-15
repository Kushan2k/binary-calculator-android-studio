package mad.sltc.lk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private EditText question,anser;
    private TextView dec;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        question=findViewById(R.id.questiontxt);
        anser=findViewById(R.id.anstxt);
        dec=findViewById(R.id.decans);

    }

    public void numberTapped(View view) {

        switch (view.getId()){
            case R.id.num1btn:
                question.setText(question.getText().toString()+"1");
                break;
            case R.id.num0btn:
                question.setText(question.getText().toString()+"0");
                break;
        }
    }

    public void addButtonTapped(View view) {

        question.setText(question.getText().toString()+"+");


    }

    public void clearButtonTapped(View view){

        question.setText("");
        dec.setText(String.valueOf(0));
        anser.setText("");

    }

    public void convertButtonTapped(View view){

        if(question.getText().toString().isEmpty()){
            Toast.makeText(this,"Expression is empty!",Toast.LENGTH_SHORT).show();
            return;
        }

        List<Integer> number=new ArrayList<>();

        for(String slice:question.getText().toString().split("[+]")){
            number.add(Integer.parseInt(slice,2));
        }
        int total=0;


        for(Integer t:number){
            total+=t;
        }

        if(view.getId()==R.id.equlbtn){
            anser.setText(Integer.toBinaryString(total));
        }else{
            dec.setText(String.valueOf(total));
        }



    }


}