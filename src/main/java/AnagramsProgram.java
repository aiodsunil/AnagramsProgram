import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class AnagramsProgram {
    public static void main(String[] args) throws IOException {
        var words = readWordsFromFile("words.txt");
        var anagrams = groupByAnagrams(words);
        System.out.println("Please Enter anagram word");
        var sc=new Scanner(System.in);
        var values = anagrams.get(sortWord(sc.next()));
        System.out.println(values);
    }

    public static Map<String, List<String>> groupByAnagrams(List<String> words) {
        Map<String, List<String>> anagrams = new HashMap();
        for (String word : words) {
            var sortedWord = sortWord(word);
            if (anagrams.containsKey(sortedWord)) {
                anagrams.get(sortedWord).add(word);
            } else {
                anagrams.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));
            }
        }
        return anagrams;
    }

    public static String sortWord(String word) {
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static ArrayList<String> readWordsFromFile(String fileName) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(fileName);
        assert inputStream != null;
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufReader = new BufferedReader(streamReader);

        ArrayList<String> listOfWords = new ArrayList<>();
        String line = bufReader.readLine();
        while (line != null) {
            listOfWords.add(line);
            line = bufReader.readLine();
        }
        bufReader.close();
        return listOfWords;
    }
}
