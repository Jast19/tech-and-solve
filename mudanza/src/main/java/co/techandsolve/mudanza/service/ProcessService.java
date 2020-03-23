package co.techandsolve.mudanza.service;

import co.techandsolve.mudanza.exception.FileWithoutNumbersException;
import co.techandsolve.mudanza.exception.MudanzaException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProcessService {

    public String[] getListFile(MultipartFile file) throws MudanzaException {
        try {
            String content = new String(file.getBytes());
            return content.split("\n");
        } catch (IOException e) {
           throw new MudanzaException(e.getMessage());
        }

    }

    public List<Integer> parseIntList(String[] elements) throws FileWithoutNumbersException {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < elements.length; i++) {
            try {
                list.add(Integer.parseInt(elements[i]));
            } catch (NumberFormatException e) {
                throw new FileWithoutNumbersException(e.getMessage());
            }
        }
        return list;
    }

    public String processWorkDays(List<Integer> elements) {
        int numberDays = 0;
        int count;
        StringBuffer result = new StringBuffer();
        for (int z = 1; z < elements.size(); z++) {
            numberDays++;
            int numberObjects = elements.get(z);
            List<Integer> listWeightForDay = new ArrayList<>();
            for (count = z + 1; count <= (z + numberObjects); count++) {
                listWeightForDay.add(elements.get(count));
            }
            String resultDay = "Case #" + numberDays + ": " + calculateTravels(listWeightForDay) + "\n";
            result.append(resultDay);
            z = count - 1;
        }
        return result.toString();
    }

    private int calculateTravels(List<Integer> elements) {
        Integer max = Collections.max(elements);
        elements.remove(Integer.valueOf(max));
        int weight = 0;
        int i = 1;
        int travel = 0;
        while (weight < 50 && max < 50) {
            if (elements.isEmpty())
                return 0;
            Integer min = Collections.min(elements);
            elements.remove(Integer.valueOf(min));
            i++;
            weight = max * i;
        }
        travel++;
        if (elements.size() > 0)
            travel += calculateTravels(elements);
        return travel;
    }
}
