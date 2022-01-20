import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataProvider {
    @DataProvider(name = "excel-data")
    public Object[][] excelDataProvider() throws IOException {
        return getExcelData("data.xlsx", "DataSet");
    }

    public Integer[][] getExcelData(String fileName, String sheetName) {
        Integer[][] data = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workBook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfColumns = row.getLastCellNum();
            Cell cell;
            data = new Integer[noOfRows - 1][noOfColumns];
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfColumns; j++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    data[i - 1][j] = (int) cell.getNumericCellValue();
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }
        return data;
    }
}
