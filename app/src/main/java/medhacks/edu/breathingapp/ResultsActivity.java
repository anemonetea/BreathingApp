package medhacks.edu.breathingapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Map;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        Log.d("STATUS", "Starting configuration of graph");

        Map<Integer, Day> myData = MainActivity.database.data;
        Log.d("DATA", Integer.toString(myData.get(0).score));
        //int key = MainActivity.database.key;
/*        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, myData.get(0).score),
                new DataPoint(1, 3500),
                new DataPoint(1, 4000)
        });
        series.setSpacing(50);
        graph.addSeries(series);
*/
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 15000), // stand-in values
                new DataPoint(1, 14500),
                new DataPoint(2, 16000),
                new DataPoint(3, 15000),
                new DataPoint(4, myData.get(0).score)
        });
        graph.addSeries(series);

// styling
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        series.setSpacing(50);

// draw values on top
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.BLUE);

    }
}
