package chart.utils;

import chart.bean.*;
import chart.model.DashBoardConstants;

import java.io.IOException;

/**
 * Created by kleintid on 3/18/2015.
 */
public class ReportFactory {

    public static DashBoardReport createReport(String reportType, String reportTypeFileName) {
        String[] rawData;
        try {
            rawData = DashBoardCICsvReader.getCsv(reportTypeFileName);

            switch (reportType) {
                case DashBoardConstants.DISTRIBUTION:
                    float[] results = new float[4];
                    for (int i = 0; i < 4; i++) {
                        results[i] = Float.valueOf(rawData[i]);
                    }
                    return new DistReport(results[0], results[1], results[2], results[3]);

                case DashBoardConstants.AVERAGE_DURATION:
                    return new AvgDurationReport(Float.valueOf(rawData[0]));
                case DashBoardConstants.TIME_TO_FIX:
                    return new TimeToFixReport(Float.valueOf(rawData[0]));
                default:
                    throw new IllegalArgumentException("Illegal report type");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new IllegalStateException("cannot create report");
    }

    public static DistReport createDistReport(String reportType, String reportTypeFileName) {
        String[] rawData;
        try {
            rawData = DashBoardCICsvReader.getCsv(reportTypeFileName);
            float[] results = new float[4];
            for (int i = 0; i < 4; i++) {
                results[i] = Float.valueOf(rawData[i]);
            }
            return new DistReport(results[0], results[1], results[2], results[3]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("cannot create distribution report");
    }

    public static MaxReport createMaxReport(String reportType, String reportTypeFileName) {
        String[] rawData;
        try {
            rawData = DashBoardCICsvReader.getCsv(reportTypeFileName);
            return new MaxReport(Float.valueOf(rawData[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("cannot create max report");
    }

    public static TimeToFixReport createTimeToFixReport(String reportTypeFileName) {
        String[] rawData;
        try {
            rawData = DashBoardCICsvReader.getCsv(reportTypeFileName);
            return new TimeToFixReport(Float.valueOf(rawData[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("cannot create time to fix report");
    }

    public static AvgDurationReport createAvgDurationReport(String reportTypeFileName) {
        String[] rawData;
        try {
            rawData = DashBoardCICsvReader.getCsv(reportTypeFileName);
            return new AvgDurationReport(Float.valueOf(rawData[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("cannot create average duration report");
    }
}
