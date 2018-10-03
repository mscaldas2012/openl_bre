package com.baeldung.openltablets.model;

/**
 * @Created - 10/3/18
 * @Author Marcelo Caldas mcq1@cdc.gov
 */
public class CatchmentArea {
    private String state;
    private String county;
    private int age;

    public CatchmentArea(String state) {
        this.state = state;
    }

    public CatchmentArea(String state, String county, int age) {
        this.state = state;
        this.county = county;
        this.age = age;
    }

    public CatchmentArea() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
