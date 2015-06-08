package pl.dawidpianka.app3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DisplayResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        String answer = getIntent().getStringExtra("Answer");
        String name = getIntent().getStringExtra("Name");
        String sex = getIntent().getStringExtra("Sex");
        String age = getIntent().getStringExtra("Age");

        ((TextView)findViewById(R.id.textViewAnswer)).setText(answer);
        ((TextView)findViewById(R.id.textViewName)).setText(name);
        ((TextView)findViewById(R.id.textViewSex)).setText(sex);
        ((TextView)findViewById(R.id.textViewAge)).setText(age);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_display_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
