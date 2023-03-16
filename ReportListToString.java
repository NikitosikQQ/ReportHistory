package RepHistory;

import java.util.List;

public class ReportListToString {

    public static String reportListToString(List<Report> sortedList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sortedList.size(); i++) {
            sb.append(sortedList.get(i).getStudentUserName() + "\n");
            sb.append(sortedList.get(i).getDate() + "\n");
            sb.append(sortedList.get(i).getHours() + "\n");
            sb.append(sortedList.get(i).getTitle() + "\n");
            if (i != sortedList.size() - 1) {
                sb.append("________________________________________" + "\n");
            }
        }
        return sb.toString();
    }
}
