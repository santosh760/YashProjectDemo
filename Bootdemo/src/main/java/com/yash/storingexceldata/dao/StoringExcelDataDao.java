package com.yash.storingexceldata.dao;

import java.io.IOException;
import java.util.List;

import com.yash.storingexceldata.domain.UploadFile;

public interface StoringExcelDataDao {

	public String uploadExcelData(String sheetNumber, String fileId) throws IOException;

	public void uploadExcelFile(UploadFile file);

	public List<UploadFile> getFileList();

	public UploadFile getUploadFileByID(int fileIdNum);
}
