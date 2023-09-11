package map.Search;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private final Map<String, Integer> words;

    public WordCounter() {
        this.words = new HashMap<>();
    }

    public void addWord(String word, Integer quantity) {
        words.put(word, quantity);
    }

    public void deleteOneWord(String word) {
        for (String string : words.keySet()) {
            if (string.equalsIgnoreCase(word)) {
                words.put(word, (words.get(word) - 1));
            }
        }
    }

    public Map<String, Integer> getAll() {
        return words;
    }

    public Map<String, Integer> getMostFrequent() {
        Map<String, Integer> frequentMap = new HashMap<>();
        Map.Entry<String, Integer> mostFrequent = null;
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (mostFrequent == null || entry.getValue() > mostFrequent.getValue()) {
                mostFrequent = entry;
            }
        }

        if (mostFrequent != null) {
            frequentMap.put(mostFrequent.getKey(), mostFrequent.getValue());
        }
        return frequentMap;
    }

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();
        System.out.println("All words: " + wordCounter.getAll());

        wordCounter.addWord("Luis", 3);
        wordCounter.addWord("Beans", 24);
        wordCounter.addWord("Wardrobe", 333);
        wordCounter.addWord("Car", 8);

        System.out.println("All words: " + wordCounter.getAll());

        wordCounter.deleteOneWord("Wardrobe");

        System.out.println("All words: " + wordCounter.getAll());

        System.out.println("Most frequent: " + wordCounter.getMostFrequent());

    }
}
