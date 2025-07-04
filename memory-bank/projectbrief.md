# DOCX to Markdown Converter - Project Brief

## Project Overview
A Spring Boot 3.5.3 REST API service that converts DOCX files to Markdown format using Hexagonal Architecture (Ports & Adapters pattern).

## Core Objectives
- Accept DOCX file uploads via REST API endpoint `/api/convert`
- Parse DOCX files to extract text, images, tables, and formatting
- Convert content to Markdown with proper image linking
- Return converted content as downloadable ZIP archive
- Maintain clean architecture with separation of concerns

## Key Technical Requirements
- **Architecture**: Hexagonal (Ports & Adapters)
- **Framework**: Spring Boot 3.5.3
- **DOCX Parsing**: Apache POI
- **Documentation**: OpenAPI 3 + Swagger UI
- **File Operations**: Java NIO
- **Output Format**: ZIP containing .md file + images + debug XML

## Success Criteria
- ✅ Functional REST API endpoint
- ✅ Clean hexagonal architecture implementation
- ✅ Proper image positioning preservation from DOCX to MD
- ✅ Interactive Swagger UI for testing
- ✅ ZIP output with organized file structure

## Package Structure
```
com.fis.gs.converter/
├── domain/                 # Core business logic
├── application/            # Use cases (DocxToMarkdownService)
├── adapters/
│   ├── in/                 # Controllers (REST endpoints)
│   └── out/                # File system, image storage, markdown writer
├── config/                 # Spring Boot config, Swagger setup
```

This project represents a Level 3 (Intermediate Feature) complexity level due to the architectural requirements and multi-format file handling.
