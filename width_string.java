import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        
        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;
            
            // Determine how many words fit in the current line
            while (last < words.length && totalChars + 1 + words[last].length() <= maxWidth) {
                totalChars += 1 + words[last].length();
                last++;
            }
            
            // Create the line to be added
            StringBuilder line = new StringBuilder();
            int numberOfWords = last - index;
            int spaces = maxWidth - totalChars;
            
            if (last == words.length || numberOfWords == 1) {
                // Last line or line with only one word
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        line.append(" ");
                    }
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                // Fully justify the current line
                int spaceBetweenWords = spaces / (numberOfWords - 1);
                int extraSpaces = spaces % (numberOfWords - 1);
                
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        int spacesToAdd = spaceBetweenWords + (i - index < extraSpaces ? 1 : 0);
                        for (int j = 0; j < spacesToAdd; j++) {
                            line.append(" ");
                        }
                    }
                }
            }
            
            result.add(line.toString());
            index = last;
        }
        
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        
        List<String> justifiedText = fullJustify(words, maxWidth);
        
        for (String line : justifiedText) {
            System.out.println("|" + line + "|");
        }
    }
}
