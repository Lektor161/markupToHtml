package markup;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractListedMarkup implements MarkupText {
    private List<inParagraph> elements;

    AbstractListedMarkup(List<inParagraph> elements) {
        this.elements = elements;
    }

    public AbstractListedMarkup(String s) {
        elements = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (isSingleChar(s, i, '*') || isSingleChar(s, i, '_')) {
                int j = nextSingleChar(s, i + 1, s.charAt(i));
                if (j != s.length()) {
                    elements.add(new Text(sb.toString()));
                    sb = new StringBuilder();
                    elements.add(new Emphasis(s.substring(i + 1, j)));
                    i = j + 1;
                    continue;
                }
            }

            if (isSingleChar(s, i, '`')) {
                int j = nextSingleChar(s, i + 1, s.charAt(i));
                if (j != s.length()) {
                    elements.add(new Text(sb.toString()));
                    sb = new StringBuilder();
                    elements.add(new Code(s.substring(i + 1, j)));
                    i = j + 1;
                    continue;
                }
            }

            if (isDoubleChar(s, i, '*') || isDoubleChar(s, i, '_')) {
                int j = nextDoubleChar(s, i + 1, s.charAt(i));
                if (j != s.length()) {
                    elements.add(new Text(sb.toString()));
                    sb = new StringBuilder();
                    elements.add(new Strong(s.substring(i + 2, j)));
                    i = j + 2;
                    continue;
                }
            }

            if (isDoubleChar(s, i, '-')) {
                int j = nextDoubleChar(s, i + 1, s.charAt(i));
                if (j != s.length()) {
                    elements.add(new Text(sb.toString()));
                    sb = new StringBuilder();
                    elements.add(new Strikeout(s.substring(i + 2, j)));
                    i = j + 2;
                    continue;
                }
            }

            if (isDoubleChar(s, i, '+')) {
                int j = nextDoubleChar(s, i + 1, s.charAt(i));
                if (j != s.length()) {
                    elements.add(new Text(sb.toString()));
                    sb = new StringBuilder();
                    elements.add(new Underline(s.substring(i + 2, j)));
                    i = j + 2;
                    continue;
                }
            }

            sb.append(s.charAt(i));
            i++;
        }
        elements.add(new Text(sb.toString()));
    }

    private int nextDoubleChar(String s, int i, char c) {
        while (i < s.length() && !isDoubleChar(s, i, c)) {
            i++;
        }
        return i;
    }

    private int nextSingleChar(String s, int i, char c) {
        while (i < s.length() && !isSingleChar(s, i, c)) {
            i++;
        }
        return i;
    }

    private boolean isDoubleChar(String s, int i, char c) {
        return (s.charAt(i) == c && (i == 0 || (s.charAt(i - 1) != c && s.charAt(i - 1) != '\\')) && (i + 1 < s.length() || s.charAt(i + 1) == c));
    }

    private boolean isSingleChar(String s, int i, char c) {
        return (s.charAt(i) == c && (i == 0 || (s.charAt(i - 1) != c && s.charAt(i - 1) != '\\')) && (i == s.length() - 1 || s.charAt(i + 1) != c));
    }

    public void toMarkdown(StringBuilder sb, String sign) {
        sb.append(sign);
        for (inParagraph text : elements) {
            text.toMarkdown(sb);
        }
        sb.append(sign);
    }

    public void toHtml(StringBuilder sb, String firstSign, String lastSign) {
        sb.append(firstSign);
        for (inParagraph text : elements) {
            text.toHtml(sb);
        }
        sb.append(lastSign);
    }

}