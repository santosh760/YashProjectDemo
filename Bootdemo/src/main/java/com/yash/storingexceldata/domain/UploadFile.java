package com.yash.storingexceldata.domain;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "upload_file")
public class UploadFile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fileId;

	@Column(name = "fileName")
	private String fileName;

	@Column(name = "file")
	private File file;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public UploadFile(int fileId, String fileName, File file) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.file = file;
	}

	@Override
	public String toString() {
		return "UploadFile [fileId=" + fileId + ", fileName=" + fileName + ", file=" + file + "]";
	}

	public UploadFile(String fileName, File file) {
		super();
		this.fileName = fileName;
		this.file = file;
	}

	public UploadFile() {
		// TODO Auto-generated constructor stub
	}
}
