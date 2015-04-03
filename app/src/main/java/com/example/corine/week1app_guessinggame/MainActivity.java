package com.example.corine.week1app_guessinggame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private TextView title;
    private TextView instructions;
    private Button startgame;
    private Button makeguess;
    private EditText guess;

    // generate the number the user has to guess
    private int random = (int)(Math.random() * 1000);

   // initialize the game
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.title);
        instructions = (TextView) findViewById(R.id.instructions);
        startgame = (Button) findViewById(R.id.startgame);
        makeguess = (Button) findViewById(R.id.makeguess);
        guess = (EditText) findViewById(R.id.guess);

        // hide userinput and guess buttom for now
        makeguess.setVisibility(View.INVISIBLE);
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

    // starting game
    public void startClick(View view) {

        // upon clicking the startgame button, remove the button and show field for user input and the guess button so the user can guess
        startgame.setVisibility(View.GONE);
        guess.setVisibility(View.VISIBLE);
        makeguess.setVisibility(View.VISIBLE);

        // change instructions field to a questionmark
        String questionmark = "?";
        instructions.setText(questionmark);
        instructions.setTextSize(150);
    }

    // making guesses
    public void makingtheguess(View view) {

        // uncomment the line below to see the value to be guessed for debugging/testing purposes
        // instructions.setText(String.valueOf(random));

        // get the input from the user and parse it to an int
        Integer userinput = Integer.parseInt(String.valueOf(guess.getText()));

        // compare userinput with the random generated number
        if (userinput < random){
            // give hint
            Toast.makeText(this, "Try higher", Toast.LENGTH_SHORT).show();
        }

        else if (userinput > random){
            // give hint
            Toast.makeText(this, "Try lower", Toast.LENGTH_SHORT).show();
        }

        else {
            // the user must have guessed the right number --> end the game
            title.setText("You won!");
            Toast.makeText(this, "YOU WON!!!", Toast.LENGTH_SHORT).show();

            guess.setVisibility(View.GONE);
            makeguess.setVisibility(View.GONE);

            instructions.setText(String.valueOf(random));

            // restart the main activity
            // I could not figure out how to do this :(, so you would have to restart the app.
        }
    }
}