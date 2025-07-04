package com.fis.gs.converter.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Aggregate root representing an uploaded DOCX document and its conversion lifecycle.
 */
public class Document {
    private final DocumentId id;
    private final FileName fileName;
    private final FileSize fileSize;
    private final FileFormat format;
    private final Instant uploadTimestamp;
    private ConversionStatus status;
    private ProcessingMetadata processingInfo;
    private final List<ImageReference> embeddedImages;
    private MarkdownContent convertedContent;

    // Constructor
    public Document(DocumentId id, FileName fileName, FileSize fileSize, FileFormat format, Instant uploadTimestamp) {
        if (format != FileFormat.DOCX) {
            throw new IllegalArgumentException("Only DOCX format is supported");
        }
        this.id = Objects.requireNonNull(id);
        this.fileName = Objects.requireNonNull(fileName);
        this.fileSize = Objects.requireNonNull(fileSize);
        this.format = Objects.requireNonNull(format);
        this.uploadTimestamp = Objects.requireNonNull(uploadTimestamp);
        this.status = ConversionStatus.UPLOADED;
        this.embeddedImages = new ArrayList<>();
    }

    // Business behavior methods
    public void startConversion(ConversionOptions options) {
        if (status != ConversionStatus.UPLOADED) {
            throw new IllegalStateException("Conversion can only start from UPLOADED state");
        }
        this.status = ConversionStatus.PROCESSING;
        this.processingInfo = new ProcessingMetadata(Instant.now());
    }

    public void updateStatus(ConversionStatus newStatus) {
        this.status = newStatus;
        if (processingInfo != null) {
            processingInfo.setStatus(newStatus);
        }
    }

    public void addImageReference(ImageReference image) {
        this.embeddedImages.add(image);
    }

    public void setConvertedContent(MarkdownContent content) {
        this.convertedContent = content;
        this.status = ConversionStatus.CONVERTED;
        if (processingInfo != null) {
            processingInfo.setEndTime(Instant.now());
        }
    }

    public boolean isConversionComplete() {
        return status == ConversionStatus.CONVERTED;
    }

    public boolean hasErrors() {
        return status == ConversionStatus.FAILED;
    }

    // Getters (omitted for brevity)
} 