 import java.io.File;  
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;  
/*1.���ļ���һ��
 * 2.��line��Ϊ�յ���ѭ��
 * 		1.line���ڶ���
 * 		2.
  */
public class test {  
    @SuppressWarnings("null")
	public static void main(String args[]) throws Exception{  
         
            /* ����TXT�ļ� */  
            String pathname = "D:\\123.log"; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��  
            File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // ����һ������������reader  
            @SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
            String line; 
            String temp=null;//������ʱ�ַ�������vin
            line = br.readLine();//��ÿһ��  
            @SuppressWarnings("resource")
			FileWriter fw = new FileWriter("D:/Test1123456.txt");            
            while (line != "") { 
            	line = br.readLine(); // һ�ζ���һ������             
            	if(line.indexOf("VIN")!=-1) {
            		temp=line;
            	
            		do{      			
            			line = br.readLine();
            			if(line.indexOf("��Ӧ����")!=-1) {//���Ҫ�������ַ���ֵû�г��֣���indexOf�������� -1		                		
	                		
            				String s = temp+"\n";
                			System.out.println(temp+"��д���ļ���");//��ӡVIN������̨
                       	    fw.write(s,0,s.length());//��֮ǰ��ɨ�赽��VIN��д���ļ���8
                       	    
            				
            				System.out.println(line+"��д���ļ���");//��ӡ��ǰ����Ӧ����
	                		String s2 = line+"\n";
	                  	    fw.write(s2,0,s2.length());
	                  	    
            			}else {
            				continue;
            			}
            			
            		}while(line.indexOf("VIN")==-1);
            	
            	}
            	else if(line.indexOf("��Ӧ����")!=-1) {//���Ҫ�������ַ���ֵû�г��֣���indexOf�������� -1	
            				continue;
		                	}else {
		                		continue;
		                	}                	                      	   
               	   	  
                	   System.out.println(line+"�Ҳ����ļ���");
                }                      	 
                }	
        }

    

	
