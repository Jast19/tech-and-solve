package co.techandsolve.mudanza.application;

import co.techandsolve.mudanza.entity.LogExecution;
import co.techandsolve.mudanza.service.LogExecutionService;
import co.techandsolve.mudanza.service.ProcessService;
import co.techandsolve.mudanza.util.DataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@SpringBootTest
class ProcessApplicationTest {

    @Mock
    private ProcessService processService;

    @Mock
    private LogExecutionService logService;

    @InjectMocks
    private ProcessApplication processApplication;

    @Test
    void orchestratorProcessSuccessTest() {

        MultipartFile file = DataUtil.multipartFile();
        String[] elementString = DataUtil.ELEMENT_STRING_RIGHT;
        List<Integer> elements = DataUtil.getElements();
        String response = DataUtil.RESPONSE_SUCCESS;
        LogExecution logExecution = DataUtil.getLogExecutionSuccess();

        Mockito.doReturn(elementString).when(this.processService).getListFile(file);
        Mockito.doReturn(elements).when(this.processService).parseIntList(elementString);
        Mockito.doReturn(response).when(this.processService).processWorkDays(elements);
        Mockito.doReturn(logExecution).when(this.logService).buildLog(logExecution.getDocument(), logExecution.getTravels());
        Mockito.doNothing().when(this.logService).save(logExecution);

        byte[] responseBytes = this.processApplication.action(file, logExecution.getDocument());

        Assertions.assertNotNull(responseBytes);
        Mockito.verify(this.processService).getListFile(file);
        Mockito.verify(this.processService).parseIntList(elementString);
        Mockito.verify(this.processService).processWorkDays(elements);
        Mockito.verify(this.logService).buildLog(logExecution.getDocument(), logExecution.getTravels());
        Mockito.verify(this.logService).save(logExecution);
    }

    @Test
    void orchestratorProcessFAILTest() {

        MultipartFile file = DataUtil.multipartFile();
        String[] elementString = DataUtil.ELEMENT_STRING_RIGHT;
        List<Integer> elements = DataUtil.getElements();
        String response = DataUtil.RESPONSE_FAIL;
        LogExecution logExecution = DataUtil.getLogExecutionFail();

        Mockito.doReturn(elementString).when(this.processService).getListFile(file);
        Mockito.doReturn(elements).when(this.processService).parseIntList(elementString);
        Mockito.doReturn(response).when(this.processService).processWorkDays(elements);
        Mockito.doReturn(logExecution).when(this.logService).buildLog(logExecution.getDocument(), logExecution.getTravels());
        Mockito.doNothing().when(this.logService).save(logExecution);

        byte[] responseBytes = this.processApplication.action(file, logExecution.getDocument());

        Assertions.assertNotNull(responseBytes);
        Mockito.verify(this.processService).getListFile(file);
        Mockito.verify(this.processService).parseIntList(elementString);
        Mockito.verify(this.processService).processWorkDays(elements);
        Mockito.verify(this.logService).buildLog(logExecution.getDocument(), logExecution.getTravels());
        Mockito.verify(this.logService).save(logExecution);
    }
}
