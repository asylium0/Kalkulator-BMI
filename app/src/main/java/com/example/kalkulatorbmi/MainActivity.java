package com.example.kalkulatorbmi;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etWeight;
    EditText etHeight;
    Button btnCalculate;
    TextView tvBMI;
    TextView tvBMICategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCalculate =  findViewById(R.id.btnCalculate);
        tvBMI = findViewById(R.id.tvBMI);
        tvBMICategory = findViewById(R.id.tvBMICategory);

        btnCalculate.setOnClickListener(v -> Calculate());

    }
    private void Calculate(){
        String Cat;
        String HeightStr = etHeight.getText().toString().trim();
        String WeightStr = etWeight.getText().toString().trim();
        if (HeightStr.isEmpty() || WeightStr.isEmpty()){
            Toast.makeText(this, R.string.error_wrong_data, Toast.LENGTH_SHORT).show();
            return;
        }
        Double Height = Double.parseDouble(HeightStr);
        Double Weight = Double.parseDouble(WeightStr);
        if (Height <= 0 || Weight <= 0){
            Toast.makeText(this, R.string.error_wrong_data, Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("MainActivity", "height = " + Height + " weight = " + Weight);
        double BMI = Weight/(Height/100*Height/100);
        Log.d("MainActivity", "BMI = " + BMI);
        String BMIString = String.format("%.1f", BMI);

        tvBMI.setText(getString(R.string.BMI_txt, BMIString));

        if(BMI < 18.5){
            Cat = getString(R.string.BMI_under);
        }else if (BMI >= 25){
            Cat = getString(R.string.BMI_over);
        }else {
            Cat = getString(R.string.BMI_normal);
        }

        tvBMICategory.setText(getString(R.string.BMI_cat_txt, Cat));
    }
}