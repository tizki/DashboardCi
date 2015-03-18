package chart.bean;

/**
 * Created by kleintid on 3/18/2015.
 */
public class AvgDurationReport implements DashBoardReport {

    private final float avgDuration;

    public AvgDurationReport(float avgDuration) {
        this.avgDuration = avgDuration;
    }

    public float getAvgDuration() {
        return avgDuration;
    }
}
