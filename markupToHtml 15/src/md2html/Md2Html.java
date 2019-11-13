package md2html;

import java.io.*;
import java.util.Scanner;

import markup.ParagraphList;

public class Md2Html {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(new File(args[0]), "UTF-8")) {
            ParagraphList paragraphList = new ParagraphList(sc);
            paragraphList.toHtml(sb);
        } catch (FileNotFoundException e) {
            System.out.println("File don't found " + e.getMessage());
        }

        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(new File(args[1])),
                                "utf8"
                        ),
                        1024
                )
        )) {
            //out.println("<head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"> </head>\n");
            out.print(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println("File error " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.println("File encoding error " + e.getMessage());
        }
    }
}