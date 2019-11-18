package md2html;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Scanner;

import markup.Paragraph;

public class BlockParser {
    private StringBuilder source;

    public BlockParser(StringBuilder source) {
        this.source = source;
    }

    public int getLvl() {
        int pos = 0;
        while (pos < source.length() && source.charAt(pos) == '#') {
            pos++;
        }
        if (pos < source.length() && source.charAt(pos) == ' ') {
            return pos;
        } else {
            return 0;
        }
    }

    public void toHtml(StringBuilder ans) {
        int lvl = getLvl();
        if (lvl == 0) {
            ans.append("<p>");
            new Paragraph(source.toString()).toHtml(ans);
            ans.append("</p>");
        } else {
            ans.append("<h").append(lvl).append(">");
            new Paragraph(source.toString().substring(lvl + 1)).toHtml(ans);
            ans.append("</h").append(lvl).append(">");
        }
    }
}