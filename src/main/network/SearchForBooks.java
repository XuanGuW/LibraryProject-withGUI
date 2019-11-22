
package network;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SearchForBooks {
    public static void main(String[] args) throws IOException {

        BufferedReader br = null;

        try {
            String theURL = "https://www.googleapis.com/books/v1/volumes?q=books+intitle:book&key=AIzaSyD4H6aWE1aBnfX0E-SeumMbL8l210H-SoY";
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
            tryJson(sb.toString());
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }


    private static void tryJson(String jsonString) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
            JSONArray itemsArray = (JSONArray) jsonObject.get("items");
            JSONArray booksInfo;
            JSONArray bookNames;



            booksInfo = helper(itemsArray,"volumeInfo");
            bookNames = helper(booksInfo,"title");
            System.out.println("Here are the books you are searching for: ");

            for (Object bookName: bookNames) {
                String bookNameInString = bookName.toString();
                System.out.println(bookNameInString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static JSONArray helper(JSONArray itemsArray, String s) {
        JSONArray newList = new JSONArray();
        for (Object j: itemsArray) {
            JSONObject jsonObject1 = (JSONObject) j;
            newList.add(jsonObject1.get(s));
        }
        return newList;

    }


}
