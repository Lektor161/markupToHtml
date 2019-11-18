package md2html;

import java.io.*;
import java.util.Scanner;

public class Md2Html {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        try (Scanner sc = new Scanner(new File(args[0]), "UTF-8")) {

            while (sc.hasNextLine()) {
                StringBuilder block = new StringBuilder();
                String curLine = sc.nextLine();

                if (curLine.length() == 0) {
                    continue;
                }

                block.append(curLine);

                while (sc.hasNextLine()) {
                    curLine = sc.nextLine();
                    if (curLine.equals("")) {
                        break;
                    }
                    block.append('\n').append(curLine);
                }

                if (block.length() > 0) {
                    new BlockParser(block).toHtml(result);
                    result.append('\n');
                    block = new StringBuilder();
                }
            }
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
            out.print(result.toString());

        } catch (FileNotFoundException e) {
            System.out.println("File error " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.println("File encoding error " + e.getMessage());
        }
    }
}