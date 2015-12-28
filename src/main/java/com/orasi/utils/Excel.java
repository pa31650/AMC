package com.orasi.utils;



import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.xpath.operations.String;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by Adam on 12/22/2015.
 */
public class Excel {

    //Variables
    private static String filePath;
    private static String sheetName;
    private static Workbook wb;
    private static Sheet sh;
    private static  FileOutputStream fileOut = null;

    //Opens a workbook and uses the first sheet (Usually Sheet1)
    public Excel(String filePath){
        this.filePath = filePath;
        GetWorkBook();
        //setting default sheet.
        sh = wb.getSheetAt(0);
    }

    private void GetWorkBook(){
        try {
            wb = WorkbookFactory.create(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    };

    private void SetSheet(String SheetName){};

    //Opens  a specific sheet within a workbook
    public Excel(String filePath, String sheetName){
        this.filePath = filePath;
        this.sheetName = sheetName;
        GetWorkBook();
        SetSheet(sheetName);
    }

    //Creates a workbook
    public Excel(String filePath, String sheetName, boolean CreateNewWorkbook){
        this.filePath = filePath;
        this.sheetName = sheetName;

        if (filePath.toUpperCase().indexOf(".XLSX") > 0) {
            wb = new XSSFWorkbook(); //XLSX
        }
        else {
            wb = new HSSFWorkbook(); //XLS
        }
        Sheet sheet1 = wb.createSheet(sheetName);
        fileOut = null;
        try {
            fileOut = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            wb.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String GetCellString (int cellrow, int cellcol){
        //Sheet mySheet = wb.getSheet("Sheet1");
        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
        CellReference cellReference = new CellReference(cellrow,cellcol);
        Row row = sh.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());
        return cell.getStringCellValue();
    }

    public double GetCellDouble (int cellrow, int cellcol){
        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
        CellReference cellReference = new CellReference(cellrow,cellcol);
        Row row = sh.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());
        return cell.getNumericCellValue();
    }

    //ToDo Create method to: Set cell string
    //ToDo Create method to: Set cell double
    //ToDo Create method to: Find in range
    //ToDo Create method to: Return range of values
    //ToDo Create method to: Find first empty row
    //ToDo Create method to: Find first empty column
    //ToDo Create method to: Get column by name
    //ToDo Create method to: Compare Columns
    //ToDo Create method to: Compare Row
    //ToDo Create method to: Compare Sheet
    //ToDo Create method to: Get Sheet Names
    //ToDo Create method to: Convert to Letter
    //ToDo Create method to: Convert to number
    //ToDo Create method to: Color Row
    //ToDo Create method to: Color Column
    //ToDo Create method to: Color Cell

}


