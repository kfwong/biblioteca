package com.twu.biblioteca;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTest {
    String readTestResourceAsString(String filename) throws Exception {
        URI file = getClass().getClassLoader().getResource(filename).toURI();

        return new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
    }
}
