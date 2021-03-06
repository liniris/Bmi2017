package com.iris.bmi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    View.OnClickListener listener = new View.OnClickListener() {//新增Onclick類別
        @Override
        public void onClick(View view) {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Bmi")
                .setMessage("BMI原來的設計是一個用於公眾健康研究的統計工具。當需要知道肥胖是否為某一疾病的致病原因時，可以把病人的身高及體重換算成BMI，再找出其數值及病發率是否有線性關連。由於BMI主要反應整體體重，無法區別體重中體脂肪組織與非脂肪組織（包括肌肉、器官），同樣身高體重的人可算出相同的BMI，但其實脂肪量不同[1]，因此其實BMI是整體營養狀態的指標。以往拿來做為肥胖的指標，是因發現BMI與體脂肪在統計上有高度相關；但在同樣BMI之下，仍會有體脂肪率的差異。")
                .setPositiveButton("OK",null)
                .show();
        }
    };//要分號
    private EditText edWeight;
    private EditText edHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getResources().getString(R.string.app_name);//得字串
        Button btHelp = (Button)findViewById(R.id.b_help);//匿名類別
        btHelp.setOnClickListener(listener);
        /*btHelp.setOnClickListener(new View.OnClickListener()){
            @Override
            public void onClick(View view){
            }
        }*/
        findViews();
        Log.d("MainActivity","onCreate");
    }

    private void findViews() {//ctrl+Alt+M
        edWeight = (EditText) findViewById(R.id.ed_weight);//ctrl+Alt+F 區域變數
        edHeight = (EditText) findViewById(R.id.ed_height);
    }

    public void bmi(View view){
    //    System.out.println("what??????");
       // Log.d("MainActivity","testing bmi method");
        findViews();
        float weight = Float.parseFloat(edWeight.getText().toString());
        float height = Float.parseFloat(edHeight.getText().toString());
        float bmi = weight/(height*height);

        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("BMI_RESULT" , bmi);
        startActivity(intent);

       // Log.d("MainActivity","calculate bmi");//
       /* if (bmi<20 && height<3){
            new AlertDialog.Builder(this)
                    .setMessage("您的BMI: "+bmi+"請多吃點")
                    .setPositiveButton(R.string.ok,null)
                    .setTitle("title")
                    .show();
        }else if (height>3) {
            new AlertDialog.Builder(this)
                    .setMessage("身高單位應為公尺")
                    .setPositiveButton(R.string.ok,null)
                    .show();

        }else if (height<3){
            new AlertDialog.Builder(this)
                    .setMessage("您的BMI: "+bmi)
                    .setPositiveButton(R.string.ok,null)
                    .setTitle("title")
                    .show();
        }*/




       /* new AlertDialog.Builder(this)
                .setMessage(getString(R.string.your_bmi_is)+bmi)//有加int不能直接R
                .setPositiveButton(R.string.ok,null)
                .setTitle(R.string.my_title)//可支援字串和int可直接R
                .show();*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","onRestart");
    }
}
