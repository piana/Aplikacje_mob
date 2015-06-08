package pl.dawidpianka.app1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);

        b1.setOnClickListener(onButtonClick);
        b2.setOnClickListener(onButtonClick);
    }

    private View.OnClickListener onButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer bgColor = null;

            if(v.getId() == b1.getId()) {
                bgColor = Color.CYAN;
            }
            else if (v.getId() == b2.getId()) {
                bgColor = Color.RED;
            }

            if (bgColor != null) {
                Intent intent = new Intent(getApplicationContext(), BackgroundColorActivity.class);
                intent.putExtra("Color", bgColor);
                startActivity(intent);
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
