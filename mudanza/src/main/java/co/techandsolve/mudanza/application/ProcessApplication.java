package co.techandsolve.mudanza.application;

import co.techandsolve.mudanza.entity.LogExecution;
import co.techandsolve.mudanza.exception.MudanzaException;
import co.techandsolve.mudanza.service.LogExecutionService;
import co.techandsolve.mudanza.service.ProcessService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class ProcessApplication {

    private ProcessService processService;
    private LogExecutionService logService;

    @Autowired
    public ProcessApplication(ProcessService processService, LogExecutionService logService) {
        this.processService = processService;
        this.logService = logService;
    }

    public byte[] action(MultipartFile file, String document) {
        String[] elementStrings = this.processService.getListFile(file);
        List<Integer> elements = this.processService.parseIntList(elementStrings);
        String response = this.processService.processWorkDays(elements);
        LogExecution log = this.logService.buildLog(document, response);
        this.logService.save(log);
        return this.objectMapperResponse(response);
    }

    private byte[] objectMapperResponse(String response) throws MudanzaException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String writeValue = objectMapper.writeValueAsString(response);
            return writeValue.getBytes();
        } catch (JsonProcessingException e) {
            throw new MudanzaException(e.getMessage());
        }
    }

}
