class Markdown {

    String parse(String markdown) {

        String[] lines = markdown.split("\n");

        StringBuilder result = new StringBuilder();

        boolean activeList = false;

        for (String str : lines) {

            String line = parseHeader(str);

            if (line.equals(str)) {
                line = parseListItem(str);
            }

            if (line.equals(str)) {
                line = parseParagraph(str);
            }

            if (line.startsWith("<li>") && !line.startsWith("<h") && !line.startsWith("<p>") && !activeList) {
                activeList = true;
                result.append("<ul>");
            } else if (!line.startsWith("<li>") && activeList) {
                activeList = false;
                result.append("</ul>");
            }

            result.append(line);
        }

        if (activeList) {
            result.append("</ul>");
        }

        return result.toString();
    }

    private String parseHeader(String markdown) {
        int count = 0;
        String result = markdown;

        for (int i = 0; i < markdown.length() && markdown.charAt(i) == '#'; i++)
        {
            count++;
        }

        if (count != 0) result = "<h" + count + ">" + markdown.substring(count + 1) + "</h" + count + ">";

        return result;
    }

    private String parseListItem(String markdown) {

        String result = markdown;

        if (markdown.startsWith("*")) {
            String skipAsterisk = markdown.replaceFirst("\\* ", "");
            String listItemString = parseTextModifiers(skipAsterisk);
            result = "<li>" + listItemString + "</li>";
        }

        return result;
    }

    private String parseParagraph(String markdown) {
        return "<p>" + parseTextModifiers(markdown) + "</p>";
    }

    private String parseTextModifiers(String markdown) {
        String result = parseStrongText(markdown);
        result = parseEmphasizedText(result);

        return result;
    }

    private String parseStrongText(String markdown) {
        return markdown.replaceAll("__(.+)__", "<strong>$1</strong>");
    }

    private String parseEmphasizedText(String markdown) {
        return markdown.replaceAll("_(.+)_", "<em>$1</em>");
    }
}