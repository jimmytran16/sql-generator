import java.io.*;
import java.util.*;

class StudentQueryGenerator{
	
	public static void main(String args[]){
		try{
		File file = new File("insertquery.txt");
		FileWriter writer = new FileWriter(file);
		Scanner input = new Scanner(new File("student_process.txt"));
		while(input.hasNextLine()){
			String record = input.nextLine();
			System.out.println(record);
			String[] splitter = record.split(" ");
			String name = splitter[1]+" "+splitter[2];
			writer.write("INSERT into student(fullname,teacher,english,math,science,history,id_number) values('"+name+"','"+getTeacher()+"','"+getRandom()+"','"+getRandom()+"','"+getRandom()+"','"+getRandom()+"','"+splitter[0]+"');\n");			
		}
		writer.flush();
		writer.close();
		input.close();
		}catch(Exception e){}
	}
	public static String getRandom(){
		Random r = new Random();
		int low = 50;
		int high = 100;
		int result = r.nextInt(high-low) + low;
		int result2 = r.nextInt(high-low) + low; 
		String x = String.valueOf(result);
		String y = String.valueOf(result2);
		String randommmm = x+"."+y;
		
		return randommmm;
	}
	public static String getTeacher(){
		String teachers[] = {"Mr.Handson","Mrs.Thompson","Ms.Walsh","Mr.Brown","Mr.Wilson"};
		Random r = new Random();
		int low = 0;
		int high = 4;
		int result = r.nextInt(high-low) + low;
		return teachers[result];

	}
}