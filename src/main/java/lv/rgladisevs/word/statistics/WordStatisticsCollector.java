package lv.rgladisevs.word.statistics;

import lombok.AllArgsConstructor;

import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

@AllArgsConstructor
public class WordStatisticsCollector {
    private String input;

    public Stream<WordStatistics> collect() {
        return Pattern.compile("[a-zA-Z\\-]*")
                .matcher(input.toLowerCase())
                .results()
                .map(MatchResult::group)
                .filter(not(String::isEmpty))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(entry -> new WordStatistics(entry.getKey(), entry.getValue()))
                .sorted();
    }
}
