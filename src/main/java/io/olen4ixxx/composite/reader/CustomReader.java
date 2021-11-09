package io.olen4ixxx.composite.reader;

import io.olen4ixxx.composite.exception.CustomCompositeException;

import java.util.List;

public interface CustomReader {
    String readLines(String stringPath) throws CustomCompositeException;
}
