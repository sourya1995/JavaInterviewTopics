package Date;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class ClkLearning {
    public static void main(String[] args) {
        Clock fixedClock = Clock.fixed(Instant.now(), ZoneOffset.UTC);
        System.out.println(fixedClock);

        Clock tickClock = Clock.tickSeconds(ZoneId.of("Europe/Bucharest"));
        System.out.println(tickClock.instant());
    }
}
