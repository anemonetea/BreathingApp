package medhacks.edu.breathingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    protected int score = 0;
    protected int minScore = 250;   // will be set by the user in settings

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar progBar = findViewById(R.id.progressBar);
        progBar.setMax(minScore);
        progBar.setProgress(0);

        final SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("STATUS", "Click");
                if (!seekBar.isIndeterminate())
                    score += seekBar.getProgress()*250;
                Log.d("SCORE", Integer.valueOf(score).toString());
                if (!progBar.isIndeterminate())
                    progBar.setProgress(score / minScore);

                if (score > minScore)
                    progBar.setProgress(0);

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
