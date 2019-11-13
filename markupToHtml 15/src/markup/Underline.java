package markup;

import java.util.List;

public class Underline extends AbstractListedMarkup implements inParagraph {
    Underline(List<inParagraph> elements) {
        super(elements);
    }

    Underline(String s) {
        super(s);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        System.out.println("Don't use toMarkDown in Underline");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "<u>", "</u>");
    }
}
