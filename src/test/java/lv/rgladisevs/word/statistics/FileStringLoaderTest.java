package lv.rgladisevs.word.statistics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileStringLoaderTest {

    private static final String TEST_FILE = "test.txt";

    @Test
    public void loadString() {
        FileStringLoader loader = new FileStringLoader(TEST_FILE);
        String result = loader.loadString();
        String expectedString = "Dorothy, dorothy saw a quasi-bird creature which terrified her.";
        assertEquals(expectedString, result);
    }
}