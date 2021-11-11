package io.olen4ixxx.composite.reader;

import io.olen4ixxx.composite.exception.CustomCompositeException;

public interface CustomReader {
    String readLines(String stringPath) throws CustomCompositeException;
}
