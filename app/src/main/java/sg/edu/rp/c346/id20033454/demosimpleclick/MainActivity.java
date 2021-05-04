package sg.edu.rp.c346.id20033454.demosimpleclick;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    Button btnDisplay;
    EditText etInput;
    ToggleButton toggleButtonEnabled;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.textViewDisplay);
        btnDisplay = findViewById(R.id.btnDisplay);
        etInput = findViewById(R.id.etInput);
        toggleButtonEnabled = findViewById(R.id.toggleButtonEnabled);
        rgGender = findViewById(R.id.rgGender);


        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringResponse = etInput.getText().toString();
                if (stringResponse.isEmpty()) {
                    tvDisplay.setText("Nothing has been entered");
                    Toast.makeText(MainActivity.this,
                            "Please input something",
                            Toast.LENGTH_SHORT).show();
                } else {
                    int checkedRadioId = rgGender.getCheckedRadioButtonId();
                    if(checkedRadioId == R.id.radioButtonGenderMale){
                        stringResponse = "He says " + stringResponse;
                    }
                    else if(checkedRadioId == R.id.radioButtonGenderFemale){
                        stringResponse = "She says " + stringResponse;

                    }
                    tvDisplay.setText(stringResponse);
                }
            }
        });

        toggleButtonEnabled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButtonEnabled.isChecked()==true){
                    etInput.setEnabled(true);
                    etInput.setBackgroundColor(Color.TRANSPARENT);
                }
                else{
                    etInput.setEnabled(false);
                    etInput.setBackgroundColor(Color.GRAY);
                }








            }
        });



    }
}

