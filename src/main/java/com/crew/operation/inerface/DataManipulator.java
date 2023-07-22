package com.crew.operation.inerface;

import com.crew.model.Entry;

public interface DataManipulator {
    void write(Entry entry);

    Entry read(String key);

}
