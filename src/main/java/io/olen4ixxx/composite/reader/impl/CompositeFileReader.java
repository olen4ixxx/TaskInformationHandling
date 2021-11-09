package io.olen4ixxx.composite.reader.impl;

import io.olen4ixxx.composite.exception.CustomCompositeException;
import io.olen4ixxx.composite.reader.CustomReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompositeFileReader implements CustomReader {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String readLines(String stringPath) throws CustomCompositeException {
        logger.info("CompositeFileReader: readLines({})", stringPath);
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(stringPath);
        if (resource == null) {
            logger.error("File is not found ({})", stringPath);
            throw new CustomCompositeException("File is not found");
        }
        URI uri;
        try {
            uri = resource.toURI();
        } catch (URISyntaxException e) {
            logger.error("Wrong file path ({})", stringPath);
            throw new CustomCompositeException("Wrong file path", e);
        }
        Path path = Path.of(uri);
        String textFromFile;
        try (Stream<String> lines = Files.lines(path)) {
            textFromFile = lines.collect(Collectors.joining());
        } catch (IOException e) {
            logger.error("Check the file ({})", stringPath);
            throw new CustomCompositeException("Check the file", e);
        }
        logger.info("File is read");
        return textFromFile;
    }
}
