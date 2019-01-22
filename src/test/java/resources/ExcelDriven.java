package resources;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDriven {
    public static FileInputStream fin;
    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static void main(String args[]) throws IOException {
        String value = getCelldata(0,0);
        System.out.println(value);
        String val2 = getCelldata(0,1);
        System.out.println(val2);
    }

    public static String getCelldata(int rownum, int col) throws IOException {
        fin = new FileInputStream("D:\\xsite\\data.xlsx");
        wb = new XSSFWorkbook(fin);
        sheet = wb.getSheet("Sheet1");
        row = sheet.getRow(rownum);
        cell = row.getCell(col);
        return cell.getStringCellValue();
    }
}
