package co.techandsolve.mudanza.service;

import co.techandsolve.mudanza.exception.FileWithoutNumbersException;
import co.techandsolve.mudanza.util.DataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@SpringBootTest
class ProcessServiceTest {

    @InjectMocks
    private ProcessService processService;

    @Test
    void getListFileTest() {
        int numberLineFile = 40;
        MultipartFile file = DataUtil.multipartFile();

        String[] res = this.processService.getListFile(file);

        Assertions.assertEquals(numberLineFile, res.length);
    }

    @Test
    void parseIntListTest() {
        String[] elements = DataUtil.ELEMENT_STRING_RIGHT;

        List<Integer> integers = this.processService.parseIntList(elements);

        Assertions.assertEquals(elements.length, integers.size());
    }

    @Test
    void parseIntListTestError() {
        String[] elements = DataUtil.ELEMENT_STRING_FAIL;
        String expectedMessage = "For input string";

        FileWithoutNumbersException exception = Assertions.assertThrows(FileWithoutNumbersException.class, () ->
                this.processService.parseIntList(elements));

        Assertions.assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    void processWorkDays() {
        List<Integer> elements = DataUtil.getElements();
        String expectedResponse = "Case #";

        String response = this.processService.processWorkDays(elements);

        Assertions.assertTrue(response.contains(expectedResponse));
    }
}
