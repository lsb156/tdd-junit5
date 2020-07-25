package chapter07.autodebit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardNumberValidatorTest {

    private WireMockServer wireMockServer;

    @BeforeEach
    void setUp() {
        wireMockServer = new WireMockServer(options().port(8089));
        wireMockServer.start();
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void valid() {
        wireMockServer.stubFor(post(urlEqualTo("/card"))
            .withRequestBody(equalTo("1234567890"))
            .willReturn(aResponse()
                .withHeader("Content-Type", "text/plain")
                .withBody("ok")));

    }

    @Test
    void timeout() {
        wireMockServer.stubFor(post(urlEqualTo("/card"))
            .willReturn(aResponse()
                .withFixedDelay(5000)));

        WireMockCardNumberValidator validator = new WireMockCardNumberValidator("http://localhost:8089");
        CardValidity validity = validator.validate("1234567890");
        assertEquals(CardValidity.TIMEOUT, validity);
    }


}
