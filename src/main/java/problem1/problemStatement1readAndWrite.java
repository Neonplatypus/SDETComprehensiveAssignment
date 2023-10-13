package problem1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class problemStatement1readAndWrite {

    private static final String filePath = "D:\\Office Space\\Automation\\Selenium\\Eclipswspace\\ReadAndWriteExcel\\src\\resources\\student_data.xlsx";

    public static void main(String[] args) throws IOException {
        // Read data from Excel sheet
        List<Student> students = readExelData();

        // Store data in collections
        Map<String, Student> studentMap = new HashMap<>();
        for (Student student : students) {
            studentMap.put(student.getName(), student);
        }

        // Display data in console
        for (String name : studentMap.keySet()) {
            Student student = studentMap.get(name);
            System.out.println(student);
        }
    }

    private static List<Student> readExelData() throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Iterate over rows and columns to read data
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            Student student = new Student();
            student.setName(row.getCell(0).getStringCellValue());
            student.setCourses(row.getCell(1).getStringCellValue());
            student.setFee(row.getCell(2).getNumericCellValue());
            students.add(student);
        }

        file.close();
        workbook.close();
        return students;
    }
}
