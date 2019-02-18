package com.yash.storingexceldata.daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.storingexceldata.dao.StoringExcelDataDao;
import com.yash.storingexceldata.domain.UploadFile;

@SuppressWarnings("deprecation")
@Repository("storingExcelDataDao")
public class StoringExcelDataDaoImpl implements StoringExcelDataDao {

	
	private static String UPLOADED_FOLDER = "E://";
	Path path;

	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public String uploadExcelData(String sheetNum, String fileId) throws IOException {

		int sheetNumber = Integer.parseInt(sheetNum) - 1;
		int fileIdNum = Integer.parseInt(fileId);

		UploadFile fileU = getUploadFileByID(fileIdNum);

		// System.out.println(fileU);

		FileOutputStream bytes = new FileOutputStream(fileU.getFile());
		path = Paths.get(UPLOADED_FOLDER + fileU.getFileName());
		Files.copy(path, bytes);
		// System.out.println(path.toString());

		File file = new File(path.toString());

		FileInputStream file1 = new FileInputStream(file);

		XSSFWorkbook workBook = new XSSFWorkbook(file1);
		XSSFSheet sheet = workBook.getSheetAt(sheetNumber);

		String tableName = fileU.getFileName().substring(0, fileU.getFileName().indexOf(".")).replaceAll(" ", "_");
		Row row = sheet.getRow(0);

		if (row != null) {
			
			createTable(tableName, sheetNumber, row);
			insertRowValuesIntoTable(sheet, tableName, sheetNumber);
			workBook.close();
			return "Data Uploaded..";
		} else {
			
			workBook.close();
			return "Excel Sheet is empty..";
		}

	}

	
	private void insertRowValuesIntoTable(XSSFSheet sheet, String tableName, int sheetNumber) {
		
		int j;
		Row row;
		Cell cell;
		
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			
			StringBuilder insertStatement = new StringBuilder("INSERT INTO " + tableName + sheetNumber + " VALUES(");
			row = sheet.getRow(i);
			
			for (j = 0; j < row.getLastCellNum(); j++) {
				
				cell = row.getCell(j);

				if (j != row.getLastCellNum() - 1) {
					
					if (cell.getCellTypeEnum().toString().equals("NUMERIC")
							|| cell.getCellTypeEnum().toString().equals("FORMULA")) {
						
						insertStatement.append("\"" + cell.getNumericCellValue() + "\",");
					} else
						
						insertStatement.append("\"" + cell.getStringCellValue() + "\",");
				}

				else {
					if (cell.getCellTypeEnum().toString().equals("NUMERIC")
							|| cell.getCellTypeEnum().toString().equals("FORMULA")) {
						
						insertStatement.append("\"" + cell.getNumericCellValue() + "\");");
					} else
						
						insertStatement.append("\"" + cell.getStringCellValue().toString() + "\");");
				}

				System.out.println(insertStatement);
			}
			
			System.out.println(insertStatement);
			@SuppressWarnings({ "rawtypes" })
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(insertStatement.toString());
			query.executeUpdate();
		}

	}

	
	private void createTable(String tableName, int sheetNumber, Row row) {
		
		StringBuilder createTableStatement = new StringBuilder("Create table " + tableName + sheetNumber + "(");
		
		for (int i = 0; i < row.getLastCellNum(); i++) {
			
			if (i != row.getLastCellNum() - 1)
				createTableStatement.append(row.getCell(i).toString().replaceAll(" ", "_") + " varchar(1000),");
			else
				createTableStatement.append(row.getCell(i).toString().replaceAll(" ", "_") + " varchar(1000));");
			
			System.out.println(createTableStatement);
		}
		
		@SuppressWarnings({ "rawtypes" })
		SQLQuery createTablequery = sessionFactory.getCurrentSession().createSQLQuery(createTableStatement.toString());
		createTablequery.executeUpdate();

	}

	
	@Override
	public void uploadExcelFile(UploadFile file) {

		sessionFactory.getCurrentSession().save(file);

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<UploadFile> getFileList() {
		
		List<UploadFile> list = new ArrayList<>();
		list = sessionFactory.getCurrentSession().createCriteria(UploadFile.class).list();
		return list;
	}

	
	public UploadFile getUploadFileByID(int fileIdNum) {
		
		return sessionFactory.getCurrentSession().get(UploadFile.class, fileIdNum);
	}
}
