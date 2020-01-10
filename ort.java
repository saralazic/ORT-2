package ort;
import java.io.*;


public class ort {
	
	
	public static int ishex(int x) {
		if(Character.isDigit(x) || (Character.isUpperCase(x) && x<='F'))
			return 1;
		return 0;
	}
	
	public static int incDig(int x) {
		if (Character.isDigit(x))
		{	
			if (x<'9') x++;
			else x='A';
		}else
			if (Character.isUpperCase(x))
				if(x<'F') { x++;}
				else  x='0';  
		return x;
	}
	
	
	public static void main(String args[]) throws IOException{
		FileInputStream in=null;
		FileOutputStream out=null;
		
		try {
			in=new FileInputStream("input.txt");
			out=new FileOutputStream("output.txt");
		
			int a, a1='0', b1='F', c1='F';
			while(true) {
				if ((a=in.read())==-1) break;
				if(ort.ishex(a)==1){
						int b=in.read();
						int c=in.read();
					
						c1=ort.incDig(c1);
						if(c1=='0') {
							b1=ort.incDig(b1);
							if (b1=='0') a1=ort.incDig(a1);
					
						}
					out.write(a1);
					out.write(b1);
					out.write(c1);
				}
				else out.write(a);
				while((a=in.read())!='\n') out.write(a);
				out.write('\n');
			}
		
		}finally {
			if(in!=null) {
				in.close();
			}
			if (out!=null) {
				out.close();
			}
		}
		
		
	}
}
