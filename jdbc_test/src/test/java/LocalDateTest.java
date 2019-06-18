import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
    public static void main(String[] args) throws Exception{
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(LocalDateTime.now()));
        for (int i = 0; i < 20; i++) {
            LocalDateTime localDateTime = LocalDateTime.now().withNano(0);
            System.out.println(df.format(localDateTime));
            Thread.sleep(1000);
        }

    }

}
