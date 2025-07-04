package com.fis.gs.converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class for DOCX to Markdown Converter.
 * 
 * This application implements a Hexagonal Architecture (Ports & Adapters) pattern
 * for converting Microsoft Word documents to Markdown format with image support.
 * 
 * Features:
 * - REST API for DOCX file upload and conversion
 * - Apache POI for DOCX parsing
 * - ZIP output with Markdown files and extracted images
 * - OpenAPI/Swagger documentation
 * 
 * @author DOCX to Markdown Converter Team
 * @version 1.0.0-SNAPSHOT
 */
@SpringBootApplication
public class Docs2MdConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(Docs2MdConverterApplication.class, args);
    }
}
