package map.BasicOperations;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private final Map<String, String> words;


    public Dictionary() {
        this.words = new HashMap<>();
    }

    public void addWord(String word, String definition) {
        words.put(word, definition);
    }

    public void removeWord(String word) {
        words.remove(word);
    }

    public Map<String, String> getAll() {
        return words;
    }

    public String getByWord(String word) {
        return words.get(word);
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.addWord("Linde", "Linha que divide ou limita duas extensões territoriais.");
        dictionary.addWord("Condensar", "Tornar mais denso, reduzir a menor volume; engrossar: condenar as linhas de uma pintura; as sombras se condensaram.");
        dictionary.addWord("Brasa", "Carvão ardente, mas sem chama.");
        dictionary.addWord("Consaguineo", "Que possui o mesmo tipo sanguíneo.");

        System.out.println("All words: " + dictionary.getAll());
        dictionary.removeWord("Brasa");
        System.out.println("All words: " + dictionary.getAll());

        System.out.println("Get by word: " + dictionary.getByWord("Linde"));

    }
}
