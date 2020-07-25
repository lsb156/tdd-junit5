package chapter10;

import chapter07.userregister.DupIdException;
import org.junit.jupiter.api.Test;

@SpringBootTest
@Sql("classpath:init0-data-sql")
public class UserRegisterIntTestUsingSql {
    @Autowired
    private UserRegister register;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void 동일_ID가_이미_존재하면_익셉션() {
        // 실행 결과 확인
        assertThrows(DupIdException.class,
                () -> register.register("abc", "pw", "email@email.com"));
    }
}
