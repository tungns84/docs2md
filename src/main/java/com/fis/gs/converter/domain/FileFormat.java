package com.fis.gs.converter.domain;

/**
 * Enum for supported file formats.
 */
public enum FileFormat {
    DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
    DOC("application/msword"),
    MD("text/markdown"),
    ZIP("application/zip");

    private final String mimeType;

    FileFormat(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return mimeType;
    }
} 