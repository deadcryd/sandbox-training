package org.deadcryd.unit_05.task_01_and_02.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KeywordCounter {

    private static final String KEYWORDS_FILE_NAME = "unit-05/src/main/resources/keywords.csv";
    private static final String SOURCE_FILE_NAME = "unit-05/src/main/resources/SourceFileExample.java";

    public static void printCount(Function<String, List<String>> loadWords) {
        List<String> keywords = loadWords.apply(KEYWORDS_FILE_NAME);
        List<String> words = loadWords.apply(SOURCE_FILE_NAME);

        Map<String, Integer> keywordsMap = new HashMap<>();
        keywords.forEach(keyword -> keywordsMap.put(keyword, 0));

        for (String word : words) {
            if (keywordsMap.containsKey(word)) {
                keywordsMap.replace(word, keywordsMap.get(word) + 1);
            }
        }

        printMap(keywordsMap);
    }

    private static void printMap(Map<?, ?> map) {
        map.keySet().forEach(
            key -> System.out.printf("%s:%s\n", key, map.get(key))
        );
    }
}
