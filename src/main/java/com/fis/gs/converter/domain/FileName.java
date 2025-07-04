package com.fis.gs.converter.domain;

import java.util.Objects;

/**
 * Value object for file names with sanitization.
 */
public class FileName {
    private final String name;

    public FileName(String name) {
        this.name = sanitizeFileName(Objects.requireNonNull(name));
    }

    private String sanitizeFileName(String name) {
        // Remove dangerous characters, limit length, etc.
        return name.replaceAll("[^a-zA-Z0-9._-]", "_");
    }

    public String getName() {
        return name;
    }
} 