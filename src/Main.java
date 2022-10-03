import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static Map<String, Integer> getWordFrequency(String phrase){
        Map<String, Integer> wordsMap = new HashMap<>();
        String[] wordsInPhrase = phrase.split(" ");
        for(String word : wordsInPhrase){
            if(!wordsMap.containsKey(word)){
                wordsMap.put(word,1);
            } else {
                wordsMap.put(word, wordsMap.get(word) + 1);
                }
            }
        Map<String,Integer> wordFrequencyMap = wordsMap.entrySet()
                                                        .stream()
                                                         .sorted((w1,w2) -> w2.getValue().compareTo(w1.getValue())).collect(Collectors.toMap(
                                                                 Map.Entry::getKey,
                                                                    Map.Entry::getValue,
                        (w1,w2) -> w1,LinkedHashMap::new));

        return wordFrequencyMap;
    }

    public static void main(String[] args){
        String phrase = "the cat is out of the bag";
        System.out.println(getWordFrequency(phrase));
    }
}