import java.io.*;

public class MyReader{
	//method 1
	public void readFromFile(String fileName){
		FileReader fileReader = null;
		try{
			 fileReader = new FileReader(fileName);
		
		int c; //store a piece of a data from a file
		
		while((c=fileReader.read())!= -1){
			System.out.println(c);
		}

		}catch(FileNotFoundException f){

			System.err.println(f);
		}

			catch(IOException ioe){

				System.err.println(ioe);

			}finally{
				try{
					fileReader.close();
				}catch(IOException io){
					System.err.println(io);
				}
			}

		
	}

	//method 2
	public void writeFromFile(String fileName,String input)
	throws IOException{

		FileWriter fileWriter = new FileWriter("filename");
		for(int i=0;i<input.length();i++){
			fileWriter.write(input.charAt(i));
		}
	}
}