package edu.hcmut.software_testing.project3.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;
import org.apache.commons.exec.util.StringUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

  private XSSFWorkbook workBook;
  private XSSFSheet sheet;
  private static final  DataFormatter formatter = new DataFormatter();

  public ReadExcelFile(InputStream inputStream) {
    try {
      workBook = new XSSFWorkbook(inputStream);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public ReadExcelFile(String excelfilePath) {
    try {
      File s = new File(excelfilePath);
      FileInputStream stream = new FileInputStream(s);
      workBook = new XSSFWorkbook(stream);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public String getData(int sheetNumber, int row, int column) {
    sheet = workBook.getSheetAt(sheetNumber);
    String data = formatter.formatCellValue(sheet.getRow(row).getCell(column));
    if(Objects.isNull(data)) {
      return "";
    }
    return data;
  }

  public int getRowCount(int sheetIndex) {
    int row = workBook.getSheetAt(sheetIndex).getLastRowNum();
    row = row + 1;
    return row;
  }

}