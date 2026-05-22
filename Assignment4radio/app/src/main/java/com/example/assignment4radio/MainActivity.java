package com.example.assignment4radio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView outputDevice,outputFeature;
    RadioButton device;
    RadioGroup rg;
    Button btn;
    CheckBox ch1,ch2,ch3,ch4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            btn=findViewById(R.id.submit);
            rg=findViewById(R.id.device);
            ch1=findViewById(R.id.notification);
            ch2=findViewById(R.id.dark);
            ch3=findViewById(R.id.loc);
            ch4=findViewById(R.id.cloud);
            outputDevice=findViewById(R.id.outputdevice);
            outputFeature=findViewById(R.id.outputfeature);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int SelectedId=rg.getCheckedRadioButtonId();
                    device=findViewById(SelectedId);

                    String deviceoutput=device.getText().toString();
                    outputDevice.setText("Selected Device: " + deviceoutput);


                    String feature=" ";
                    if(ch1.isChecked() == true)
                        feature=ch1.getText().toString();
                    if (ch2.isChecked() == true)
                        feature=feature+" "+ch2.getText().toString();

                    if (ch3.isChecked() == true)
                        feature=feature+" "+ch3.getText().toString();

                    if (ch4.isChecked() == true)
                        feature=feature+" "+ch4.getText().toString();

                    outputFeature.setText("Selected Feature: " + feature);

                }
            });

            return insets;
        });
    }
}