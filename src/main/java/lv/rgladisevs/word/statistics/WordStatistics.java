package lv.rgladisevs.word.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WordStatistics implements Comparable<WordStatistics> {
    private String word;
    private Long count;

    @Override
    public int compareTo(WordStatistics comparedTo) {
        int compareByCount = this.count.compareTo(comparedTo.count);
        int result = -compareByCount;
        if (result == 0) {
            result = this.word.compareTo(comparedTo.word);
        }
        return result;
    }
}
