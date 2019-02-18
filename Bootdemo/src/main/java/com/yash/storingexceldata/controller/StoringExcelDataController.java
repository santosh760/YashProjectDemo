package com.yash.storingexceldata.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yash.storingexceldata.domain.UploadFile;
import com.yash.storingexceldata.service.StoringExcelDataService;

@Controller
public class StoringExcelDataController {

	
	@Autowired
	StoringExcelDataService storingExcelDataService;

	
	@RequestMapping(value = "/")
	public String showHomePage(Model model) {
		
		model.addAttribute("listFile2", getFileList());
		return "home";
	}

	
	@RequestMapping(value = "/uploadExcelFile", method = RequestMethod.POST)
	public String uploadExcelFile(@RequestParam("file") MultipartFile file, Model model)
			throws IllegalStateException, IOException {

		if (file.isEmpty()) {
			
			model.addAttribute("msg", "Please select a file to upload");
			return "home";
			
		} else {
			
			storingExcelDataService.uploadExcelFile(file);
			model.addAttribute("listFile2", getFileList());
			model.addAttribute("msg", "file Uploaded");
			return "home";
		}
	}

	
	@RequestMapping(value = "/uploadExcelSheetData", method = RequestMethod.POST)
	public String uploadExcelSheetData(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		
		String fileId = request.getParameter("fileList");
		String sheetNumber = request.getParameter("sheetNum");
		
		if (sheetNumber == null) {
			
			model.addAttribute("msg2", "Please Select a Sheet Number");
		} else {
			
			String message = storingExcelDataService.uploadExcelSheetData(sheetNumber, fileId);
			model.addAttribute("listFile2", getFileList());
			model.addAttribute("msg2", message);
		}
		
		return "home";
	}

	@RequestMapping(value = "viewExcelSheetData", method = RequestMethod.GET)
	public String viewExcelSheetData(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {

		String fileId = request.getParameter("fileList");
		String sheetNumber = request.getParameter("sheetNum");
		
		if (sheetNumber == null) {
			
			model.addAttribute("msg2", "Please Select a Sheet Number");
			model.addAttribute("listFile2", getFileList());
			return "home";
		} else {
			
			String[][] excelSheetData = storingExcelDataService.viewExcelSheetData(sheetNumber, fileId);
			if (excelSheetData == null) {
				model.addAttribute("listFile2", getFileList());
				model.addAttribute("msg2", "File is Empty, No data to be displayed");
			} else
				
				model.addAttribute("excelData", excelSheetData);
				return "viewData";
		}

	}

	
	private List<UploadFile> getFileList() {
		
		List<UploadFile> listFile = storingExcelDataService.getFileList();
		return listFile;
	}

}
