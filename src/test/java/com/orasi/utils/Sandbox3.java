package com.orasi.utils;


/**
 * Created by Adam on 12/22/2015.
 */
public class Sandbox3 {

    public static void main(String[] args) {



        //Read and write to an existing excel sheet
        Excel MyExcel = new Excel("C:\\Temp\\MyExcel4.xlsx", "SHEETNAMEHERE"); //sheet name is optional
        System.out.println("Should be ID: " + MyExcel.GetCellString(1,1));
        System.out.println("Should be 76587658765: " + MyExcel.GetCellString(2,4));
        System.out.println("Should be 2: " + String.valueOf(MyExcel.FindRow("A1:D6", "doe")));
        System.out.println("Should be 4: " + String.valueOf(MyExcel.FindColumn("A1:D6", "98765647654")));
        System.out.println("Should be 2: " + String.valueOf(MyExcel.Find("A1:D6", "doe", Excel.ReturnType.ROW)));
        System.out.println("Should be 3: " + String.valueOf(MyExcel.Find("A1:D6", "doe", Excel.ReturnType.COLUMN)));

        MyExcel.SetCellString(4,3, "TestSet");
        System.out.println("Should be TestSet: " + MyExcel.GetCellString(4,3));

        MyExcel.SetCellString(4,3, "TestRevert2");
        System.out.println("Should be TestRevert2: " + MyExcel.GetCellString(4,3));


        System.out.println("Should be <BLANK>: " + MyExcel.GetCellString(10,10));

        MyExcel.SetCellString(13,13, "testwritetoblank");
        System.out.println("Should be testwritetoblank: " + MyExcel.GetCellString(13,13));

        MyExcel.SaveWorkbook();
        MyExcel = null;




        //Create, write, read, save
        Excel MyNewExcel = new Excel("C:\\Temp\\MyExcel17.xlsx", "SHEETNAMEHERE", true);

        MyNewExcel.SetCellString(3,2, "TestSetNew2");
        System.out.println("Should be TestSetNew2: " + MyNewExcel.GetCellString(3,2));
        MyNewExcel.SetCellString(3,2, "TestRevertNew2");
        System.out.println("Should be TestRevertNe2w: " + MyNewExcel.GetCellString(3,2));

        MyNewExcel.SaveWorkbook();
        int i = 0;

        FileSystem.DeleteFile("C:\\Temp\\MyExcel17.xlsx");
    }
}