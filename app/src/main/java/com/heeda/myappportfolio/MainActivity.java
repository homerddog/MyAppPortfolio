package com.heeda.myappportfolio;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);

        for (Button button : createButtons()) {
            layout.addView(button);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Button[] createButtons() {
        Resources res = getResources();
        String[] appNames = res.getStringArray(R.array.app_names);

        Button[] buttons = new Button[appNames.length];
        Button button;

        for (int i = 0; i < buttons.length; i++) {
            button = new Button(this);
            button.setText(appNames[i]);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button) v;

                    String toast_message = " " + button.getText();

                    toast_message += button.getText().toString().toLowerCase().contains("app") ?
                             "!" : " App!";

                    Toast.makeText(getApplicationContext(),
                            getString(R.string.toast_message) + toast_message,
                            Toast.LENGTH_SHORT).show();
                }
            });

            buttons[i] = button;
        }

        return buttons;
    }
}
