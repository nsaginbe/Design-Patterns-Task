package adapter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConverter {
    public static String getTime(){
        LocalTime time = LocalTime.now();
        return DateTimeFormatter.ofPattern("HH:mm").format(time);
    }

    public static String getTime(LocalTime time){
        return DateTimeFormatter.ofPattern("HH:mm").format(time);
    }
}
