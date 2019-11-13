package markup;

public interface MarkupText {
    void toMarkdown(StringBuilder sb);

    void toHtml(StringBuilder sb);
}
