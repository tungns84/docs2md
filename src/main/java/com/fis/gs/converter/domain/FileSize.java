package com.fis.gs.converter.domain;

/**
 * Value object for file size with validation.
 */
public class FileSize {
    private final long sizeInBytes;

    public FileSize(long sizeInBytes) {
        if (sizeInBytes <= 0) {
            throw new IllegalArgumentException("File size must be positive");
        }
        this.sizeInBytes = sizeInBytes;
    }

    public boolean isWithinLimit(long maxSize) {
        return sizeInBytes <= maxSize;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }
} 