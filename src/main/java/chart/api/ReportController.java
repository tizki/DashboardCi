package chart.api;

import java.util.concurrent.atomic.AtomicLong;

import chart.bean.AvgDurationReport;
import chart.bean.DistReport;
import chart.bean.TimeToFixReport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chart.bean.Greeting;

@RestController
public class ReportController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/distribution")
    public DistReport distReport(@RequestParam(value="name", defaultValue="World") String name) {
        return new DistReport(30, 50, 15, 5 );
    }

    @RequestMapping("/avgDuration")
    public AvgDurationReport avgDurationReport(@RequestParam(value="name", defaultValue="World") String name) {
        return new AvgDurationReport(150.0f);
    }

    @RequestMapping("/timeToFix")
    public TimeToFixReport timeToFixReport(@RequestParam(value="name", defaultValue="World") String name) {
        return new TimeToFixReport(1435.5f);
    }
}