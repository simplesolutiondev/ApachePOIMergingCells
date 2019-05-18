package simplesolution.dev;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ApachePOIMergeCellsExample {

    public static void main(String... args) {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("merge-cells-example");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("SimpleSolution.dev");

        sheet.addMergedRegion(new CellRangeAddress(
                0, //first row index in zero-based
                4, //last row index in zero-based
                0, //first column index in zero-based
                3  //last column index in zero-based
        ));

        try (OutputStream fileOut = new FileOutputStream("merge-cells.xls")) {
            workbook.write(fileOut);
            workbook.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
