package pl.dawidpianka.app4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


public class SubjectNumberActivity extends Activity {
    Map<String, Integer> liczbaPrzedmiotowWSemestrze = new HashMap<>();
    Integer arrSubjectAmount[] ={6, 7, 7, 5, 8, 6, 5};
    Integer subjectAmount = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_number);
        TextView textView = (TextView)findViewById(R.id.textViewResult);

        // dodanie liczby przedmiotów do słownika
        for(int i=1; i <= 7; i++) {
            liczbaPrzedmiotowWSemestrze.put("Semestr " + String.valueOf(i), arrSubjectAmount[i-1]);
        }

        String semester = getIntent().getStringExtra("Semester");

        // próba odnalezienia danego semestru
        for (Map.Entry entry : liczbaPrzedmiotowWSemestrze.entrySet()) {
            if (entry.getKey().equals(semester)) {
                subjectAmount = (Integer)entry.getValue(); // zapisanie liczby przedmiotów
            }
        }

        // wyświetlenie rezultatu
        if (subjectAmount != null) {
            textView.setText(semester + ": liczba przedmiotów wynosi " + subjectAmount.toString() + ".");
        }
        else {
            textView.setText(semester + ": nie odnaleziono liczby przedmiotó dla tego semestru.");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_subject_number, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
