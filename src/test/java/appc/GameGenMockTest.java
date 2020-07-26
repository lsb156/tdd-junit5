package appc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.mock;

public class GameGenMockTest {

    @Test
    void mockStubTest() {
        // 모의 객체 생성
        GameNumGen genMock = mock(GameNumGen.class);
        // 스텁 설정
        given(genMock.generate(GameLevel.EASY)).willReturn("123");
        // 스텁 설정에 매칭되는 메서드 실행
        String num = genMock.generate(GameLevel.EASY);
        assertEquals("123", num);
    }

    @Test
    void anyMatchTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        // 이전에는 EASY만 "123"을 리턴하게 하였지만 any()를 사용하면 어떤 인자값이든 "456"을 리턴한다
        given(genMock.generate(any())).willReturn("456");

        String num = genMock.generate(GameLevel.EASY);
        assertEquals("456", num);

        String num2 = genMock.generate(GameLevel.NORMAL);
        assertEquals("456", num2);
    }

    @Test
    void mixAnyAndEq() {
        List<String> mockList = mock(List.class);

        // 스텁을 설정할 인자가 두 개 이상인 경우 주의할점
        // ArgumentMatchers의 anyInt나 any()등의 메서드는 내부적으로 인작의 일치 여부를 판단하기 위해 ArgumentMatcher를 등록
        // Mockito는 한 인자라도 ArgumentMatcher를 사용해서 설정한 경우 모든 인자를 ArgumentMatcher를 이용하여 설정하도록 하고있다.
        given(mockList.set(anyInt(), "123")).willReturn("456");
        given(mockList.set(anyInt(), eq("123"))).willReturn("456");

        String old = mockList.set(5, "123");
        assertEquals("456", old);
    }

    @Test
    void mockThrowTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        given(genMock.generate(null)).willThrow(new IllegalArgumentException());

        assertThrows(
                IllegalArgumentException.class,
                () -> genMock.generate(null));
    }

    @Test
    void voidMethodWillThrowTest() {
        List<String> mockList = mock(List.class);
        // 반환값이 void인 경우 Exception을 발생시키기위해 willThrow부터 정의한다.
        willThrow(UnsupportedOperationException.class)
                .given(mockList)
                .clear();

        assertThrows(
                UnsupportedOperationException.class,
                () -> mockList.clear()
        );
    }
}
