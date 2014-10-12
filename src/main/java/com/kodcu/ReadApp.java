package com.kodcu;

import org.joox.JOOX;
import org.joox.Match;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import static org.joox.JOOX.$;

/**
 * Created by usta on 12.10.2014.
 */
public class ReadApp {

    public static void main(String[] args) throws IOException, SAXException {

        Match $books = $(new File("./books.xml"));

        // Örnek 1
        $books.find("book").forEach(book -> {
            String id = $(book).attr("id");
            String name = $(book).find("name").text();
            String author = $(book).find("author").text();
            String price = $(book).find("price").text();

            System.out.format("%s : %s - %s - %s %n", id, name, author, price);
        });

        // Örnek 2
        Match firstBook = $books.find("book").first();
        Match lastBook =  $books.find("book").last();

        String firstBookAuthorName = firstBook.find("author").text();
        String lastBookName = lastBook.find("name").text();

        System.out.format("firstBookAuthorName: %s %n",firstBookAuthorName);
        System.out.format("lastBookName: %s %n",lastBookName);
    }
}
