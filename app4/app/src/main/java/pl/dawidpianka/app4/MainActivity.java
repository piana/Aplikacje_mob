package pl.dawidpianka.app4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    List<String> semestry;
    String semester = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // dodanie stringów oznaczających każdy kolejny semestr do listy semestrów
        semestry = new ArrayList<>();
        for(int i = 1; i <= 7; i++) {
            semestry.add("Semestr " + String.valueOf(i));
        }

        // lista rozwijana
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, semestry));
        spinner.setOnItemSelectedListener(onItemSelectedListener);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(onButtonClick);
    }

    private AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            semester = semestry.get(position); // zapisanie klikniętego semestru do zmiennej
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private View.OnClickListener onButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // jeśli został wybrany semestr
            if (!semester.equals("")) {
                Intent intent = new Intent(getApplicationContext(), SubjectNumberActivity.class);
                intent.putExtra("Semester", semester);
                startActivity(intent);
            }
            // jeśli nie został wybrany semestr
            else {
                Toast.makeText(getApplicationContext(), "Wybierz semestr z listy", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
