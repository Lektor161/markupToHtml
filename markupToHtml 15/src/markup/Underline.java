package markup;

import java.util.List;

public class Underline extends AbstractListedMarkup implements InParagraph {
    Underline(List<InParagraph> elements) {
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
