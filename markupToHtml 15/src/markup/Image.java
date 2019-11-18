package markup;

public class Image implements InParagraph {
    private String name;
    private String link;
    Image(String name, String link) {
        this.name = name;
        this.link = link;
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        System.out.println("Don't use toMarkdown in Image");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        if (name.equals("m")) {
        }
        sb.append("<img alt=").append('\'').append(name).append('\'');
        sb.append(" ");
        sb.append("src=").append('\'').append(link).append('\'');
        sb.append(">");
    }
}
