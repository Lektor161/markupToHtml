package markup;

public class Text implements inParagraph {
    String text;

    Text(String text) {
        this.text = text;
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        sb.append(text);
    }

    @Override
    public void toHtml(StringBuilder sb) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\\' && i + 1 < text.length() && (text.charAt(i + 1) != 'n' && text.charAt(i + 1) != 'r')) {
                continue;
            }

            char c = text.charAt(i);
            switch (c) {
                case ('<'):
                    sb.append("&lt;");
                    break;

                case ('>'):
                    sb.append("&gt;");
                    break;

                case ('&'):
                    sb.append("&amp;");
                    break;

                default:
                    sb.append(c);
            }
        }
    }
}
