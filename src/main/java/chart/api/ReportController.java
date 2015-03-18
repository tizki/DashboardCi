package chart.api;

import java.util.concurrent.atomic.AtomicLong;

import chart.bean.DistReport;
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
        return new DistReport(100, 30, 50, 15, 5 );
    }
}