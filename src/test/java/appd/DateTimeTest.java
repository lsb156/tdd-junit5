package appd;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DateTimeTest {
    @Test
    void ignoring() {
        LocalDateTime time = LocalDateTime.of(2019, 7, 31, 19, 30, 31, 123);

        assertThat(time).isEqualToIgnoringNanos(
                LocalDateTime.of(2019, 7, 31, 19, 30, 31, 456)
        );
        assertThat(time).isEqualToIgnoringSeconds(
                LocalDateTime.of(2019, 7, 31, 19, 30, 39)
        );
        assertThat(time).isEqualToIgnoringMinutes(
                LocalDateTime.of(2019, 7, 31, 19, 10)
        );
        assertThat(time).isEqualToIgnoringHours(
                LocalDateTime.of(2019, 7, 31, 15, 10)
        );
    }
}
