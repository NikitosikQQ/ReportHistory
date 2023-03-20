package RepHistory;

import java.time.LocalDate;
import java.util.List;
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
        return reports.stream()
                .filter(report -> report.getStudentUserName().equals(studentUserName))
                .sorted(ComparatorReport::compareDecreaseOfDate)
                .limit(count)
                .sorted(ComparatorReport::compareIncreaseOfDate)
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
