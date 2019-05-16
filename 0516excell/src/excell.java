import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.NEW;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class excell {
	private static String txtFilePath="D:\\output.txt";
	private static String excelFilePath=new StringBuffer().append("D://").append("数据").append(new SimpleDateFormat("YYYYMMDD").format(new Date())).append(".xls").toString();
	private static String encoding="GBK";
	
	public static void main(String[] args) {
		readAndWrite(txtFilePath);
		
	}

	private static void readAndWrite(String FilePath) {
		// TODO Auto-generated method stub
		try {
			File file=new  File(FilePath);
			File tempFile=new File(excelFilePath);
			if (file.isFile()&&file.exists()) {
				InputStreamReader read=new  InputStreamReader(new FileInputStream(file),encoding);
				BufferedReader bufferedReader=new BufferedReader(read);
				WritableWorkbook workbook=Workbook.createWorkbook(tempFile);
				WritableSheet sheet=workbook.createSheet("sheet1", 0);
				
				Label labelVIN=null;
				Label labelPARAM=null;
				String lineTxt=null;
				WritableFont headerFont=new WritableFont(WritableFont.createFont("宋体"),11,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);
				WritableCellFormat headerFormat=new  WritableCellFormat(headerFont);
				
				int row=0;
				int colum=0;
				while ((lineTxt=bufferedReader.readLine())!=null) {
					//label的四个参数 。第一个是代表列数,   
		            //第二是代表行数，   
		            //第三个代表要写入的内容   
		            //第四个是可选项，是输入这个label里面的样式   
		            //然后通过写sheet的方法addCell（）把内容写进sheet里面
					labelVIN=new  Label(0,0,"VIN",headerFormat);
					sheet.addCell(labelVIN);					
					labelPARAM=new Label(1,1,"响应参数",headerFormat);
					sheet.addCell(labelPARAM);
					
					labelVIN=new  Label(colum,row,lineTxt,headerFormat);
					sheet.addCell(labelVIN);
					labelPARAM=new Label(colum+1,row,lineTxt,headerFormat);
					sheet.addCell(labelPARAM);
					
					if ("".equals(lineTxt)) {
						row++;
					
						continue;
					}
				}
				sheet.setColumnView(0, 20);
				sheet.setColumnView(1, 35);
				sheet.setColumnView(2, 15);
				
				workbook.write();
				workbook.close();
				read.close();				
			}
			else {
				System.out.println("找不到文件！");
			}
		}
		catch (Exception e) {
			System.out.println("读取文件内容失败！");
			e.printStackTrace();
		}
	}
	
}
