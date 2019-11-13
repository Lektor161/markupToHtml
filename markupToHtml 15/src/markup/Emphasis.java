package markup;

import java.util.List;

public class Emphasis extends AbstractListedMarkup implements inParagraph {

    Emphasis(List<inParagraph> list) {
        super(list);
    }

    Emphasis(String s) {
        super(s);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb, "*");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "<em>", "</em>");
    }
}
