package com.example.pratice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.Tv);
        SharedPreferences sharedPreferences = getSharedPreferences("sFile", MODE_PRIVATE);
        String text = sharedPreferences.getString("text", "");
        textView.setText(text);
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences sharedPreferences = getSharedPreferences("sFile",MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        String text = editText.getText().toString();
        editor.putString("text", text);

        editor.commit();
    }
}