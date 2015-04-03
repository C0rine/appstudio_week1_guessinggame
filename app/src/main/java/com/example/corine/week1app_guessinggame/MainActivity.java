package com.example.corine.week1app_guessinggame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//check changes

public class MainActivity extends ActionBarActivity {

    private TextView title;
    private TextView instructions;
    private Button startgame;
    private EditText guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.title);
        instructions = (TextView) findViewById(R.id.instructions);
        startgame = (Button) findViewById(R.id.startgame);
        guess = (EditText) findViewById(R.id.guess);

        guess.setVisibility(View.INVISIBLE);
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

    public void startClick(View view) {

        // upon clicking the startgame button, remove the button and show field for user input so the user can guess
        startgame.setVisibility(View.GONE);
        guess.setVisibility(View.VISIBLE);

        // change instructions field to a questionmark
        String questionmark = "?";
        instructions.setText(questionmark);
        instructions.setTextSize(80);

    }
}
