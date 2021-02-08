package co.techandsolve.mudanza.util;

import co.techandsolve.mudanza.entity.LogExecution;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DataUtil {

    public static String[] ELEMENT_STRING_RIGHT = {"1", "2", "3"};
    public static String[] ELEMENT_STRING_FAIL = {"1", "a", "3"};
    public static String RESPONSE_SUCCESS = "Case #1: 2\n" + "Case #2: 1\n"
            + "Case #3: 2\n" + "Case #4: 3\n" + "Case #5: 8\n";

    public static String RES = "\"Case #1: 2\\nCase #2: 1\\nCase #3: 2\\nCase #4: 3\\nCase #5: 8\\n\"";

    public static String RESPONSE_FAIL = "{[]\n\t\24\765}";

    public static MultipartFile multipartFile() {
        return new MockMultipartFile("input.txt", home().getBytes());
    }

    public static List<Integer> getElements() {
        return Arrays.asList(5, 4, 30, 30, 1, 1, 3, 20, 20, 20, 11, 1, 2, 3, 4, 5,
                6, 7, 8, 9, 10, 11, 6, 9, 19, 29, 39, 49, 59, 10, 32,
                56, 76, 8, 44, 60, 47, 85, 71, 91);
    }

    public static LogExecution getLogExecutionSuccess() {
        LogExecution logExecution = new LogExecution();
        logExecution.setDate(new Date());
        logExecution.setId(1L);
        logExecution.setDocument("1091");
        logExecution.setTravels("Case #1: 2\n" + "Case #2: 1\n" + "Case #3: 2\n" +
                "Case #4: 3\n" + "Case #5: 8\n");
        return logExecution;
    }

    public static LogExecution getLogExecutionFail() {
        LogExecution logExecution = new LogExecution();
        logExecution.setDate(new Date());
        logExecution.setId(1L);
        logExecution.setDocument("1091");
        logExecution.setTravels("{[]\n\t\24\765}");
        return logExecution;
    }

    public static String home() {
        return "5\n" +
                "4\n" +
                "30\n" +
                "30\n" +
                "1\n" +
                "1\n" +
                "3\n" +
                "20\n" +
                "20\n" +
                "20\n" +
                "11\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10\n" +
                "11\n" +
                "6\n" +
                "9\n" +
                "19\n" +
                "29\n" +
                "39\n" +
                "49\n" +
                "59\n" +
                "10\n" +
                "32\n" +
                "56\n" +
                "76\n" +
                "8\n" +
                "44\n" +
                "60\n" +
                "47\n" +
                "85\n" +
                "71\n" +
                "91";
    }
}

