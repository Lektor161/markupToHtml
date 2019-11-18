package markup;

import java.util.List;

public class Strong extends AbstractListedMarkup implements InParagraph {
    Strong(List<InParagraph> list) {
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
