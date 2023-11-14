package com.example.asm_hiking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.asm_hiking.db.DatabaseHelper;

public class AddActivity extends AppCompatActivity {

    EditText location_input, date_input, length_input, difficulty_input, description_input;
    Button add_button;
    RadioGroup parking_radioGroup;
    RadioButton parking_choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        location_input = findViewById(R.id.location_input);
        date_input = findViewById(R.id.date_input);
        length_input = findViewById(R.id.length_input);
        difficulty_input = findViewById(R.id.difficulty_input);
        description_input = findViewById(R.id.description_input);
        parking_radioGroup = (findViewById(R.id.parking_radioGroup));
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = parking_radioGroup.getCheckedRadioButtonId();

                DatabaseHelper myDB = new DatabaseHelper(AddActivity.this);
                myDB.addHikeSession(location_input.getText().toString().trim(),
                        Integer.parseInt(date_input.getText().toString().trim()),
                        String.valueOf(parking_choice = findViewById(selectedId)),
                        length_input.getText().toString().trim(),
                        difficulty_input.getText().toString().trim(),
                        description_input.getText().toString().trim()
                );
            }
        });
    }
}