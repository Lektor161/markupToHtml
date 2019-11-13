package markup;

import java.util.List;

public class Strong extends AbstractListedMarkup implements inParagraph {
    Strong(List<inParagraph> list) {
        super(list);
    }

    Strong(String s) {
        super(s);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb, "__");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "<strong>", "</strong>");
    }
}
