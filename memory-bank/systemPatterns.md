# System Patterns - DOCX to Markdown Converter

## Architectural Pattern: Hexagonal Architecture (Ports & Adapters)

### Core Principles
- **Domain-Centric**: Business logic resides in the domain layer, independent of external concerns
- **Dependency Inversion**: Dependencies point inward toward the domain
- **Testability**: Domain logic can be tested without external infrastructure
- **Adaptability**: Easy to swap implementations of external adapters

### Layer Responsibilities

#### Domain Layer (`domain/`)
- **Entities**: Document, MarkdownContent, ImageReference
- **Value Objects**: FileFormat, ConversionOptions
- **Domain Services**: ConversionLogic, ImagePositionMapper
- **Ports (Interfaces)**: 
  - `DocxParserPort` - Input port for document parsing
  - `MarkdownWriterPort` - Output port for markdown generation
  - `FileStoragePort` - Output port for file operations

#### Application Layer (`application/`)
- **Use Cases**: `DocxToMarkdownService` - orchestrates conversion workflow
- **Application Services**: Coordinate between domain and adapters
- **Input Validation**: File format validation, size limits

#### Adapter Layer (`adapters/`)
- **Input Adapters (`in/`)**:
  - `RestController` - HTTP endpoint implementation
  - `FileUploadController` - Multipart file handling
- **Output Adapters (`out/`)**:
  - `ApachePoiDocxParser` - DOCX parsing implementation
  - `FileSystemMarkdownWriter` - File system operations
  - `LocalFileStorage` - Local file storage implementation

### Design Patterns Applied

#### Factory Pattern
- `ParserFactory` - Creates appropriate parser based on file type
- `WriterFactory` - Creates writers for different output formats

#### Strategy Pattern
- `ConversionStrategy` - Different conversion approaches for complex layouts
- `ImageHandlingStrategy` - Various image processing methods

#### Command Pattern
- `ConversionCommand` - Encapsulates conversion operations for undo/retry

### Error Handling Strategy
- **Domain Exceptions**: Custom exceptions for business rule violations
- **Adapter Exceptions**: Technical exceptions wrapped and translated
- **Global Exception Handler**: Centralized error response formatting

### Testing Strategy
- **Unit Tests**: Domain logic testing without external dependencies
- **Integration Tests**: Adapter testing with real external systems
- **Contract Tests**: Port interface compliance verification
