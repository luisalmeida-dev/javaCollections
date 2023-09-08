package set.BasicOperations;

import java.util.HashSet;
import java.util.Set;

public class SingleWords {
    private final Set<String> words;

    public SingleWords() {
        this.words = new HashSet<>();
    }

    public void addWord(String word) {
        words.add(word);
    }

    public void removeWord(String word) {
        words.removeIf(String -> String.equals(word));
    }

    public String verifyWord(String word) {
        if (words.contains(word)) {
            return "The word " + word + " is present!";
        } else {
            return "The word " + word + " isn't present!";
        }
    }

    public Set<String> getWords() {
        return words;
    }

    public static void main(String[] args) {
        SingleWords singleWords = new SingleWords();

        System.out.println("Words: " + singleWords.getWords());

        singleWords.addWord("Feliz");
        singleWords.addWord("Lampada");
        singleWords.addWord("Moto");
        singleWords.addWord("Carro");

        System.out.println("Words: " + singleWords.getWords());

        System.out.println(singleWords.verifyWord("Carro"));

        singleWords.removeWord("Moto");

        System.out.println("Words: " + singleWords.getWords());
    }
}
