package main.ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loader {

    //this project illustrates reading from a file, and writing to a file
    //before you run this the first time, the outputfile will be empty
    //you can open outputfile to see that the entries have been written there
    //notice also that the default folder for the files is the main project folder
    //  not the src directory, or whichever package this class is in.

    //this project also illustrates splitting a line up by spaces

    public static void load(List<NormalBook> normalBookList,String text) throws IOException {
        List<String> lineOfStrings = Files.readAllLines(Paths.get("books.txt"));
        for (String string : lineOfStrings) {
            ArrayList<String> partsOfLine = splitOnSpace(string);
            NormalBook b = new NormalBook("","");
            b.name = partsOfLine.get(0);
            b.author = partsOfLine.get(1);
            normalBookList.add(b);
        }

    }


    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}