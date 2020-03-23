package co.techandsolve.mudanza.service;

import co.techandsolve.mudanza.entity.LogExecution;
import co.techandsolve.mudanza.repository.LogExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogExecutionService {

    private LogExecutionRepository repository;

    @Autowired
    public LogExecutionService(LogExecutionRepository repository) {
        this.repository = repository;
    }

    public void save(LogExecution execution) {
        this.repository.save(execution);
    }

    public LogExecution buildLog(String document, String response){
        LogExecution logExecution = new LogExecution();
        logExecution.setDocument(document);
        logExecution.setTravels(response);
        logExecution.setDate(new Date());
        return logExecution;
    }
}
