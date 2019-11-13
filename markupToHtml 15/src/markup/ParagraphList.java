package markup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParagraphList {
    private List<Paragraph> elements;
    private List<Integer> headersLevel;

    public ParagraphList(Scanner sc) {

        headersLevel = new ArrayList<>();
        elements = new ArrayList<>();
        while (sc.hasNextLine()) {
            StringBuilder sb = new StringBuilder();
            String curLine = sc.nextLine();

            if (curLine.length() == 0) {
                continue;
            }

            int pos = 0;
            while (pos < curLine.length() && curLine.charAt(pos) == '#') {
                pos++;
            }

            if (pos == 0 || pos == curLine.length() || curLine.charAt(pos) != ' ') {
                pos = 0;
                headersLevel.add(0);
            } else {
                headersLevel.add(pos);
                pos++;
            }

            for (; pos < curLine.length(); pos++) {
                sb.append(curLine.charAt(pos));
            }

            if (sc.hasNextLine()) {
                curLine = sc.nextLine();
            } else {
                curLine = "";
            }

            while (curLine.length() > 0) {
                sb.append("\n");
                sb.append(curLine);
                if (sc.hasNextLine()) {
                    curLine = sc.nextLine();
                } else {
                    curLine = "";
                }
            }

            if (sb.length() > 0) {
                elements.add(new Paragraph(sb.toString()));
                sb = new StringBuilder();
            }
        }
    }

    public void toHtml(StringBuilder ans) {
        for (int i = 0; i < elements.size(); i++) {
            if (headersLevel.get(i) == 0) {
                ans.append("<p>");
            } else {
                ans.append("<h").append(headersLevel.get(i)).append(">");
            }

            elements.get(i).toHtml(ans);

            if (headersLevel.get(i) == 0) {
                ans.append("</p>");
            } else {
                ans.append("</h").append(headersLevel.get(i)).append(">");
            }

            if (i + 1 < elements.size()) {
                ans.append("\n");
            }
        }
    }
}