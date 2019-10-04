package main.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Saver {


    public static void save(List<NormalBook> normalBookList, String text) throws IOException {

        PrintWriter writer = new PrintWriter("booksNew.txt","UTF-8");

        for (NormalBook normalBook : normalBookList) {
            writer.println(normalBook.toString());
        }
        writer.close();
    }
}