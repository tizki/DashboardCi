package chart.bean;

/**
 * Created by kleintid on 3/18/2015.
 */
public class TimeToFixReport  implements DashBoardReport{

    private final float timeToFix;

    public TimeToFixReport(float timeToFix) {
        this.timeToFix = timeToFix;
    }

    public float getTimeToFix() {
        return timeToFix;
    }

    public TimeToFixReport calculateReport(){

        return null;
    }
}
