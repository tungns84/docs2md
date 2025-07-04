package com.fis.gs.converter.domain;

import java.util.Objects;

/**
 * Manages embedded images and their positioning in the converted content.
 */
public class ImageReference {
    private final ImageId id;
    private final FileName imageFileName;
    private final ImageFormat format;
    private final ImageSize dimensions;
    private PositionInDocument position;
    private String markdownReference;
    private final byte[] imageData;

    public ImageReference(ImageId id, FileName imageFileName, ImageFormat format, ImageSize dimensions, byte[] imageData) {
        this.id = Objects.requireNonNull(id);
        this.imageFileName = Objects.requireNonNull(imageFileName);
        this.format = Objects.requireNonNull(format);
        this.dimensions = Objects.requireNonNull(dimensions);
        this.imageData = Objects.requireNonNull(imageData);
    }

    public void setPosition(PositionInDocument position) {
        this.position = position;
    }

    public String generateMarkdownReference() {
        // Example: ![alt text](images/image1.png)
        return markdownReference != null ? markdownReference : ("![](" + imageFileName.getName() + ")");
    }

    public boolean isValidFormat() {
        return format == ImageFormat.PNG || format == ImageFormat.JPG || format == ImageFormat.GIF || format == ImageFormat.BMP;
    }

    public void validateDimensions() {
        // Example: throw if dimensions exceed allowed size
        if (!dimensions.isWithinLimit(10 * 1024 * 1024)) { // 10MB
            throw new IllegalArgumentException("Image size exceeds maximum allowed");
        }
    }

    // Getters (omitted for brevity)
} 