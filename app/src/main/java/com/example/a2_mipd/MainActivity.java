package com.example.a2_mipd;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a2_mipd.Counter; // Replace with the correct package name

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Spinner spinner;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        spinner = findViewById(R.id.spinner);
        resultText = findViewById(R.id.resultText);

        // Set up the Spinner with counting options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.counting_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void countText(View view) {
        String text = editText.getText().toString();
        int selectedPosition = spinner.getSelectedItemPosition();

        if (text.isEmpty()) {
            Toast.makeText(this, "Input text is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        int count;
        if (selectedPosition == 0) { // Words
            count = Counter.getWordCount(text);
        } else { // Characters
            count = Counter.getCharacterCount(text);
        }

        resultText.setText(getString(R.string.result, count));
    }
}
