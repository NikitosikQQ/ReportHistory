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
        String sortedReports = reports.stream()
                .sorted(ComparatorReport::compareDecreaseOfDate)
                .limit(count)
                .sorted(ComparatorReport::compareIncreaseOfDate)
                .map(report -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(report.getStudentUserName() + "\n");
                    sb.append(report.getDate() + "\n");
                    sb.append(report.getHours() + "\n");
                    sb.append(report.getTitle() + "\n");
                    return sb.toString();
                })
                .collect(Collectors.joining("_____________________" + "\n"));
        return sortedReports;
    }
}
