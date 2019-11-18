package markup;

import java.util.List;

public class Paragraph extends AbstractListedMarkup {

    Paragraph(List<InParagraph> list) {
        super(list);
    }

    public Paragraph(String s) {
        super(s);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb, "");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "", "");
    }
}
