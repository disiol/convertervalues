package com.conti.convertervalues;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";//тег для лога
    private EditText inputEditText;
    private RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convector);

        inputEditText = (EditText) findViewById(R.id.editText);
        radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);

        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (inputEditText.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), R.string.text_if_edit_text_is_empty,
                            Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue = Float.parseFloat(inputEditText.getText().toString());

                switch (checkedId) {

                    case R.id.radioButtonGToS:
                        inputEditText.setText(String
                                .valueOf(convert₴To$(inputValue)));
                        Log.d(TAG, "radioButtonGToS");
                        break;

                    case R.id.radioButtonSToG:
                        inputEditText.setText(String
                                .valueOf(convert$To₴(inputValue)));
                        Log.d(TAG, "radioButtonSToG");

                        break;

                    case R.id.radioButtonCToF:
                        inputEditText.setText(String
                                .valueOf(convertCToF(inputValue)));
                        Log.d(TAG, "radioButtonCToF");

                        break;
                    case R.id.radioButtonFToC:
                        inputEditText.setText(String
                                .valueOf(convertFToC(inputValue)));
                        Log.d(TAG, "radioButtonCToF");

                        break;
                    case R.id.radioButtonMinutesToHour:
                        inputEditText.setText(String
                                .valueOf(convertMinutesToHour(inputValue)));
                        Log.d(TAG, "radioButtonMinutesToHour");

                        break;

                    case R.id.radioButtonHourToMinutes:
                        inputEditText.setText(String
                                .valueOf(convertHourToMinutes(inputValue)));
                        Log.d(TAG, "radioButtonHourToMinutes");
                        break;

                    case R.id.radioButtonKgToMg:
                        inputEditText.setText(String
                                .valueOf(convertKgToMg(inputValue)));
                        Log.d(TAG, "radioButtonKgToMg");

                        break;
                    case R.id.radioButtonMgToKg:
                        inputEditText.setText(String
                                .valueOf(convertMgToKg(inputValue)));
                        Log.d(TAG, "radioButtonMgToKg");
                        break;

                }
            }
        });
    }


    private double convertMgToKg(float inputValue) {
        return inputValue / 1000;
    }

    private double convertKgToMg(double inputValue) {
        return inputValue * 1000;
    }

    private float convertHourToMinutes(float inputValue) {
        return inputValue * 60;
    }

    private float convertMinutesToHour(float inputValue) {

        return inputValue / 60;
    }

    private double convertFToC(float inputValue) {
        return (inputValue - 32) / 1.8;
    }

    private double convertCToF(float inputValue) {
        return (inputValue * 1.8) + 32;
    }

    private double convert₴To$(float inputValue) {
        return inputValue * 24.6682;
    }

    private double convert$To₴(float inputValue) {
        return inputValue * 24.5000;
    }

    public void onClick(View view) {
        inputEditText.setText("");
        radioGroup.clearCheck();// очищает выбор

    }
}
