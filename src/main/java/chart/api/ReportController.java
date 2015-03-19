package chart.api;

import java.util.concurrent.atomic.AtomicLong;

import chart.bean.*;
import chart.model.DashBoardConstants;
import chart.utils.ReportFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/test")
    public String test(@RequestParam(value="name", defaultValue="World") String name) {
        return name;
    }
    @RequestMapping("/distribution")
    public DistReport distReport(@RequestParam(value="name", defaultValue="World") String name) {
        return new DistReport(30, 50, 15, 5 );
    }

    @RequestMapping("/Platform/distribution")
    public DistReport platformDistReport(@RequestParam(value="name", defaultValue="World") String name) {
        return ReportFactory.createDistReport("","csv/platform/distribution.csv");
    }

    @RequestMapping("/UI/distribution")
    public DistReport uiDistReport(@RequestParam(value="name", defaultValue="World") String name) {
        return ReportFactory.createDistReport("","csv/ui/distribution.csv");
    }

    @RequestMapping("/Saw/distribution")
    public DistReport sawDistReport(@RequestParam(value="name", defaultValue="World") String name) {
        return ReportFactory.createDistReport("","csv/saw/distribution.csv");
    }

    @RequestMapping("/Platform/avgDuration")
    public AvgDurationReport avgDurationReport(@RequestParam(value="name", defaultValue="World") String name) {
        return ReportFactory.createAvgDurationReport("csv/platform/avgDuration.csv");
    }

    @RequestMapping("UI/avgDuration")
    public AvgDurationReport avgDurationUIReport(@RequestParam(value="name", defaultValue="World") String name) {
        return ReportFactory.createAvgDurationReport("csv/ui/avgDuration.csv");
    }

    @RequestMapping("Saw/avgDuration")
    public AvgDurationReport avgDurationSawReport(@RequestParam(value="name", defaultValue="World") String name) {
        return ReportFactory.createAvgDurationReport("csv/saw/avgDuration.csv");
    }

    @RequestMapping("Platform/timeToFix")
    public TimeToFixReport timeToFixPlatformReport(@RequestParam(value="name", defaultValue="World") String name) {
        return ReportFactory.createTimeToFixReport("csv/platform/timeToFix.csv");
    }

    @RequestMapping("UI/timeToFix")
    public TimeToFixReport timeToFixUIReport(@RequestParam(value="name", defaultValue="World") String name) {
        return ReportFactory.createTimeToFixReport("csv/ui/timeToFix.csv");
    }

    @RequestMapping("Saw/timeToFix")
    public TimeToFixReport timeToFixSawReport(@RequestParam(value="name", defaultValue="World") String name) {
        return ReportFactory.createTimeToFixReport("csv/saw/timeToFix.csv");
    }

    @RequestMapping("/max")
    public MaxReport maxReport(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println(System.getProperty("user.dir"));
        return ReportFactory.createMaxReport(DashBoardConstants.MAX, "csv/max.csv" );
    }
}