package lv.rgladisevs.word.statistics;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class WordStatisticsCollectorTest {

    @Test
    public void collect() {
        WordStatisticsCollector collector = new WordStatisticsCollector("Dorothy, dorothy saw a quasi-bird creature which terrified her.");
        List<WordStatistics> result = collector.collect()
                .collect(Collectors.toList());
        assertThat(result, hasSize(8));
        assertWordStatistics(result, 0, "dorothy", 2L);
        assertWordStatistics(result, 1, "a", 1L);
        assertWordStatistics(result, 2, "creature", 1L);
        assertWordStatistics(result, 3, "her", 1L);
        assertWordStatistics(result, 4, "quasi-bird", 1L);
        assertWordStatistics(result, 5, "saw", 1L);
        assertWordStatistics(result, 6, "terrified", 1L);
        assertWordStatistics(result, 7, "which", 1L);
    }

    private void assertWordStatistics(List<WordStatistics> result, int index, String word, Long count) {
        WordStatistics wordStatistics = result.get(index);
        assertEquals(word, wordStatistics.getWord());
        assertEquals(count, wordStatistics.getCount());
    }
}