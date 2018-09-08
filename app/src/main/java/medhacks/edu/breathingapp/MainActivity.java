package medhacks.edu.breathingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected int score = 0;
    protected int minScore = 500;   // will be set by the user in settings
    protected int maxScore = 3000;
    protected int level = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        final ProgressBar progBar = findViewById(R.id.progressBar);
        progBar.setMax(minScore*4);
        progBar.setProgress(0);
        progBar.refreshDrawableState();

        final SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("STATUS", "Click");
                int cc = seekBar.getProgress()*250;
                if (!seekBar.isIndeterminate() && cc >= minScore)
                    score += cc;
                Log.d("SCORE", Integer.valueOf(score).toString());
                TextView lvl = findViewById(R.id.textView14);
                lvl.setText(Integer.toString(level));

                // Warning message about breathing in too deep
                // Saying good job for breathing in the right amount
                // Congratulatory message for leveling up
                // Displaying the actual score?

                progBar.setProgress(score);

                if (score >= minScore*4) {   // daily goal
                    progBar.setProgress(0);
                    level++;
                    score = 0;
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        Log.d("STATUS","View configured.");

    }

    public int getCC(){
        SeekBar seekBar = findViewById(R.id.seekBar);
        int cc = -1; // value if seekBar is in an intermediate state
        if (!seekBar.isIndeterminate())
            cc = seekBar.getProgress();
        return cc;
    }
}
