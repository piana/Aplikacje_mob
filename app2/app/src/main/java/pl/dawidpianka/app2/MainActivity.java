package pl.dawidpianka.app2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    EditText editText;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);

        b1.setOnClickListener(onButtonClick);
        b2.setOnClickListener(onButtonClick);
    }

    private View.OnClickListener onButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String text = editText.getText().toString().trim();
            String request = "";

            // Brak wpisanego tekstu
            if (text.equals("")) {
                Toast.makeText(getApplicationContext(), "Wpisz coś do pola tesktowego.", Toast.LENGTH_SHORT).show();
            }
            // Jest wpisany tekst
            else {
                if (v.getId() == b1.getId()) {
                    request = "Reverse";
                }
                else if (v.getId() == b2.getId()) {
                    request = "Small";
                }

                if (!request.equals("")) {
                    Intent intent = new Intent(getApplicationContext(), StringManipulationActivity.class);
                    intent.putExtra("Text", text);
                    intent.putExtra("Request", request);
                    startActivity(intent);
                }
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
