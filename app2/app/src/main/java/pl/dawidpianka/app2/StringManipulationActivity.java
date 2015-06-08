package pl.dawidpianka.app2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class StringManipulationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_manipulation);
        TextView textViewResult = (TextView)findViewById(R.id.textViewResult);

        String text = getIntent().getStringExtra("Text");
        String request = getIntent().getStringExtra("Request");

        if(request.equals("Reverse")) {
            textViewResult.setText(text + " po odwróceniu da: " + new StringBuffer(text).reverse().toString());
        }
        else if(request.equals("Small")) {
            textViewResult.setText(text + " po zamienieniu wszystkich liter na wielkie da: " + text.toUpperCase());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_string_manipulation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
