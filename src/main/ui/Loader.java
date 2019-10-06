package main.ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loader {

    public static void load(List<NormalBook> normalBookList,String text) throws IOException {
        List<String> lineOfStrings = Files.readAllLines(Paths.get("books.txt"));
        for (String string : lineOfStrings) {
            ArrayList<String> partsOfLine = splitOnSpace(string);
            NormalBook b = new NormalBook("","");
            b.name = partsOfLine.get(0);
            b.author = partsOfLine.get(1);
            normalBookList.add(b);
            System.out.println(b.name);
        }

    }


    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}