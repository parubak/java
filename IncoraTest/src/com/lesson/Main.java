package com.lesson;

import com.lesson.temp.Genre;
import com.lesson.video.Episode;
import com.lesson.video.Movie;
import com.lesson.video.Show;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Main {

    public static void main(String[] args) {
        String nameMovie="MOviE";
        String nameEpisode="Episode";
//Створюємо Genre
        ArrayList<Genre> genr1=new ArrayList<>();
        ArrayList<Genre> genr2=new ArrayList<>();
        //додаємо
        genr1.add(new Genre("Ganr№1"));
        genr1.add(new Genre("GAN№3"));
        genr1.add(new Genre("GA№4"));
        genr2.add(new Genre("GA№4"));
        genr2.add(new Genre("G№5"));

//Створюємо "Show"
        LinkedHashSet<Show> shows=new LinkedHashSet<>();
        //додаємо
        shows.add(new Movie(nameMovie+2,genr2, LocalTime.ofSecondOfDay(555), LocalDate.of(2022,1,1)));
        shows.add(new Episode(nameEpisode+7,genr2, LocalTime.ofSecondOfDay(555), LocalDate.of(2022,1,1)));
        //додаємо
        int generate=10;
        Show newShow;
        for (int i = 1; i <= generate; i++) {
            newShow=new Movie(nameMovie+i,genr1,LocalTime.ofSecondOfDay(5*i), LocalDate.of(2022,1,1));
            if (!shows.add(newShow)){
                System.out.println(String.format("There is such a show (%s)",newShow.name));
            }
        }
        for (int i = 1; i <= generate; i++) {
            newShow=new Episode(nameEpisode+i,genr2,LocalTime.ofSecondOfDay(10*i), LocalDate.of(1999,1,1));
            if (!shows.add(newShow)){
                System.out.println(String.format("There is such a show (%s)",newShow.name));
            }
        }
        System.out.println();

//Створюємо "StreamingService"
        StreamingService service=new StreamingService("SSerVice"
                ,shows);
//Створюємо "Subscription"
        ArrayList<Subscription> subscriptions=new ArrayList<>();
       subscriptions.add(new Subscription(service));
//Створюємо "User"
        User user=new User(subscriptions);
        //Помилково згодовуем той же "StreamingService"
//        StreamingService service2=new StreamingService("SSerVice",shows);
//        user.subscribe(service2);
//      System.out.println();

        //перегляди
        user.getSubscript(1).watch(nameMovie+7);
        user.getSubscript(1).watch(nameMovie+7);
        user.getSubscript(1).watch(nameMovie+7);
        user.getSubscript(1).watch(nameMovie+3);
        user.getSubscript(1).watch(nameEpisode+3);
        user.getSubscript(1).watch(nameEpisode+7);
        user.getSubscript(1).watch(nameEpisode+7);
        System.out.println();

        user.getSubscript(1).watch(user.getSubscript(1).getRecommendationByGenre(new Genre("GA№4")).name);

        user.getSubscript(1).watch(user.getSubscript(1).getRecommendationTrending().name);



    }


}
