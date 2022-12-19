package org.deadcryd.unit_05.task_01_and_02.logic;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WordsLoader {

    private static final Set<Character> SEPARATORS = new HashSet<>(
        List.of('\r', '\n', '\t', ' ', '(', ')', '[', ']', '{', '}', ';', ',', '.')
    );

    public static List<String> loadWordsWithByteIO(String fileName) {

        byte[] fileBytes;
        List<String> words = new ArrayList<>();
        StringBuilder wordBuilder = new StringBuilder();

        try (FileInputStream fileStream = new FileInputStream(fileName)) {
            fileBytes = fileStream.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (byte fileByte : fileBytes) {
            wordBuilder = buildWord(Character.toChars(fileByte)[0], wordBuilder, words);
        }
        return words;
    }

    public static List<String> loadWordsWithCharacterIO(String fileName) {

        List<Character> fileCharts = new ArrayList<>();
        List<String> words = new ArrayList<>();
        StringBuilder wordBuilder = new StringBuilder();

        try (FileReader fileStream = new FileReader(fileName)) {

            char[] buffer = new char[512];
            int countChars;

            while ((countChars = fileStream.read(buffer)) != -1) {
                for (int i = 0; i < countChars; i++) {
                    fileCharts.add(buffer[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (char fileChar : fileCharts) {
            wordBuilder = buildWord(fileChar, wordBuilder, words);
        }
        return words;
    }

    private static StringBuilder buildWord(Character character, StringBuilder wordBuilder, List<String> words) {
        if (SEPARATORS.contains(character)) {
            if (!wordBuilder.isEmpty()) {
                words.add(wordBuilder.toString());
                wordBuilder = new StringBuilder();
            }
        } else {
            wordBuilder.append(character);
        }
        return wordBuilder;
    }
}
