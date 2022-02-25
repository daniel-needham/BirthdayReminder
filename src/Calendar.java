import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Calendar {

    public static void main(String[] args) {
        String pattern = "yyyy/MM/dd";
        LocalDate dd = LocalDate.now();

        String date = dd.format(DateTimeFormatter.ofPattern(pattern));
        System.out.println(date);

        String dat = "2021/05/21";
        LocalDate da = LocalDate.parse(dat, DateTimeFormatter.ofPattern(pattern));
        System.out.println(da.format(DateTimeFormatter.ofPattern(pattern)));

        get_repeating_event("2021/04/23", "every 4 day");
    }


    public static String[] get_repeating_event(String starting_date, String repeat_instruction) {
        String pattern = "yyyy/MM/dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate startingDate = LocalDate.parse(starting_date, formatter);

        /*work out repetition*/
        String[] words = repeat_instruction.split(" ");
        int noOfTimes = 0;
        try {
            noOfTimes = Integer.parseInt(words[1]);
        } catch (Exception e) {

        }
        String period = words[2].toLowerCase();

        ChronoUnit unit;
        String[] result = new String[4];

        if (period.matches("days*")) {
            unit = ChronoUnit.DAYS;
        } else if (period.matches("weeks*")) {
            unit = ChronoUnit.WEEKS;
        } else if (period.matches("months*")) {
            unit = ChronoUnit.MONTHS;
        } else if (period.matches("years*")) {
            unit = ChronoUnit.YEARS;
        } else {
           String[] noResult = new String[]{};
           return noResult;
        }

        /*fill array*/
        result[0] = startingDate.format(formatter);
        for (int i = 1; i <= 3; i++) {
            startingDate = startingDate.plus(noOfTimes, unit);
            result[i] = startingDate.format(formatter);
        }


        return result;
    }

}
