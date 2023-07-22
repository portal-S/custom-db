package com.crew.operation;

import com.crew.model.Entry;
import com.crew.operation.inerface.DataManipulator;

import java.io.*;

public class DefaultDataManipulator implements DataManipulator {

    private ReadProperties readProperties = new ReadProperties();

    @Override
    public void write(Entry entry) {

        String result = entry.key() + ";" + entry.value();

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(readProperties.readProperty("storage.destination"), true));
            writer.append(result);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public Entry read(String key) {

        String result = null;

        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/storage.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {

                if(line.startsWith(key)) {
                    String lineKey = line.split(";")[0];
                    if(lineKey.equals(key)) {
                        result = line;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(result == null) {
            return null;
        }

        String[] resArray = result.split(";");

        return new Entry(resArray[0], resArray[1]);
    }
}
