package lv.rgladisevs.word.statistics;

import java.text.MessageFormat;

public class Application {
    private static final String INPUT_FILE_PATH = "input2.txt";

    public static void main(String[] args) {
        FileStringLoader fileStringLoader = new FileStringLoader(INPUT_FILE_PATH);
        String stringFromFile = fileStringLoader.loadString();
        WordStatisticsCollector wordStatisticsCollector = new WordStatisticsCollector(stringFromFile);
        wordStatisticsCollector.collect()
                .forEach(wordStatistics -> {
                    String message = MessageFormat.format("{0} - {1}",
                            wordStatistics.getWord(),
                            wordStatistics.getCount());
                    System.out.println(message);
                });
    }
}
