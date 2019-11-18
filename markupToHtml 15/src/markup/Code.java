package markup;

public class Code extends AbstractListedMarkup implements InParagraph {
    public Code(String s) {
        super(s);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        System.out.println("DON't use toMarkdown in Code");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "<code>", "</code>");
    }
}
