import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        Instant i01 = Instant.now();

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm").withZone(ZoneId.of("America/Los_Angeles"));
        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm").withZone(ZoneId.systemDefault());

        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();

        LocalDate d04 = LocalDate.parse("2024-07-10");
        LocalDateTime d05 = LocalDateTime.parse("2024-07-10T11:01:06.0454245");
        LocalDate d06 = LocalDate.parse("2024/03/22", fmt1);
        LocalDateTime d07 = LocalDateTime.parse("2024/03/22 01:45", fmt2);

        System.out.println("d01 = " + d01);
        System.out.println("d02 = " + d02);
        System.out.println("d03 = " + d03);
        System.out.println("d04 = " + d04);
        System.out.println("d05 = " + d05);
        System.out.println("d06 = " + fmt1.format(d06));
        System.out.println("d07 = " + d07.format(fmt2));
        System.out.println("d03 = " + fmt3.format(d03));
        System.out.println("d03 = " + fmt4.format(d03));

        LocalDate d08 = d01.plusDays(3);
        System.out.println("d08 = " + fmt1.format(d08));

        LocalDateTime d09 = d02.plusHours(48);
        System.out.println("d09 = " + d09.format(fmt2));

        Duration t01 = Duration.between(d02, d09);
        System.out.println("t01 = " + t01.toDays() + " dias");

        Instant i02 = Instant.now();
        Duration t02 = Duration.between(i01, i02);
        System.out.println("t02 = " + t02.toMillis() + " ms");

    }
}
