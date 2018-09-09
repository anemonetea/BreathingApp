package medhacks.edu.breathingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


//min score - goal?
//max score - general max, don't go above 3k
//personal max?

public class SettingsActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);
/*
        ImageButton setting_btn = findViewById(R.id.imageButton4);
        setting_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(this, MainActivity.class);
                myIntent.putExtra("firstName", "Your First Name Here");
                myIntent.putExtra("lastName", "Your Last Name Here");
                startActivity(myIntent)
            }
        });
  */
    }
}
