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
         
            /* ����TXT�ļ� */  
            String pathname = "D:\\123.log"; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��  
            File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // ����һ������������reader  
            @SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
            String line; 
            String [] lineRead=null;
            int i=0;//����һ��������
            line = br.readLine();//��ÿһ��  
            @SuppressWarnings("resource")
			FileWriter fw = new FileWriter("D:/Test112345.txt");          
            while (line != "") {  
            	//i++;
            	line = br.readLine(); // һ�ζ���һ������  
            //	lineRead[i]=line;//ÿ�ζ���ÿһ�����ݷŵ�һ��������
            	if(line.indexOf("VIN")!=-1) {
            		 System.out.println(line);
            		  String s1 = line+"\n";
              	    fw.write(s1,0,s1.length()); 
            	}else if(line.indexOf("��Ӧ����")!=-1) {//���Ҫ�������ַ���ֵû�г��֣���indexOf�������� -1
		                	//int upfind=i;
		                	//for(upfind;upfind!=0;upfind++){ //�����������VIN��
		                		
		                		//if(lineRead[upfind].indexOf("VIN")!=-1) {
		                			// System.out.println(lineRead[upfind]);
		                    //	}
		                		
		                		 System.out.println(line);//��ӡ��ǰ����Ӧ����
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

    

	
