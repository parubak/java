package com.java_lessons;

public class CountryInfo {
    private String country;
    private String capitals;

    public CountryInfo(String country, String capitals) {
        this.country = country;
        this.capitals = capitals;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapitals() {
        return capitals;
    }

    public void setCapitals(String capitals) {
        this.capitals = capitals;
    }

    @Override
    public String toString() {
        return "{"
                + '\'' + country + '\'' + "-->"  + '\'' + capitals + '\'' +
                '}';
    }
}
