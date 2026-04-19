package com.document.upload.download.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.document.upload.download.entity.DocumentDetail;
import com.document.upload.download.service.DocumentDetailService;

@RestController
public class DocumentDetailController {

    private final DocumentDetailService service;

    public DocumentDetailController(DocumentDetailService service) {
        this.service = service;
    }

    // Upload Document
    @PostMapping("/upload")
    public ResponseEntity<DocumentDetail> uploadDocument(@RequestParam("file") MultipartFile file) throws IOException {
        DocumentDetail savedDoc = service.uploadDocument(file);
        return ResponseEntity.ok(savedDoc);
    }
    

    // Fetch Documents with Pagination & Sorting
    @GetMapping
    public ResponseEntity<Page<DocumentDetail>> getAllDocuments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "uploadedAt,desc") String[] sort
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sort[1]), sort[0]));
        return ResponseEntity.ok(service.getAllDocuments(pageable));
    }

    // Download Document
    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> downloadDocument(@PathVariable Long id) {
        return (ResponseEntity<Resource>) service.getDocument(id)
                .map(doc -> {
                    File file = new File(doc.getFilePath());
                    if (!file.exists()) {
                        return ResponseEntity.notFound().build();
                    }
                    Resource resource = new FileSystemResource(file);
                    return ResponseEntity.ok()
                            .contentType(MediaType.parseMediaType(doc.getFileType()))
                            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + doc.getFileName() + "\"")
                            .body(resource);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/test")
    public String test() {
    	return"hellow";
    }
}

