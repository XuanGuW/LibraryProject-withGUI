package main.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Saver {

    //this project illustrates reading from a file, and writing to a file
    //before you run this the first time, the outputfile will be empty
    //you can open outputfile to see that the entries have been written there
    //notice also that the default folder for the files is the main project folder
    //  not the src directory, or whichever package this class is in.

    //this project also illustrates splitting a line up by spaces

    public static void save(List<NormalBook> normalBookList, String text) throws IOException {

        //List<String> lines = Files.readAllLines(Paths.get("books.txt"));
        PrintWriter writer = new PrintWriter("booksNew.txt","UTF-8");

        for (NormalBook normalBook : normalBookList) {
            writer.println(normalBook.toString());
        }
        writer.close();
    }
}