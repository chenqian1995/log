package logTiqu;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class logtiqu {  
	public static void main(String args[]) throws Exception{  
        String pathname = "D:\\123.log"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        
        //每次读写都是覆盖前面的所有数据的写文件定义
        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\output.txt"));
        //每次读写都是追加的写文件定义
        //BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\output.txt", true)));   

        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            String vinStrint = "";
            ArrayList<String> erroString = new ArrayList<>();
            while ((line = br.readLine()) != null) { // 一次读入一行数据
            	
            	if (line.contains("VIN")) { //检测该行是否包含vin码
            		if (!erroString.isEmpty()) {
            			out.write(vinStrint+"\r\n");
            			for (String writeString : erroString) {
            				out.write(writeString+"\r\n");
            			}
            		}
            		vinStrint = line ;
            		erroString.clear();
            	}
            	if (line.contains("响应参数")) {//检测该行是否包含响应参数
            		erroString.add(line);
            	}
            }   
            if (!erroString.isEmpty()) {//判断最后一个vin码是否需要打印
    			out.write(vinStrint+"\r\n");
    			for (String writeString : erroString) {
    				out.write(writeString+"\r\n");
    			}
    		}  
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }	
    }
}

