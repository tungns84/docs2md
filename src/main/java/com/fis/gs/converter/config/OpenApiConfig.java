package com.fis.gs.converter.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI (Swagger) configuration for the DOCX to Markdown Converter API.
 * 
 * This configuration class sets up comprehensive API documentation
 * and provides an interactive testing interface through Swagger UI.
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("DOCX to Markdown Converter API")
                        .description("""
                                A comprehensive REST API for converting Microsoft Word documents (.docx) 
                                to Markdown format using Hexagonal Architecture (Ports & Adapters pattern).
                                
                                **Key Features:**
                                - Upload DOCX files via multipart form data
                                - Extract text, tables, and images from documents  
                                - Convert to clean Markdown format with proper formatting
                                - Preserve image positioning and references
                                - Return ZIP archive containing Markdown file + extracted images
                                - Include debug XML for conversion verification
                                
                                **Supported Operations:**
                                - Document conversion with image extraction
                                - Health monitoring and status checks
                                - Application information and capabilties
                                
                                **Technical Stack:**
                                - Spring Boot 3.5.3 for robust REST framework
                                - Apache POI for DOCX parsing and processing
                                - Java NIO for efficient file operations
                                - Clean hexagonal architecture for maintainability
                                """)
                        .version("1.0.0-SNAPSHOT")
                        .contact(new Contact()
                                .name("DOCX to Markdown Converter Development Team")
                                .email("dev@fis.gs")
                                .url("https://github.com/fis-gs/docs2md-converter"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
