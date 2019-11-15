
package network;

import javax.xml.bind.ParseConversionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class SearchForBooks {
    public static void main(String[] args) throws MalformedURLException, IOException {

        BufferedReader br = null;

        try {
            String theURL = "https://www.googleapis.com/books/v1/volumes?q=book+inauthor:keyes&key=AIzaSyD4H6aWE1aBnfX0E-SeumMbL8l210H-SoY";
            //this can point to any URL
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            
            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }




}
