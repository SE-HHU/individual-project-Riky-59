package appear;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		long startTime = System.currentTimeMillis(); 
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
	//生成算式
	String[] op = new String[] {"+","-"};
	int[] answer = new int[num];
	int sum=0;
	Random ran = new Random();
	ArrayList<StringBuffer> exp = new ArrayList<StringBuffer>();
	for (int i=0;i<num;i++) {
		int n=ran.nextInt(2)+1;			//1-2个运算符
		int[] nb=new int[n+1];
		StringBuffer ex = new StringBuffer();
		
		for(int j=0;j<=n;j++) {
			
			nb[j]=ran.nextInt(100)+1;	//2-3个数字
			if(j==0) {
				sum+=nb[j];
				ex.append(String.valueOf(nb[j]));
			}
			else {
			int s = ran.nextInt(2);		//随机选择某个运算符
			
			if(op[s].equals("+")) {
				sum+=nb[j];
				if(sum>100) {
					sum-=nb[j];
					j--;
					continue;
					}
			}
			if(op[s].equals("-")) {
				sum-=nb[j];
				if(sum<0) {
					sum+=nb[j];
					j--;
					continue;
				}
			}
			ex.append(op[s]+String.valueOf(nb[j]));	
		}  }
		answer[i]=sum;
		sum=0;
		exp.add(ex);
	}
	Object[] question = exp.toArray();
	

	try {
		File w1 = new File("D:\\individual project\\Exercises.txt");
		File w2 = new File("D:\\individual project\\Answers.txt");
		w1.createNewFile();
		w2.createNewFile();
		
		if(w1.isFile()&&w1.exists()&&w2.isFile()&&w2.exists()) {
			FileWriter fw1 = new FileWriter(w1);
			FileWriter fw2 = new FileWriter(w2);
			for(int a=0;a<question.length;a++) {
				fw1.write(a+1+"."+question[a]+"=");
				fw1.write("\r\n");
				fw2.write(a+1+"."+question[a]+"="+answer[a]);
				fw2.write("\r\n");
			}
			fw1.close();
			fw2.close();
		}
	}catch(IOException e) {
		e.printStackTrace();
	}
	long endTime = System.currentTimeMillis();
	System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); 
}
}

	