package com.example.springenvers.domain;

public enum Job {
    Student("학생"), Teacher("교사");

    private String krName;

    Job(String krName) {
        this.krName = krName;
    }

    public String getKrName(){
        return this.krName;
    }
}
