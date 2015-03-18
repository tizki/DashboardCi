package chart.bean;

/**
 * Created by kleintid on 3/18/2015.
 */
public class DistReport {

    private final int sampleSize;
    private final float successRate;
    private final float unstableRate;
    private final float failureRate;
    private final float abortedRate;

    public DistReport(int sampleSize, float successRate, float unstableRate, float failureRate, float abortedRate) {
        this.sampleSize = sampleSize;
        this.successRate = successRate;
        this.unstableRate = unstableRate;
        this.failureRate = failureRate;
        this.abortedRate = abortedRate;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public float getSuccessRate() {
        return successRate;
    }

    public float getUnstableRate() {
        return unstableRate;
    }

    public float getFailureRate() {
        return failureRate;
    }

    public float getAbortedRate() {
        return abortedRate;
    }
}
