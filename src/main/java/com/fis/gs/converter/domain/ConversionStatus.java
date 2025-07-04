package com.fis.gs.converter.domain;

/**
 * Enum representing the status of document conversion.
 */
public enum ConversionStatus {
    UPLOADED,        // File uploaded, ready for processing
    PROCESSING,      // Conversion in progress
    CONVERTED,       // Successfully converted
    FAILED,          // Conversion failed
    CANCELLED        // Conversion cancelled
} 