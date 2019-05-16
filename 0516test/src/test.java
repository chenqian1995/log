 import java.io.File;  
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;  
/*1.读文件第一行
 * 2.当line不为空的做循环
 * 		1.line读第二行
 * 		2.
  */
public class test {  
    @SuppressWarnings("null")
	public static void main(String args[]) throws Exception{  
         
            /* 读入TXT文件 */  
            String pathname = "D:\\123.log"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径  
            File filename = new File(pathname); // 要读取以上路径的input。txt文件  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader  
            @SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            String line; 
            String temp=null;//设置临时字符串，存vin
            line = br.readLine();//读每一行  
            @SuppressWarnings("resource")
			FileWriter fw = new FileWriter("D:/Test1123456.txt");            
            while (line != "") { 
            	line = br.readLine(); // 一次读入一行数据             
            	if(line.indexOf("VIN")!=-1) {
            		temp=line;
            	
            		do{      			
            			line = br.readLine();
            			if(line.indexOf("响应参数")!=-1) {//如果要检索的字符串值没有出现，则indexOf方法返回 -1		                		
	                		
            				String s = temp+"\n";
                			System.out.println(temp+"我写到文件里");//打印VIN到控制台
                       	    fw.write(s,0,s.length());//把之前行扫描到的VIN码写到文件里8
                       	    
            				
            				System.out.println(line+"我写到文件里");//打印当前的响应参数
	                		String s2 = line+"\n";
	                  	    fw.write(s2,0,s2.length());
	                  	    
            			}else {
            				continue;
            			}
            			
            		}while(line.indexOf("VIN")==-1);
            	
            	}
            	else if(line.indexOf("响应参数")!=-1) {//如果要检索的字符串值没有出现，则indexOf方法返回 -1	
            				continue;
		                	}else {
		                		continue;
		                	}                	                      	   
               	   	  
                	   System.out.println(line+"我不在文件里");
                }                      	 
                }	
        }

    

	
