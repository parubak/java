package com.java_lessons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<CountryInfo> countryCollection=new ArrayList<>();
        String countries="";
        String capitals="";

        try(Scanner s = new Scanner(new FileInputStream("src/countries.txt")).useDelimiter("\\A")) {
            countries = s.hasNext() ? s.next() : "";

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Прочитан файл countries.txt");

        try(Scanner s = new Scanner(new FileInputStream("src/capitals.txt")).useDelimiter("\\A")) {
            capitals = s.hasNext() ? s.next() : "";

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Прочитан файл capitals.txt");

        StringTokenizer tokenizerCountries=new StringTokenizer(countries);
        StringTokenizer tokenizerCapitals=new StringTokenizer(capitals);

        while (tokenizerCapitals.hasMoreTokens()&&tokenizerCountries.hasMoreTokens()){
            countryCollection.add(new CountryInfo(tokenizerCountries.nextToken(),tokenizerCapitals.nextToken()));
        }
        System.out.println("\nСоздана коллекция объектов CountryInfo:");
        countryCollection.forEach(countryInfo -> System.out.println(countryInfo.toString()));

        System.out.println("\nКоллекция отсортирована по полю country:");
        countryCollection.sort(new Comparator<CountryInfo>() {
            @Override
            public int compare(CountryInfo o1, CountryInfo o2) {
                return o1.getCountry().compareTo(o2.getCountry());
            }
        });
        countryCollection.forEach(countryInfo -> System.out.println(countryInfo.toString()));

        System.out.println("\nКоллекция отсортирована по полю capitals:");
        countryCollection.sort(new Comparator<CountryInfo>() {
            @Override
            public int compare(CountryInfo o1, CountryInfo o2) {
                return o1.getCapitals().compareTo(o2.getCapitals());
            }
        });
        countryCollection.forEach(countryInfo -> System.out.println(countryInfo.toString()));


    }
}
