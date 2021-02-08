package co.techandsolve.mudanza.service;

import co.techandsolve.mudanza.entity.LogExecution;
import co.techandsolve.mudanza.repository.LogExecutionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogExecutionServiceTest {

    @InjectMocks
    private LogExecutionService executionService;

    @Mock
    private LogExecutionRepository repository;

    @Test
    void saveLog(){
        LogExecution logExecution = new LogExecution();
        Mockito.doReturn(logExecution).when(repository).save(logExecution);

        this.executionService.save(logExecution);

        Mockito.verify(repository).save(logExecution);
    }

    @Test
    void build(){
        String document = "1091";
        String response = "200";

        LogExecution logExecution = this.executionService.buildLog(document, response);

        Assertions.assertEquals(document, logExecution.getDocument());
    }

}
