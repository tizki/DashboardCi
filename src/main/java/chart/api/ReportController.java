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

    @RequestMapping("/avgDuration")
    public AvgDurationReport avgDurationReport(@RequestParam(value="name", defaultValue="World") String name) {
        return new AvgDurationReport(150.0f);
    }

    @RequestMapping("/timeToFix")
    public TimeToFixReport timeToFixReport(@RequestParam(value="name", defaultValue="World") String name) {
        return new TimeToFixReport(1435.5f);
    }

    @RequestMapping("/max")
    public MaxReport maxReport(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println(System.getProperty("user.dir"));
        return ReportFactory.createMaxReport(DashBoardConstants.MAX, "csv/max.csv" );
    }
}