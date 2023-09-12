package org.example;

import java.util.Arrays;

public class Port {
    public Port(String[] indexes) {
        this.indexes = indexes;
    }
    public Port() {
    }

    public String[] getIndexes() {
        return indexes;
    }

    public void setIndexes(String[] indexes) {
        this.indexes = indexes;
    }

    private String [] indexes;

}
