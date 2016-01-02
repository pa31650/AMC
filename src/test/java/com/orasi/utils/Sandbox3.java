package com.orasi.utils;


/**
 * Created by Adam on 12/22/2015.
 */
public class Sandbox3 {

    public static void main(String[] args) {
        Excel MyExcel = new Excel("C:\\Temp\\MyExcel4.xlsx", "SHEETNAMEHERE");
       // String res = MyExcel.GetCellString(0, 0);


        System.out.println("Should be ID: " + MyExcel.GetCellString(1,1));
        System.out.println("Should be 76587658765: " + MyExcel.GetCellString(2,4));
        System.out.println("Should be 2: " + String.valueOf(MyExcel.FindRow("A1:D6", "doe")));
        System.out.println("Should be 4: " + String.valueOf(MyExcel.FindColumn("A1:D6", "98765647654")));
        System.out.println("Should be 2: " + String.valueOf(MyExcel.Find("A1:D6", "doe", Excel.ReturnType.ROW)));
        System.out.println("Should be 3: " + String.valueOf(MyExcel.Find("A1:D6", "doe", Excel.ReturnType.COLUMN)));

        MyExcel.SetCellString(4,3, "TestSet");
        System.out.println("Should be TestSet: " + MyExcel.GetCellString(4,3));


        MyExcel.SetCellString(4,3, "TestRevert");
        System.out.println("Should be TestRevert: " + MyExcel.GetCellString(4,3));


        MyExcel.SaveWorkbook();
        int i = 0;
    }
}