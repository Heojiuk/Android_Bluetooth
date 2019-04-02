package com.example.heoju.smart_4_1;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btnYes);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.btnNo);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.btnTransfer);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.chkBox_Always_On);
        button.setOnClickListener(this);

        SeekBar seekBar_Bright = (SeekBar) findViewById(R.id.seekBar_Bright);
        seekBar_Bright.setOnSeekBarChangeListener(this);
        seekBar_Bright.setMax(1000);
    }

    @Override
    public void onClick(View v) {
        String str = new String();

        switch (v.getId()) {
            case R.id.btnYes:
                str = "\"예\"버튼을 눌렀습니다.";
                break;
            case R.id.btnNo:
                str = "\"아니오\"버튼을 눌렀습니다.";
                break;
            case R.id.btnTransfer:
                str = "\"전송\"버튼을 눌렀습니다.";

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("전송 문자열");
                EditText edtStr = (EditText) findViewById(R.id.edtStr);
                String dialogStr = String.valueOf(edtStr.getText());
                builder.setMessage(dialogStr);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("OK", null);
                builder.setNegativeButton("CANCLE", null);

                AlertDialog alter = builder.create();
                alter.show();
                break;

            case R.id.chkBox_Always_On:
                CheckBox checkBox = (CheckBox) findViewById(R.id.chkBox_Always_On);

                if (checkBox.isChecked()) checkBox.setText("항상켜기");
                else checkBox.setText("항상 켜지 않기");

                str = "체크박스를 눌렀습니다.";
                break;
        }
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
    }

    @Override //움직였을때 이벤트 처리
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    Toast.makeText(getApplicationContext(), "밝기가 변경되었습니다.",Toast.LENGTH_SHORT).show();

    String str = String.valueOf(progress);
    EditText edtText = (EditText) findViewById(R.id.edtStr);
    edtText.setText(str);
    }

    @Override //터치했을때 이벤트 처리
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override //멈췄을때 이벤트 처리
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
