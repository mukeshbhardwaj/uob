package com.vendor.app.vendorservice.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vendor.app.vendorservice.model.Vendors;

public class ExcelUtils {

	public static ByteArrayInputStream customersToExcel(List<Vendors> vendors) throws IOException {
//		String[] COLUMNs = {"ID", "VENDORSNAME", "FOODITEMNAME1", "FOODITEMNAME2","FOODITEMNAME3","FOODITEMNAME4","FOODITEMNAME5","ADDRESS"};
		String[] COLUMNs = {"Id", "Name", "FoodItem", "Price"};
		try(
				Workbook workbook = new XSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
		){
			CreationHelper createHelper = workbook.getCreationHelper();
	 
			Sheet sheet = workbook.createSheet("Vendors");
	 
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
	 
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
	 
			// Row for Header
			Row headerRow = sheet.createRow(0);
	 
			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}
	 
			// CellStyle for Age
			
			CellStyle ageCellStyle = workbook.createCellStyle();
			ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
	 
			int rowIdx = 1;
			for (Vendors vendor : vendors) {
				Row row = sheet.createRow(rowIdx++);
	 
				row.createCell(0).setCellValue(vendor.getId());
				row.createCell(1).setCellValue(vendor.getName());
				row.createCell(2).setCellValue(vendor.getItem());
//				row.createCell(3).setCellValue(vendor.getFoodItem2());
//				row.createCell(4).setCellValue(vendor.getFoodItem3());
//				row.createCell(5).setCellValue(vendor.getFoodItem4());
//				row.createCell(6).setCellValue(vendor.getFoodItem5());
//				row.createCell(7).setCellValue(vendor.getAddress());
				
				Cell ageCell = row.createCell(3);
				ageCell.setCellValue(vendor.getPrice());
				ageCell.setCellStyle(ageCellStyle);
			}
	 
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	public static List<Vendors> parseExcelFile(InputStream is) {
		try {
    		Workbook workbook = new XSSFWorkbook(is);
     
    		Sheet sheet = workbook.getSheet("Vendors");
    		Iterator<Row> rows = sheet.iterator();
    		
    		List<Vendors> lstVendors = new ArrayList<Vendors>();
    		
    		int rowNumber = 0;
    		while (rows.hasNext()) {
    			Row currentRow = rows.next();
    			
    			// skip header
    			if(rowNumber == 0) {
    				rowNumber++;
    				continue;
    			}
    			
    			Iterator<Cell> cellsInRow = currentRow.iterator();

    			Vendors vendors = new Vendors();
    			
    			int cellIndex = 0;
    			while (cellsInRow.hasNext()) {
    				Cell currentCell = cellsInRow.next();
    				
    				if(cellIndex==0) { // ID
    					vendors.setId((long) currentCell.getNumericCellValue());
    				} else if(cellIndex==1) { // Name
    					vendors.setName(currentCell.getStringCellValue());
    				} else if(cellIndex==2) { 
    					vendors.setItem(currentCell.getStringCellValue());
    				} else if(cellIndex==3) { // Age
    					vendors.setPrice((int) currentCell.getNumericCellValue());
    				}
    				
					/*
					 * else if(cellIndex==2) { // Address
					 * vendors.setAddress(currentCell.getStringCellValue()); } else if(cellIndex==3)
					 * { vendors.setFoodItem1(currentCell.getStringCellValue()); } else
					 * if(cellIndex==4) { vendors.setFoodItem2(currentCell.getStringCellValue()); }
					 * else if(cellIndex==5) {
					 * vendors.setFoodItem3(currentCell.getStringCellValue()); } else
					 * if(cellIndex==6) { vendors.setFoodItem4(currentCell.getStringCellValue()); }
					 * else if(cellIndex==7) {
					 * vendors.setFoodItem5(currentCell.getStringCellValue()); }
					 */
    				
    				cellIndex++;
    			}
    			
    			lstVendors.add(vendors);
    		}
    		
    		// Close WorkBook
    		workbook.close();
    		
    		return lstVendors;
        } catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}
}