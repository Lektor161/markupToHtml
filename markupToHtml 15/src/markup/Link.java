package markup;

public class Link implements InParagraph {
    private String name;
    private String link;

    Link(String name, String link) {
        this.name = name;
        this.link = link;
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        System.out.println("Don't use toMarkdown in Link");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        sb.append("<a href=");
        sb.append('\'').append(link).append('\'');
        sb.append(">");
        new Paragraph(name).toHtml(sb);
        sb.append("</a>");
    }
}
