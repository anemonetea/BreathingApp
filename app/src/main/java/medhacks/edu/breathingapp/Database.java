package medhacks.edu.breathingapp;

import android.util.Log;

import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Database {

    private Calendar prevDate;
    protected Map<Integer, Day> data = new HashMap<Integer, Day>();
    protected int key;

    public Database() {
        this.key = (int) Math.random() % 42;
    }

    public void putDayData(Day day) {
        if (day != null && !Calendar.getInstance().equals(this.prevDate)) {
            data.put(key, day);
            this.key += 24;
            this.prevDate = Calendar.getInstance();
        } else
            throw new InvalidParameterException();
    }

    /**
     * Get the xth last value
     * @param x
     * @return
     */
    public Day getDayData(int x) {
        Day day = this.data.get(this.key-24*x);
        return day;
    }

}
