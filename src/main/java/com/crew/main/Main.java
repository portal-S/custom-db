package com.crew.main;

import com.crew.model.Entry;
import com.crew.operation.DefaultDataManipulator;
import com.crew.operation.inerface.DataManipulator;

public class Main {

    DataManipulator manipulator = new DefaultDataManipulator();

    public static void main(String[] args) {

    }

    /**
        the required variable (data) format is "key;value"
     */
    public void write(String data) {

        Entry entry = prepareEntry(data);

        manipulator.write(entry);

    }

    public Entry read(String key) {
        return manipulator.read(key);
    }

    public Entry prepareEntry(String data) {

        String[] splitted = data.split(";");

        if(splitted.length != 2) {
            throw new IllegalArgumentException("the required variable (data) format is \"key;value\"");
        }

        String key = splitted[0];
        String value = splitted[1];

        Entry entry = new Entry(key, value);

        return entry;
    }
}
