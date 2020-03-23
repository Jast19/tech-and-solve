package co.techandsolve.mudanza;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MudanzaApplicationTests {

    @Test
    void contextLoads() {

        String sp = "1" +
                "2" +
                "3" +
                "4" +
                "5";

        String[] casa = sp.split("\n");

        for (String a : casa)
            System.out.println(a);
    }

}
