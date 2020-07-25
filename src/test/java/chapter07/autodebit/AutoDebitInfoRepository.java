package chapter07.autodebit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public interface AutoDebitInfoRepository {
    void save(AutoDebitInfo info);
    AutoDebitInfo findOne(String userId);
}
