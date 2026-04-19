package com.document.upload.download.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Document_Storage")
public class DocumentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String fileType;
    private String filePath;
    private long fileSize;
    private LocalDateTime uploadedAt;

    public DocumentDetail() {}

    public DocumentDetail(String fileName, String fileType, String filePath, long fileSize, LocalDateTime uploadedAt) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.uploadedAt = uploadedAt;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public LocalDateTime getUploadedAt() {
		return uploadedAt;
	}

	public void setUploadedAt(LocalDateTime uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

	public DocumentDetail(Long id, String fileName, String fileType, String filePath, long fileSize,
			LocalDateTime uploadedAt) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.uploadedAt = uploadedAt;
	}

    
}
