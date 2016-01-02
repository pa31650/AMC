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

    public void SaveWorkbook(){
        // Write the output to a file
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(this.filePath);
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
        
    private void GetWorkBook(){
        try {
            wb = WorkbookFactory.create(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    };

    private Cell GetCell(int cellrow, int cellcol){ //accepts row and column numbers, starting at 1
        CellReference cellReference = new CellReference(cellrow,cellcol);
        Row row = sh.getRow(cellReference.getRow() - 1);
        Cell cell = row.getCell(cellReference.getCol() - 1);
        return cell;
    };

    private void SetSheet(String SheetName){
       sh = wb.getSheet(SheetName);
    };

    //Opens  a specific sheet within a workbook
    public Excel(String filePath, String sheetName){
        this.filePath = filePath;
        this.sheetName = sheetName;
        GetWorkBook();
        SetSheet(sheetName);
    }

    public String GetCellString (int cellrow, int cellcol){
        Cell tmpcl = GetCell(cellrow, cellcol);
        tmpcl.setCellType(Cell.CELL_TYPE_STRING);
        return tmpcl.getStringCellValue();
    }

    public double GetCellDouble (int cellrow, int cellcol){
        return GetCell(cellrow, cellcol).getNumericCellValue();
    }

    public void SetCellString(int cellrow, int cellcol, String SetToString){
        GetCell(cellrow, cellcol).setCellValue(SetToString);
    }

    public void SetCellDouble(int cellrow, int cellcol, double SetToDouble){
        GetCell(cellrow, cellcol).setCellValue(SetToDouble);
    }

    private Cell FindInRange(String Range, String SearchText){

        boolean foundVal = false;
        String[] parts = Range.split(":");
        CellReference startCR = new CellReference(parts[0]);
        CellReference endCR = new CellReference(parts[1]);
        int starRow = startCR.getRow() + 1;
        int startCol = startCR.getCol() + 1;
        int endRow = endCR.getRow() + 2;
        int endCol = endCR.getCol() + 2;
        int foundRow = 0;
        int foundCol = 0;

        for (int r = 1; r < endRow; r++) {
            if (foundVal) {
                break;
            }
            for (int c = 1; c < endCol; c++) {
                if (SearchText.equals(GetCellString(r, c))) {

                    foundVal = true;
                    foundRow = r;
                    foundCol = c;
                    break;
                }
            }
        }

        if (foundVal){
            return GetCell(foundRow,foundCol);
        }
        return null;
    }

    public int FindRow(String Range, String SearchText){
        Cell cl = FindInRange(Range, SearchText);
        return cl.getRowIndex() + 1;
    }

    public int FindColumn(String Range, String SearchText){
        Cell cl = FindInRange(Range, SearchText);
        return cl.getColumnIndex() + 1;
    }

    public int Find (String Range, String SearchText, ReturnType returnType){

        int foundOn = 0;

        switch (returnType) {
            case ROW:
                foundOn = FindRow(Range,SearchText);
                break;

            case COLUMN:
                foundOn = FindColumn(Range,SearchText);
                break;
        }
        return foundOn;
    }

    public enum ReturnType {
        ROW, COLUMN
    }


    //ToDo Create method to: Return range of values
    //ToDo Create method to: Find first empty row
    //ToDo Create method to: Find first empty column
    //ToDo Create method to: Get column by name
    //ToDo Create method to: Compare Columns
    //ToDo Create method to: Compare Row
    //ToDo Create method to: Compare Sheet
    //ToDo Create method to: Get Sheet Names
    //ToDo Create method to: Color Row
    //ToDo Create method to: Color Column
    //ToDo Create method to: Color Cell

}


