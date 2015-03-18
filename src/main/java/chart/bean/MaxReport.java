package chart.bean;

/**
 * Created by kleintid on 3/18/2015.
 */
public class MaxReport implements DashBoardReport {

    private final float maxDuration;

    public MaxReport(float avgDuration) {
        this.maxDuration = avgDuration;
    }

    public float getMaxDuration() {
        return maxDuration;
    }
}
