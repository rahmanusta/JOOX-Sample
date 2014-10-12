package com.kodcu;

import org.joox.Match;

import java.io.File;
import java.io.IOException;

import static org.joox.JOOX.$;

/**
 * Created by usta on 12.10.2014.
 */
public class CreateApp {

    public static void main(String[] args) throws IOException {

        Match $books = $("<books></books>");

        $books.append("<book id='1'></book>");
        $books.append("<book id='2'></book>");

        $books
                .find("book[id='1']")
                .append("<name>Java ve Yazılım Tasarımı</name>")
                .append("<price>35</price>")
                .append("<author>Altuğ B. Altıntaş</author>");


        $books
                .find("book[id='2']")
                .append("<name>Java Mimarisiyle Kurumsal Çözümler</name>")
                .append("<price>25</price>")
                .append("<author>Rahman Usta</author>");

        $books.write(System.out);
        $books.write(new File("./books.xml"));
        String content = $books.content();
        String text = $books.text();
    }
}
