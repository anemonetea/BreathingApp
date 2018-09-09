package medhacks.edu.breathingapp;

import java.util.Calendar;

public class Day {
    protected int score;
    protected int level;
    protected Calendar date;

    public Day(int score, int level) {
        this.score = score;
        this.level = level;
        this.date = Calendar.getInstance();
    }

    public void incrementScore(int score) {
        this.score += score;
    }

    public void updateLevel(int level) {
        this.level = level;
    }
}
