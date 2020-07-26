package appd;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class SoftAssertionsTest {
    @Test
    void softlyAssertAll() {
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(1).isBetween(0, 2);
        soft.assertThat(1).isGreaterThan(0);
        soft.assertThat(1).isLessThan(2);
        soft.assertAll();
    }

    @Test
    void softlyStatic() {
        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(1).isBetween(0, 2);
            soft.assertThat(1).isGreaterThan(0);
            soft.assertThat(1).isLessThan(2);
        });
    }
}
