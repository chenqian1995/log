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
        String pathname = "D:\\123.log"; // ����·�������·�������ԣ�д���ļ�ʱ��ʾ���·��,��ȡ����·����input.txt�ļ�
        
        //ÿ�ζ�д���Ǹ���ǰ����������ݵ�д�ļ�����
        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\output.txt"));
        //ÿ�ζ�д����׷�ӵ�д�ļ�����
        //BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\output.txt", true)));   

        //��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw;
        //���ر��ļ��ᵼ����Դ��й¶����д�ļ���ͬ��
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // ����һ�����������ļ�����ת�ɼ�����ܶ���������
        ) {
            String line;
            String vinStrint = "";
            ArrayList<String> erroString = new ArrayList<>();
            while ((line = br.readLine()) != null) { // һ�ζ���һ������
            	
            	if (line.contains("VIN")) { //�������Ƿ����vin��
            		if (!erroString.isEmpty()) {
            			out.write(vinStrint+"\r\n");
            			for (String writeString : erroString) {
            				out.write(writeString+"\r\n");
            			}
            		}
            		vinStrint = line ;
            		erroString.clear();
            	}
            	if (line.contains("��Ӧ����")) {//�������Ƿ������Ӧ����
            		erroString.add(line);
            	}
            }   
            if (!erroString.isEmpty()) {//�ж����һ��vin���Ƿ���Ҫ��ӡ
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

