# Technical Context - DOCX to Markdown Converter

## Technology Stack

### Core Framework
- **Spring Boot 3.5.3**: Main application framework
  - Spring Web: REST API development
  - Spring Boot Starter: Auto-configuration and dependency management
  - Spring Boot DevTools: Development productivity

### Document Processing
- **Apache POI 5.x**: DOCX file parsing and manipulation
  - XWPF: Word document processing
  - HWPF: Legacy DOC support (optional enhancement)
  - Common components: Shared utilities

### File Operations
- **Java NIO 2**: Modern file I/O operations
  - Path API: Cross-platform path handling
  - Files API: High-level file operations
  - Zip FileSystem: ZIP archive creation

### API Documentation
- **springdoc-openapi-starter-webmvc-ui**: OpenAPI 3 + Swagger UI
  - Auto-generates API documentation from annotations
  - Interactive testing interface at `/swagger-ui.html`
   OpenAPI spec at `/v3/api-docs`

### Build & Dependency Management
- **Maven**: Build automation and dependency management
- **Java 17+**: Target JVM version for Spring Boot 3.x compatibility

## Development Environment

### IDE Configuration
- **IntelliJ IDEA** or **Eclipse** with Spring Tools
- **Maven Integration**: For dependency management
- **Spring Boot Plugin**: For application running and debugging

### Local Development
- **Port Configuration**: Default 8080 (configurable via `application.yml`)
- **Profile Management**: Development, testing, production profiles
- **Hot Reload**: Spring Boot DevTools for rapid development

## Key Dependencies (Maven)

```xml
<dependencies>
    <!-- Spring Boot Starters -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>3.5.3</version>
    </dependency>
    
    <!-- Apache POI for DOCX processing -->
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi-ooxml</artifactId>
        <version>5.2.4</version>
    </dependency>
    
    <!-- OpenAPI Documentation -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.2.0</version>
    </dependency>
    
    <!-- Testing -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Configuration Management

### Application Properties
- **Server Configuration**: Port, context path
- **File Upload Limits**: Max file size, request size
- **Swagger Configuration**: API documentation settings
- **Logging Configuration**: Log levels and patterns

### Environment Profiles
- **development**: Local development settings
- **test**: Testing environment configuration
- **production**: Production-ready settings with optimizations

## Performance Considerations
- **Memory Management**: Efficient handling of large DOCX files
- **Temporary File Cleanup**: Automatic cleanup of conversion artifacts
- **Request Timeouts**: Appropriate timeouts for large file processing
- **Concurrent Processing**: Thread-safe conversion operations
