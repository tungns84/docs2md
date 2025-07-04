package com.fis.gs.converter.domain;

/**
 * Enum for different image handling strategies during conversion.
 */
public enum ImageHandlingStrategy {
    EXTRACT_AND_LINK,    // Extract images and create markdown links
    EMBED_BASE64,        // Embed images as base64 in markdown
    SKIP_IMAGES,         // Skip images entirely
    EXTERNAL_STORAGE     // Store images externally and link
} 