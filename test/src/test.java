 import java.io.File;  
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;  

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
            String [] lineRead=null;
            int i=0;//计数一共多少行
            line = br.readLine();//读每一行  
            @SuppressWarnings("resource")
			FileWriter fw = new FileWriter("D:/Test112345.txt");          
            while (line != "") {  
            	//i++;
            	line = br.readLine(); // 一次读入一行数据  
            //	lineRead[i]=line;//每次读的每一行数据放到一个数组里
            	if(line.indexOf("VIN")!=-1) {
            		 System.out.println(line);
            		  String s1 = line+"\n";
              	    fw.write(s1,0,s1.length()); 
            	}else if(line.indexOf("响应参数")!=-1) {//如果要检索的字符串值没有出现，则indexOf方法返回 -1
		                	//int upfind=i;
		                	//for(upfind;upfind!=0;upfind++){ //往上找最近的VIN码
		                		
		                		//if(lineRead[upfind].indexOf("VIN")!=-1) {
		                			// System.out.println(lineRead[upfind]);
		                    //	}
		                		
		                		 System.out.println(line);//打印当前的响应参数
		                		  String s2 = line+"\n";
		                  	    fw.write(s2,0,s2.length()); 
		                	}else {
		                	continue;
		                	}
                	
                	
                	
                	                      	   
                	    fw.flush();
                	    System.out.println(line);
                }
                       	 
                }
             
           

        	
        }

    

	
