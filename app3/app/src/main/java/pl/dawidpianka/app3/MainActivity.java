package pl.dawidpianka.app3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    List<Integer> cbAnswerList;
    List<Integer> cbSexList;
    List<Integer> cbAgeList;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.mainActivity);
        Button button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);

        // zebranie wszystkich chceckboxów do listy
        // i przydzielenie checboxów do osobnych list według tematu (odpowiedź, płeć, wiek)
        cbAnswerList = new ArrayList<>();
        cbSexList = new ArrayList<>();
        cbAgeList = new ArrayList<>();
        ArrayList<Integer> cbIdList = new ArrayList<>();
        for (int i=0; i < linearLayout.getChildCount(); i++) {
            View v = linearLayout.getChildAt(i);

            if(v instanceof LinearLayout) {
                LinearLayout ll = (LinearLayout)v;

                for(int j=0; j < ll.getChildCount(); j++) {
                    View cb = ll.getChildAt(j);

                    if (cb instanceof CheckBox) {
                        Integer cbId = cb.getId(); // zapisanie id checkboxa do zmiennej

                        cbIdList.add(cbId); // dodanie id checkboxa do listy ogólnej

                        // przdzielenie id checkboxa do osobnej listy
                        if (cbId == R.id.checkBoxYes || cbId == R.id.checkBoxNo || cbId == R.id.checkBoxDontKnow) {
                            cbAnswerList.add(cbId);
                        }
                        else if (cbId == R.id.checkBoxWoman || cbId == R.id.checkBoxMan) {
                            cbSexList.add(cbId);
                        }
                        else if(cbId == R.id.checkBoxAge1 || cbId == R.id.checkBoxAge2 || cbId == R.id.checkBoxAge3 || cbId == R.id.checkBoxAge4) {
                            cbAgeList.add(cbId);
                        }
                    }
                }
            }

        }

        // nadanie wszystkim checkboxom tego samego listenera
        for (Integer cbId : cbIdList) {
            CheckBox cb = (CheckBox)findViewById(cbId);
            cb.setOnClickListener(onCheckBoxClick);
        }

        // nadanie listener buttonowi
        button.setOnClickListener(onButtonClick);
    }

    private View.OnClickListener onCheckBoxClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CheckBox cb = (CheckBox)v;
            Integer cbId = cb.getId();

            if (cb.isChecked()) {
                if (cbId == R.id.checkBoxYes || cbId == R.id.checkBoxNo || cbId == R.id.checkBoxDontKnow) {
                    odznaczPozostaleCheckboxy(cbId, cbAnswerList);
                }
                else if (cbId == R.id.checkBoxWoman || cbId == R.id.checkBoxMan) {
                    odznaczPozostaleCheckboxy(cbId, cbSexList);
                }
                else if(cbId == R.id.checkBoxAge1 || cbId == R.id.checkBoxAge2 || cbId == R.id.checkBoxAge3 || cbId == R.id.checkBoxAge4) {
                    odznaczPozostaleCheckboxy(cbId, cbAgeList);
                }
            }
        }
    };

    private void odznaczPozostaleCheckboxy(Integer okID, List<Integer> cbList) {
        CheckBox cbTemp;

        for(Integer id : cbList) {
            if(!id.equals(okID)) {
                cbTemp = (CheckBox)findViewById(id);
                cbTemp.setChecked(false);
            }
        }
    }

    private Integer jestZaznaczonyCheckbox(List<Integer> cbList) {
        CheckBox cbTemp;
        Integer result = null;

        for (Integer id : cbList) {
            cbTemp = (CheckBox)findViewById(id);
            if (cbTemp.isChecked()) {
                result = id;
            }
        }

        return result;
    }

    private View.OnClickListener onButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = editText.getText().toString().trim();
            Integer checkBoxAnswerId = jestZaznaczonyCheckbox(cbAnswerList);
            Integer checkBoxSexId = jestZaznaczonyCheckbox(cbSexList);
            Integer checkBoxAgeId = jestZaznaczonyCheckbox(cbAgeList);

            if (name.equals("")) {
                Toast.makeText(getApplicationContext(), "Podaj imię.", Toast.LENGTH_SHORT).show();
            }
            else  {
                if (checkBoxAnswerId != null && checkBoxSexId != null && checkBoxAgeId != null) {
                    Intent intent = new Intent(getApplicationContext(), DisplayResultActivity.class);
                    intent.putExtra("Answer", ((CheckBox)findViewById(checkBoxAnswerId)).getText().toString());
                    intent.putExtra("Name", name);
                    intent.putExtra("Sex", ((CheckBox)findViewById(checkBoxSexId)).getText().toString());
                    intent.putExtra("Age", ((CheckBox)findViewById(checkBoxAgeId)).getText().toString());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Zaznacz checkbox przy każdym punkcie.", Toast.LENGTH_SHORT).show();
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
