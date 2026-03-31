import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        
        // Regex Breakdown:
        // <(.+)>       : Matches the start tag and captures the tag name in Group 1.
        // ([^<]+)      : Matches the content. [^<] ensures no nested tags exist inside. 
        //                The content is captured in Group 2.
        // </\\1>       : Matches the closing tag. \\1 is a backreference to Group 1.
        String regex = "<(.+)>([^<]+)</\\1>";
        Pattern pattern = Pattern.compile(regex);

        while (testCases > 0) {
            String line = in.nextLine();
            Matcher matcher = pattern.matcher(line);
            boolean found = false;

            while (matcher.find()) {
                System.out.println(matcher.group(2));
                found = true;
            }

            if (!found) {
                System.out.println("None");
            }
            testCases--;
        }
        in.close();
    }
}
