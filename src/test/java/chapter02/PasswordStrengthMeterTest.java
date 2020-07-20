package chapter02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * 암호 검사기
 *
 * 길이가 8글자 이상
 * 0부터 9사이의 숫자를 폼함
 * 대문자 포함
 *
 * 세 규칙을 모두 충족하면 암호는 강함
 * 2개의 규칙을 충족하면 암호는 보통
 * 1개 이하의 규칙을 충족하면 암호는 약함
 *
 * */
public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    @Test
    // 모든 규칙을 충족하는 경우
    void meetsAllCriteria_Then_Strong() {
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    @Test
    // 길이만 8글자 미만이고 나머지 조건은 충족하는 경
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("Ab12!c", PasswordStrength.NORMAL);
    }

    @Test
    // 숫자를 포함하지 않고 나머지 조건은 충족하는 경우
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    @Test
    // 값이 null인 경우
    void nullInput_Then_Invalid() {
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    // 값이 없는 경우
    void emptyInput_Then_Invalid() {
        assertStrength("", PasswordStrength.INVALID);
    }

    @Test
    // 대문자를 포함하지 않고 나머지 조건을 충족하는 경우
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    @Test
    // 길이가 8글자 이상인 조건만 충족하는 경우
    void meetsOnlyLengthCriteria_Then_Weak() {
        assertStrength("asdffghi", PasswordStrength.WEAK);
    }

    @Test
    // 숫자 포함 조건만 충족하는 경우
    void meetsOnlyNumCriteria_Then_Weak() {
        assertStrength("12345", PasswordStrength.WEAK);
    }

    @Test
    // 대문자 포함 조건만 충족하는 경우
    void meetsOnlyUpperCriteria_Then_Weak() {
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    @Test
    // 아무 조건도 충족하지 않은 경우
    void meetsNoCriteria_Then_Weak() {
        assertStrength("abc", PasswordStrength.WEAK);
    }
}
