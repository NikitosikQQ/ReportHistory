package RepHistory;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Report {

    private Long id;

    private String studentUserName;

    private Integer hours;

    private LocalDate date;

    private String title;

    public String getStudentUserName() {
        return studentUserName;
    }

    public Integer getHours() {
        return hours;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public Report(Long id, String studentUserName, Integer hours, LocalDate date, String title) {
        this.id = id;
        this.studentUserName = studentUserName;
        this.hours = hours;
        this.date = date;
        this.title = title;
    }

    public static String reportHistory(List<Report> reports, String studentUserName, int count) {
        Function<Report, LocalDate> sortOfDate = report -> report.getDate();
        return reports.stream()
                .filter(report -> report.getStudentUserName().equals(studentUserName))
                .sorted(Comparator.comparing(sortOfDate).reversed())
                .limit(count)
                .sorted(Comparator.comparing(sortOfDate))
                .map(report -> report.toString())
                .collect(Collectors.joining("_____________________" + "\n"));
    }

    @Override
    public String toString() {
        return studentUserName + '\n'
                + date + '\n'
                + hours + '\n'
                + title + '\n';
    }
}
