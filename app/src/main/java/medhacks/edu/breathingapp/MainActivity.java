package medhacks.edu.breathingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected int score = 0;
    protected int minScore = 500;   // will be set by the user in settings
    protected int maxScore = 3000;
    protected int level = 1;
    private static Day day;
    protected static Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        day = new Day(score, level);
        this.database = new Database();
        this.database.putDayData(day);

        final ProgressBar progBar = findViewById(R.id.progressBar);
        progBar.setMax(minScore*4);
        progBar.setProgress(0);
        progBar.refreshDrawableState();

        final SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("STATUS", "Click");
                int cc = seekBar.getProgress()*500;
                if (!seekBar.isIndeterminate() && cc >= minScore)
                    score += cc;
                Log.d("SCORE", Integer.valueOf(score).toString());
                TextView lvl = findViewById(R.id.textView14);
                lvl.setText(Integer.toString(level));

                progBar.setProgress(score);

                TextView message = findViewById(R.id.textView11);
                if (cc >= maxScore)
                    message.setText("Be careful about inhaling too deep!");
                else if (cc < maxScore && cc > minScore)
                    message.setText("Great job!");

                if (score >= minScore*4) {   // daily goal
                    progBar.setProgress(0);
                    level++;
                    day.incrementScore(score);
                    day.updateLevel(level);
                    Log.d("DATA", "Current score in data: " + Integer.toString(day.score));
                    score = 0;
                    if (cc < maxScore)
                        message.setText("Congratulations on leveling up! Your daily goal was met.");
                }

                // Displaying the actual score?

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ImageButton results_btn = findViewById(R.id.imageButton3);
        results_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ResultsActivity.class));
            }
        });

        Log.d("STATUS","View configured.");

    }
/*
    public void resultsButton(View view) {
        ImageButton results_btn = findViewById(R.id.imageButton3);
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }
*/
}
