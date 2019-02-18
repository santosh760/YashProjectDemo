package com.yash.storingexceldata.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yash.storingexceldata.domain.UploadFile;

public interface StoringExcelDataService {

	public void uploadExcelFile(MultipartFile file) throws IllegalStateException, IOException;

	public String uploadExcelSheetData(String sheetNumber,String fileId) throws IOException;

	public String[][] viewExcelSheetData(String sheetNumber, String fileId) throws FileNotFoundException, IOException;

	public List<UploadFile> getFileList();
}
