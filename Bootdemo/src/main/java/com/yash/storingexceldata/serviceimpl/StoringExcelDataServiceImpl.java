package com.yash.storingexceldata.serviceimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.yash.storingexceldata.dao.StoringExcelDataDao;
import com.yash.storingexceldata.domain.UploadFile;
import com.yash.storingexceldata.service.StoringExcelDataService;

@Service("storingExcelDataService")
@Transactional
@EnableTransactionManagement
public class StoringExcelDataServiceImpl implements StoringExcelDataService {

	
	private static String UPLOADED_FOLDER = "E://";
	Path path;

	
	@Autowired
	StoringExcelDataDao storingExcelDataDao;

	
	@Override
	public void uploadExcelFile(MultipartFile file) throws IllegalStateException, IOException {
		
		String fileName = file.getOriginalFilename();
		File convFile = new File(file.getOriginalFilename());
		file.transferTo(convFile);
		UploadFile uploadFile = new UploadFile(fileName, convFile);
		storingExcelDataDao.uploadExcelFile(uploadFile);
	}

	
	@Override
	public String uploadExcelSheetData(String sheetNumber, String fileId) throws IOException {
		
		return storingExcelDataDao.uploadExcelData(sheetNumber, fileId);
	}

	
	@Override
	public String[][] viewExcelSheetData(String sheetNum, String fileId) throws IOException {

		String[][] excelData;

		int sheetNumber = Integer.parseInt(sheetNum) - 1;
		int fileIdNum = Integer.parseInt(fileId);

		UploadFile fileU = storingExcelDataDao.getUploadFileByID(fileIdNum);

		// System.out.println(fileU);

		FileOutputStream bytes = new FileOutputStream(fileU.getFile());
		path = Paths.get(UPLOADED_FOLDER + fileU.getFileName());
		Files.copy(path, bytes);
		// System.out.println(path.toString());

		File file = new File(path.toString());

		FileInputStream file1 = new FileInputStream(file);

		XSSFWorkbook workBook = new XSSFWorkbook(file1);
		XSSFSheet sheet = workBook.getSheetAt(sheetNumber);
		int numRows = sheet.getLastRowNum() + 1;
		int numCols = sheet.getRow(0).getLastCellNum();

		String value;
		excelData = new String[numRows][numCols];

		System.out.println("Populating Array");
		for (int i = 0; i < numRows; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < numCols; j++) {
				Cell cell = row.getCell(j);
				if (cell.getCellTypeEnum().toString().equals("NUMERIC")
						|| cell.getCellTypeEnum().toString().equals("FORMULA")) {
					value = String.valueOf(cell.getNumericCellValue());
				} else
					value = cell.getStringCellValue().toString();

				excelData[i][j] = value;
			}
		}
		System.out.println("Array population complete");

		for (String[] row : excelData) {
			System.out.println(Arrays.toString(row));
		}
		workBook.close();
		return excelData;
	}

	
	@Override
	public List<UploadFile> getFileList() {

		return storingExcelDataDao.getFileList();
	}

}
