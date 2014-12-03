package web.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook hssfworkbook, HttpServletRequest httpservletrequest,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment;filename="+new String("测试excel下载.xls".getBytes(),"iso8859-1"));
		HSSFSheet sheet = hssfworkbook.createSheet("new sheet");// 创建Excel工作表对象
		HSSFRow titleRow = sheet.createRow(0); // 创建Excel工作表的行
		// CellStyle cellStyle = wb.createCellStyle();// 创建单元格样式
		// row.createCell(0)
		// row.createCell((short) 0).setCellStyle(cellStyle); //
		// 创建Excel工作表指定行的单元格
		// row.createCell((short) 0).setCellValue(1); // 设置Excel工作表的值
		List<String> titles = (List<String>) map.get("title");
		int length=titles.size();
		for(int i=0;i<length;i++){
			titleRow.createCell(i).setCellValue(titles.get(i));
		}
		List<List<String>> datas=(List<List<String>>)map.get("data");
		int dataLength=datas.size();
		for(int i=1;i<=dataLength;i++){
			HSSFRow row = sheet.createRow(i);
			List<String> list=(List<String>)datas.get(i-1);
			for(int j=0;j<length;j++){
				row.createCell(j).setCellValue(list.get(j));
			}
		}
	}

}
