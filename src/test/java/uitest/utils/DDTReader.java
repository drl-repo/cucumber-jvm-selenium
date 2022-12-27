package uitest.utils;

import java.util.Iterator;
import java.util.Arrays;
import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class DDTReader{
    
	public static Object[][] JsonReader(String filePath, String[] keysOfJson)
	{
		Object[][] returnData = new Object[0][];

    	try{
			
			FileInputStream file = new FileInputStream(new File(filePath));
			
			JSONTokener jsonTokener = new JSONTokener(file);

			JSONArray jsonArray = new JSONArray(jsonTokener);

			returnData = new Object[jsonArray.length()][];
			
			for(int i=0; i < jsonArray.length(); i++){
				
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				
				returnData[i] = new Object[keysOfJson.length];
				int no = 0;
				
				for(String key : keysOfJson){
					returnData[i][no] = jsonObject.get(key);
					no++;
				}
			}
			file.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return returnData;

    }

    public static Object[][] XlsxReader(String filePath){

    	Object[][] returnData = new Object[0][];

		try {
			
			FileInputStream file = new FileInputStream(new File(filePath));

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.iterator();
			
			returnData = new Object[sheet.getPhysicalNumberOfRows()][];

			int rowI = 0;
			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();
				returnData[rowI] = new Object[row.getPhysicalNumberOfCells()];

				Iterator<Cell> cellIterator = row.cellIterator();
				int rowC = 0;
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();
					DataFormatter formatter = new DataFormatter();
					returnData[rowI][rowC] = formatter.formatCellValue(cell);
					rowC++;
				}
				rowI++;
			}
			file.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return returnData;
	}

}
