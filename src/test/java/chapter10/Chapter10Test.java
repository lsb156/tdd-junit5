package chapter10;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Chapter10Test {

    @Test
    void dateFormat1() {
        LocalDate date = LocalDate.of(1945, 8, 15);
        String dateStr = formatDate(date);
        assertEquals(date.getYear()+ "년 "
                + date.getMonthValue() + "월 "
                + date.getDayOfMonth() + "일", dateStr);
    }

    @Test
    void dateFormat2() {
        LocalDate date = LocalDate.of(1945, 8, 15);
        String dateStr = formatDate(date);
        assertEquals("1945년 8, 15", dateStr);
    }


    private String formatDate(LocalDate date) {
        return null;
    }


}
