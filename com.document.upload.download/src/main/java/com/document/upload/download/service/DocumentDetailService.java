package com.document.upload.download.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.document.upload.download.entity.DocumentDetail;
import com.document.upload.download.repository.DocumentDetailRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DocumentDetailService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final DocumentDetailRepository repository;

    public DocumentDetailService(DocumentDetailRepository repository) {
        this.repository = repository;
    }

    public DocumentDetail uploadDocument(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        // Ensure folder exists
        Files.createDirectories(Paths.get(uploadDir));

        // Create unique file name
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir + File.separator + fileName);

        // Save file to disk
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Save metadata in DB
        DocumentDetail doc = new DocumentDetail(
                file.getOriginalFilename(),
                file.getContentType(),
                filePath.toString(),
                file.getSize(),
                LocalDateTime.now()
        );

        return repository.save(doc);
    }

    public Page<DocumentDetail> getAllDocuments(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<DocumentDetail> getDocument(Long id) {
        return repository.findById(id);
    }
}

