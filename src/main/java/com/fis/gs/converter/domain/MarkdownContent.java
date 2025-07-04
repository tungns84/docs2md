package com.fis.gs.converter.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the converted markdown content with structure and formatting.
 */
public class MarkdownContent {
    private final ContentId id;
    private final List<ContentSection> sections;
    private final List<TableContent> tables;
    private final List<ImageReference> imageReferences;
    private final ContentMetadata metadata;
    private String rawMarkdown;

    public MarkdownContent(ContentId id, ContentMetadata metadata) {
        this.id = Objects.requireNonNull(id);
        this.sections = new ArrayList<>();
        this.tables = new ArrayList<>();
        this.imageReferences = new ArrayList<>();
        this.metadata = Objects.requireNonNull(metadata);
    }

    public void addSection(ContentSection section) {
        this.sections.add(section);
    }

    public void addTable(TableContent table) {
        this.tables.add(table);
    }

    public void addImageReference(ImageReference imageRef) {
        this.imageReferences.add(imageRef);
    }

    public void setRawMarkdown(String rawMarkdown) {
        this.rawMarkdown = rawMarkdown;
    }

    public String generateMarkdown() {
        // TODO: Implement markdown generation logic from sections, tables, and images
        return rawMarkdown;
    }

    public boolean hasImages() {
        return !imageReferences.isEmpty();
    }

    public int getWordCount() {
        // TODO: Implement word count logic
        return rawMarkdown != null ? rawMarkdown.split("\\s+").length : 0;
    }

    // Getters (omitted for brevity)
} 