package ru.chernyshev.recognizer.service.recognize;

import ru.chernyshev.recognizer.model.RecognizerType;

import java.io.File;
import java.io.IOException;

public interface Recognizer {
    String recognize(File voiceFile) throws IOException;

    RecognizerType getType();
}
