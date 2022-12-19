package org.deadcryd.unit_05.task_01_and_02;

import org.deadcryd.unit_05.task_01_and_02.logic.KeywordCounter;
import org.deadcryd.unit_05.task_01_and_02.logic.WordsLoader;

public class TaskRunnerFirst {

    public static void main(String[] args) {
        KeywordCounter.printCount(WordsLoader::loadWordsWithByteIO);
    }
}
