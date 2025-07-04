package com.fis.gs.converter.adapters.in;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * REST Controller for DOCX to Markdown conversion operations.
 * 
 * This controller implements the input adapter in the Hexagonal Architecture,
 * providing HTTP endpoints for document conversion functionality.
 */
@RestController
@RequestMapping("/api")
@Tag(name = "Document Conversion", description = "DOCX to Markdown conversion operations")
public class ConversionController {

    @GetMapping("/health")
    @Operation(summary = "Health check endpoint", description = "Returns application health status")
    @ApiResponse(responseCode = "200", description = "Application is healthy")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("DOCX to Markdown Converter - Service is running");
    }

    @PostMapping(value = "/convert", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
        summary = "Convert DOCX file to Markdown", 
        description = "Uploads a DOCX file and converts it to Markdown format with extracted images in a ZIP archive"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Conersion successful", 
                    content = @Content(mediaType = "application/zip")),
        @ApiResponse(responseCode = "400", description = "Invalid file format or bad request"),
        @ApiResponse(responseCode = "500", description = "Internal server error during conversion")
    })
    public ResponseEntity<String> convertDocxToMarkdown(
            @Parameter(description = "DOCX file to convert", required = true)
            @RequestParam("file") MultipartFile file) {
        
        // Validate file
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }
        
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || !originalFilename.toLowerCase().endsWith(".docx")) {
            return ResponseEntity.badRequest().body("Only DOCX files are supported");
        }
        
        // TODO: Implement conversion logic
        // This is a placeholder implementation for initial setup
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body("Conversion functionality will be implemented in the next phase. " +
                      "Received file: " + originalFilename + " (" + file.getSize() + " bytes)");
    }

    @GetMapping("/info")
    @Operation(summary = "Application information", description = "Returns application version and capabilities")
    @ApiResponse(responseCode = "200", description = "Application information retrieved")
    public ResponseEntity<ApplicationInfo> getApplicationInfo() {
        ApplicationInfo info = new ApplicationInfo(
            "DOCX to Markdown Converter",
            "1.0.0-SNAPSHOT",
            "Hexagonal Architecture REST API for converting DOCX files to Markdown format with image support",
            new String[]{"DOCX parsing", "Markdown conversion", "Image extraction", "ZIP output"}
        );
        return ResponseEntity.ok(info);
    }

    /**
     * DTO for application information response
     */
    public static class ApplicationInfo {
        private final String name;
        private final String version;
        private final String description;
        private final String[] features;

        public ApplicationInfo(String name, String version, String description, String[] features) {
            this.name = name;
            this.version = version;
            this.description = description;
            this.features = features;
        }

        public String getName() { return name; }
        public String getVersion() { return version; }
        public String getDescription() { return description; }
        public String[] getFeatures() { return features; }
    }
}
