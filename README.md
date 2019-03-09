# Word Statistics
Collects statistics of word appearance from text file.
With rules:
- Words should be ordered by number of occurrences starting from the highest.
- Program should be case insensitive ('Martha' and 'martha' are the same word).
- Punctuation and words containing non-alphanumeric characters except hyphen should be ignored.
- Words separated by hyphen should be treated as one word.
- If two words appeared the same number of times show them in alphabetical order.
## Requirements
- Java 11
- Maven 3+
## Compile
Using maven `mvn clean install`
## Run
As a jar: java -jar target/wallpaperCalculator.jar
## IDE
Lombok Project plugin should be enabled