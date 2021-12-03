package com.example.wsr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DBhelper {
    public static ArrayList <String> Trend;
    public static ArrayList <String> ForYou;
    public static ArrayList <String> New;
    public static Response response;
    public static String baseURl = "http://cinema.areas.su";
    public static String imageURL ="http://cinema.areas.su/up/images/";

    public static void Trends() {
        Trend = new ArrayList<>  ();
        Trend = new ArrayList <> ( );
        Trend.add (imageURL + "umbrella.jpeg");
        Trend.add (imageURL + "magicians.png");
        Trend.add (imageURL + "567640.jpg");
        Trend.add (imageURL + "The_Call_of_the_Wild_(poster).jpg");
        Trend.add (imageURL + "Sputnik.jpg");
        Trend.add (imageURL + "74452446f50a11777432dc992576cac1.jpg");
        Trend.add (imageURL + "567640.jpg");
        Trend.add (imageURL + "74452446f50a11777432dc992576cac1.jpg");
        Trend.add (imageURL + "74452446f50a11777432dc992576cac1.jpg");
    }

    public static void ForU() {
        ForYou = new ArrayList<> ( );
        ForYou.add (imageURL + "umbrella.jpeg");
        ForYou.add (imageURL + "e05c2d133f245ee347e7f96edfd9a0.jpg");
        ForYou.add (imageURL + "138193.jpg");
        ForYou.add (imageURL + "kinopoisk.ru-Memoriseuteu-3483691.jpg");
        ForYou.add (imageURL + "umbrella.jpeg");
        ForYou.add (imageURL + "30891708-1170704.jpg");
        ForYou.add (imageURL + "umbrella.jpeg");
        ForYou.add (imageURL + "30891708-1170704.jpg");
        ForYou.add (imageURL + "30891708-1170704.jpg");
        ForYou.add (imageURL + "30891708-1170704.jpg");
        ForYou.add (imageURL + "umbrella.jpeg");
        ForYou.add (imageURL + "30891708-1170704.jpg");
    }

    public static void News(){
        New = new ArrayList<> ( );
        New.add (imageURL + "Harry_Potter.jpg");
        New.add (imageURL + "kinopoisk.ru-The-Lion-King-3351468.jpg");
        New.add (imageURL + "200-1000x830.jpg");
        New.add (imageURL + "prostokvashino.jpeg");
        New.add (imageURL + "download.jpeg");
        New.add (imageURL + "kinopoisk.ru-The-Lion-King-3351468.jpg");
        New.add (imageURL + "200-1000x830.jpg");
        New.add (imageURL + "kinopoisk.ru-The-Lion-King-3351468.jpg");
        New.add (imageURL + "200-1000x830.jpg");
        New.add (imageURL + "prostokvashino.jpeg");
        New.add (imageURL + "74452446f50a11777432dc992576cac1.jpg");
    }

    public static boolean checkmail(String mail) {
        Pattern pattern = Pattern.compile ("^[\\w\\.]+@\\w+\\.\\w+$");
        if(! pattern.matcher(mail).find()) return false;
        else return true;
    }

    public static boolean checkpass(String pass){
        Pattern pat1 = Pattern.compile("[\\W+]");
        Pattern pat2 = Pattern.compile("[\\d+]");
        Pattern pat3 = Pattern.compile("[A-Z[А-Я]]+");
        if (! pat1.matcher(pass).find() || ! pat2.matcher(pass).find() || ! pat3.matcher(pass).find() || pass.length() < 8) {
            return false;
        }else return true;
    }
    public static Response SignInPost (String mail, String pass) throws IOException{
        OkHttpClient client = new OkHttpClient( );
        String jsonData = "{"+
                "\"email:\" \"" + mail + "\", " +
                "\"password:\" \"" + pass + "\"," +
                "}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonData);

        Request request = new Request.Builder( )
                .url(baseURl + "/auth/login").addHeader("Authorization", "Bearer yanin")
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        DBhelper.response = response;
        return response;
    }

    public static Response RegPOST (String mail, String pass, String name, String surname) throws IOException {
        String jsonData = "{" +
                "\"email:\" \"" + mail + "\", "+
                "\"password:\" \"" + pass + "\", "+
                "\"username:\"  \"" + name + "\", "+
                "\"surname:\"  \"" + surname + "\", "+
                "}";
        OkHttpClient client = new OkHttpClient( );

        RequestBody requestBody = RequestBody.create(MediaType.parse("applocation/json"), jsonData);

        Request request = new Request.Builder( )
                .url(baseURl + "/auth/register").addHeader("Authorization", "Bearer yanin")
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        DBhelper.response = response;
        return response;
    }
}


