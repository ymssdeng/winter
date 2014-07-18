package com.hui.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIDemo {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		POIDemo demo = new POIDemo();
		XSSFWorkbook wb = new XSSFWorkbook(demo.getClass().getResourceAsStream(
				"user_management_template.xlsx"));

		//writeDataValidation(wb);

		String value = null;
		for (Row row : wb.getSheetAt(0)) {
			for (Cell cell : row) {
				if (cell != null) {
					switch (cell.getCellType()) {

					case Cell.CELL_TYPE_FORMULA:
						value = "FORMULA value=" + cell.getCellFormula();
						break;

					case Cell.CELL_TYPE_NUMERIC:
						cell.setCellType(Cell.CELL_TYPE_STRING);
						value = "NUMERIC value=" + cell.getStringCellValue();
						break;

					case Cell.CELL_TYPE_STRING:
						value = "STRING value=" + cell.getStringCellValue();
						break;

					default:
					}
					System.out.println("CELL row=" + cell.getRowIndex()
							+ " col=" + cell.getColumnIndex() + " VALUE="
							+ value);
				}
			}
		}
	}

	private static void writeDataValidation(XSSFWorkbook wb) {
		DataValidation dataValidation = null;
		DataValidationConstraint constraint = null;
		DataValidationHelper validationHelper = null;
		
		validationHelper=new XSSFDataValidationHelper(wb.getSheetAt(0));
	    CellRangeAddressList addressList = new  CellRangeAddressList(1,65535,7,7);
	    constraint = validationHelper.createFormulaListConstraint("=Sheet2!$A$2:$A$20");//.createExplicitListConstraint("=Sheet2!$A$2:$A$20");
	    dataValidation = validationHelper.createValidation(constraint, addressList);
	    dataValidation.setSuppressDropDownArrow(true);      
	    wb.getSheetAt(0).addValidationData(dataValidation);

	    // write file to disk
	    /*FileOutputStream fileOut = new FileOutputStream("C:\\Users\\mdeng\\Desktop\\user_management_template.xlsx");
	    wb.write(fileOut);Files
	    fileOut.close();*/
	}
}
