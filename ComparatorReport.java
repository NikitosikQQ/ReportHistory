package RepHistory;

import java.time.LocalDate;


public class ComparatorReport  {

    public static int compareDecreaseOfDate(Object o1, Object o2) {
        LocalDate date1 = ((Report)o1).getDate();
        LocalDate date2 = ((Report)o2).getDate();
        if(date1 == date2){
            return 0;
        }
        if(date1.compareTo(date2) > 0){
            return -1;
        }
        if(date1.compareTo(date2) < 0){
            return 1;
        }
        return 0;
    }
    public static int compareIncreaseOfDate(Object o1, Object o2) {
        LocalDate date1 = ((Report)o1).getDate();
        LocalDate date2 = ((Report)o2).getDate();
        if(date1 == date2){
            return 0;
        }
        if(date1.compareTo(date2) > 0){
            return 1;
        }
        if(date1.compareTo(date2) < 0){
            return -1;
        }
        return 0;
    }
}
