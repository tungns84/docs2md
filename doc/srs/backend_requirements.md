# 🔧 Backend Requirements – DOCX to Markdown Converter (Hexagonal Architecture)

## ✅ Functional Features
- Accept `.docx` upload via REST API `/api/convert`
- Parse `.docx`:
  - Extract headings, paragraphs, tables, images
  - Locate and mark position images on .docx to link with .md while convert. make sure target .md files have image at same section like on .docx source file.
- Convert to `.md` with embedded image links
- Return `.md` as downloadable response

---

## 🧱 Architecture: Hexagonal (Ports & Adapters)

### 📦 Layers
- root package: com.fis.gs.converter
```
/
├── domain/                 # Core business logic (Markdown conversion interfaces)
├── application/            # Use cases (DocxToMarkdownService)
├── adapters/
│   ├── in/                 # Controllers (REST endpoints)
│   └── out/                # File system, image storage, markdown writer
├── config/                 # Spring Boot config, Swagger setup
```

### ✅ Benefits
- Clean separation of concerns
- Testable domain logic without Spring dependencies
- Easy to swap adapter (e.g., local vs. cloud file storage)

---

## 📑 API Specification

**Endpoint**: `POST /api/convert`

### Request
- `multipart/form-data`
  - Parameter: `file` (.docx)

### Response
- `200 OK`: Returns Markdown file (`text/markdown`)
- `400 Bad Request`: Unsupported file or error
- `500 Internal Server Error`: Conversion failure

---

## 📄 OpenAPI & Swagger

### ✅ Setup
- Use `springdoc-openapi-starter-webmvc-ui`
- Auto-generate OpenAPI 3 docs from controller annotations

### 🔍 Swagger UI
- Available at `/swagger-ui.html`
- Interactive testing of `/api/convert` endpoint

---

## 🧰 Tech Stack
- **Spring Boot 3.5.3**
- **Apache POI** – for `.docx` parsing
- **Java NIO** – file operations
- **springdoc-openapi** – Swagger UI + OpenAPI

---

## 📂 Output
- Markdown: `output.md`
- Images: `image1.png`, `image2.jpg`, etc.
- (Optional) `.zip` archive with all content

---

## 🧠 Optional Enhancements
- `.doc` file support via HWPF
- AI layout improvement (OpenAI)
- Upload-to-cloud (S3, etc.)
- Error tracking/logging (e.g. Sentry)

---

## 📄 Sample Output

```markdown
# Title

This is a paragraph.

| Name | Age |
|------|-----|
| John | 30  |

![Image](image1.png)
```


---

## 🔄 Conversion Workflow (With Images & Zip Output)

### 🧭 Description
When a user uploads a `.docx` file (which may contain text, tables, and images):

1. The file is uploaded via REST endpoint (`/api/convert`)
2. Backend parses `.docx` using Apache POI
3. Extracted content:
   - Text → Converted to `.md`
   - Images → Saved as separate files
   - Underlying `.xml` (for trace/debug) is also extracted
4. Markdown links to images using relative references
5. All output files (`.md`, images, XML) are zipped
6. Response returns `.zip` file

---

### 🖇️ Sequence Diagram (Text-based)

```text
User
 |
 | 1. Upload .docx
 |----------------------> [Controller]
 |                       (RestAdapter.in)
 |
 | 2. Validate file
 |----------------------> [UseCase] DocxToMarkdownService
 |                        (Application Layer)
 |
 | 3. Extract content
 |<---------------------- [DocxParser] (Domain)
 |     - text, tables, images
 |
 | 4. Write files
 |----------------------> [FileSystemWriter] (Adapter.out)
 |     - markdown.md
 |     - images/
 |     - raw document.xml
 |
 | 5. Create .zip
 |<---------------------- [ZipService]
 |
 | 6. Return ZIP response
 |<---------------------- [Controller]
```

---

## 📦 Final ZIP Output Structure

```
converted.zip
├── document.md            # Markdown result
├── word/document.xml      # Parsed XML for reference/debug
├── images/
│   ├── image1.png
│   └── image2.jpg
```

In the Markdown file:

```markdown
![Embedded Image](images/image1.png)
```

---

