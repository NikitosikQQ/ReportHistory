package RepHistory;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
        return reports.stream()
                .filter(report -> report.getStudentUserName().equals(studentUserName))
                .sorted(Comparator.comparing(Report::getDate).reversed())
                .limit(count)
                .sorted(Comparator.comparing(Report::getDate))
                .map(report -> report.toString())
                .collect(Collectors.joining("_____________________" + "\n"));
    }

    public static String reportHistoryTwo(List<Report> reports, String studentUserName, int count) {
        Function<Report, LocalDate> getDate = report -> report.getDate();
        StringBuilder sb = new StringBuilder();
        List<Report> currentReports = new ArrayList<>();
        Collections.sort(reports, Comparator.comparing(getDate).reversed());
        for (int i = 0; i < reports.size(); i++) {
            if (reports.get(i).getStudentUserName().equals(studentUserName)) {
                if (count != 0) {
                    currentReports.add(reports.get(i));
                    count--;
                }
            }
        }
        Collections.sort(currentReports, Comparator.comparing(getDate));
        for (int i = 0; i < currentReports.size(); i++) {
            sb.append(currentReports.get(i));
            if (i != currentReports.size() - 1){
                sb.append("_______________________" + '\n');
            }
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return studentUserName + '\n'
                + date + '\n'
                + hours + '\n'
                + title + '\n';
    }
}
