package markup;

import java.util.List;

public class Strikeout extends AbstractListedMarkup implements InParagraph {
    Strikeout(List<InParagraph> list) {
        super(list);
    }

    Strikeout(String s) {
        super(s);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb, "~");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "<s>", "</s>");
    }
}
