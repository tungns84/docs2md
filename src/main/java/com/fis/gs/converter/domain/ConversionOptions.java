package com.fis.gs.converter.domain;

import java.util.Objects;

/**
 * Value object for conversion configuration options.
 */
public class ConversionOptions {
    private final ImageHandlingStrategy imageStrategy;
    private final OutputFormat outputFormat;
    private final QualitySettings qualitySettings;
    private final boolean includeDebugXml;

    public ConversionOptions(ImageHandlingStrategy imageStrategy, 
                           OutputFormat outputFormat,
                           QualitySettings qualitySettings,
                           boolean includeDebugXml) {
        this.imageStrategy = Objects.requireNonNull(imageStrategy);
        this.outputFormat = Objects.requireNonNull(outputFormat);
        this.qualitySettings = Objects.requireNonNull(qualitySettings);
        this.includeDebugXml = includeDebugXml;
    }

    // Getters
    public ImageHandlingStrategy getImageStrategy() { return imageStrategy; }
    public OutputFormat getOutputFormat() { return outputFormat; }
    public QualitySettings getQualitySettings() { return qualitySettings; }
    public boolean isIncludeDebugXml() { return includeDebugXml; }
} 