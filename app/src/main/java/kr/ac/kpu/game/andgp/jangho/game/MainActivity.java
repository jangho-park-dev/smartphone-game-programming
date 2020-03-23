package kr.ac.kpu.game.andgp.jangho.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    // public static final String TAG = "MainActivity";  // 원래는 이건데,
    // 클래스가 rename되면 곤란한 상황이 있어 클래스의 심플 네임을 받아오는 함수로 설정하는 방법도 좋다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 로깅하는 방법 ( 디버그 에러 인포 버보즈 워닝 d e i v w )
        // 태그는 클래스 이름
        Log.d(TAG, "Message from onCreate()");

        TextView tv = findViewById(R.id.textView3);   // 모든 뷰를 돌아다니면서 id가 텍스트뷰3인 아이를 찾는다.
        tv.setText("Launched");


    }

    // 첫번째 버튼을 눌렀을 때 두번째 텍스트 뷰가 바뀌게 하는, 이 함수가 불리게 할 것임.
    public void onBtnFirst(View v) {
        Log.d(TAG, "onBtnFirst");
        TextView tv = findViewById(R.id.textView2Message);
        tv.setText("First Button Pressed");

        ImageView iv = findViewById(R.id.catImageView);
        iv.setImageResource(R.mipmap.cat1);
    }

    public void onBtnSecond(View view) {
        ImageView iv = findViewById(R.id.catImageView);
        iv.setImageResource(R.mipmap.cat2);

        Random random = new Random();
        final int value = random.nextInt(100) + 1;
        
        final TextView tv = findViewById(R.id.textView2Message);
        tv.setText("Random number: " + value);

        // 타이머
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv.setText("Timer has changed: " + (value + 100));
            }
        }, 1000);
    }

    public void onBtnThird(View view) {
        TextView tv = findViewById(R.id.textView);

        int count = 0;
        try {
            count = Integer.parseInt((String) tv.getText());
        } catch (Exception e) {

        }
        ++count;

        tv.setText(String.valueOf(count));

        // 메시지 박스같은 얼러트 다이얼로그

        // AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // builder.setTitle("hello");
        // builder.setMessage("world");
        // AlertDialog dlg = builder.create();
        // dlg.show();

        new AlertDialog.Builder(this)
                .setTitle("Hello")
                .setMessage("World")
                .setPositiveButton("hahaha", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        TextView tv = findViewById(R.id.textView2Message);
                        tv.setText("hahaha dialog button pressed");
                    }
                })
                .setNegativeButton("Noooo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        TextView tv = findViewById(R.id.textView2Message);
                        tv.setText("Noooo dialog button pressed");
                    }
                })
                .create()
                .show();
    }

}