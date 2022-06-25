package comlandmarkbook.apk.ctyandnamegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     Intent intent;
     Button buttonNormal,buttonTime,buttonExıt,buttonSave;
     SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonNormal=(Button) findViewById(R.id.btnNormal);
        buttonTime=(Button) findViewById(R.id.btnTime);
        buttonExıt=(Button) findViewById(R.id.btnExıt);




    }

    public  void  normal(View view) {
            intent = new Intent(MainActivity.this, NormalGame.class);
            startActivity(intent);

    }
    public  void  time(View view) {
        intent = new Intent(MainActivity.this, Time.class);
        startActivity(intent);

    }
    public  void  exıt(View view) {
        finish();
        System.exit(0);

    }

}