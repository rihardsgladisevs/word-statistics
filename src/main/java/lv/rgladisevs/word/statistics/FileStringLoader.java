package lv.rgladisevs.word.statistics;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class FileStringLoader {

    private String inputFilePath;

    public String loadString() {
        try {
            URL url = getClass().getClassLoader().getResource(this.inputFilePath);
            if (url == null) {
                String message = MessageFormat.format("File does not exist by path {0}", this.inputFilePath);
                throw new FileReadException(message);
            }
            URI uri = url.toURI();
            Path path = getPath(uri);
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException | URISyntaxException e) {
            String message = MessageFormat.format("Can't read file by path {0}", this.inputFilePath);
            throw new FileReadException(message, e);
        }
    }

    /**
     * Kind of hack to handle both filesystems
     * - when executing compiled jar
     * - when executing class directly
     *
     * @param uri - can be both inside of jar or outside
     * @return Path for URI
     * @throws IOException
     */
    private Path getPath(URI uri) throws IOException {
        String[] array = uri.toString().split("!");
        if (array.length == 1) {
            return Path.of(uri);
        } else {
            Map<String, String> env = new HashMap<>();
            env.put("create", "true");
            FileSystem fileSystem = FileSystems.newFileSystem(URI.create(array[0]), env);
            return fileSystem.getPath(array[1]);
        }
    }
}
