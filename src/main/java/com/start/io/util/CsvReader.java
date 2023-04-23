package com.start.io.util;

import com.start.io.entity.Data;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CsvReader {
    public static HashMap<String, Data> readFromCsv(String filePath) {
        List<Data> dataList = new ArrayList<>();
        HashMap<String,Data>map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the first line (header)
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                Data data = new Data();
                data.setSessionId(values[0]);
                data.setAdvertiserId(values[1]);
                data.setCountry(values[2]);
                data.setPrice(Double.parseDouble(values[3]));
                data.setEventTypeId(Integer.parseInt(values[4]));
                data.setGdpr(Double.parseDouble(values[5]));
                data.setMinCpm(Double.parseDouble(values[6]));
                data.setPriority(Double.parseDouble(values[7]));
                data.setBidPrice(Double.parseDouble(values[8]));


                dataList.add(data);
                map.put(data.getSessionId(),data);

            }
        } catch (IOException e) {
            System.out.println("could not read csv file ,aborting...");
        }

        return map;
    }
}