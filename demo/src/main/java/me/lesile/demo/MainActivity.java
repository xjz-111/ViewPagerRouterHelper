package me.lesile.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn1;
    private Button btn2;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        random = new Random();

    }

    @Override
    public void onClick(View v) {
        if (v == btn1){
            jump(0);
        }else if (v == btn2){
            jump(random.nextInt(3) + 1);
        }
    }

    private void jump(int defaultposition){
        Intent intent = new Intent(this, MActivity.class);
        intent.putExtra("fragment_name", getPackageName() + "." + MFragment.class.getSimpleName());
        intent.putExtra("position", defaultposition);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }
}
