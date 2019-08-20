package com.example.apppertama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtWidth;
    private EditText edtHeight;
    private EditText edtLenght;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLenght = findViewById(R.id.edt_length);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btn_calculate){
            String inputLenght = edtLenght.getText().toString().trim();
            String inputWidht = edtWidth.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputLenght)){
                isEmptyFields = true;
                edtLenght.setError("field Tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputWidht)){
                isEmptyFields = true;
                edtWidth.setError("field Tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true;
                edtHeight.setError("field Tidak boleh kosong");
            }

            Double lenght = toDouble(inputLenght);
            Double width = toDouble(inputWidht);
            Double height = toDouble(inputHeight);

            if (lenght == null){
                isInvalidDouble = true;
                edtLenght.setError("harus Berupa nomor yang valid");
            }
            if (width == null){
                isInvalidDouble = true;
                edtWidth.setError("harus Berupa nomor yang valid");
            }
            if (height == null){
                isInvalidDouble = true;
                edtHeight.setError("harus Berupa nomor yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble){
                double volume = lenght * width * height;
                tvResult.setText(String.valueOf(volume));
            }
        }
    }

    private Double toDouble(String str) {
        try{
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
}


