import java.awt.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class HttpURLConnectionExample {

    public static void main(String[] args) throws Exception {

        HttpURLConnectionExample obj = new HttpURLConnectionExample();

        System.out.println("Testing 1 - Send Http GET request");
        obj.sendGet();

    }

    private void sendGet() throws Exception {
        String str = "public class MyClass { public static void main(String[] args) { double myDouble = 9.78; int myInt = (int) myDouble; // Manual casting: double to int System.out.println(myDouble);   // Outputs 9.78 System.out.println(myInt);      // Outputs 9 } }";
        str = str.replaceAll("\\s|\\{|\\(|\\[|]|\\)|}", "%20");
        String url = "http://127.0.0.1:5000/tokenize?context="+str;

        HttpURLConnection httpClient =
                (HttpURLConnection) new URL(url).openConnection();

        // optional default is GET
        httpClient.setRequestMethod("GET");

        //add request header
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = httpClient.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI(url);
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }