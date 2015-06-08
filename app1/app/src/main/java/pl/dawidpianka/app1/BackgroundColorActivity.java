package pl.dawidpianka.app1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;


public class BackgroundColorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_color);
        Integer bgColor = getIntent().getIntExtra("Color", 0);

        if(bgColor != 0) {
            RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.backgroundColorActivity);
            relativeLayout.setBackgroundColor(bgColor);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_background_color, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
