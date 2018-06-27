public class ExceptionExample{
	 public static void main(String[] args) {
		int [] arr = new int[5];

		System.out.println("Statement 1");
		System.out.println("Statement 2");
		System.out.println("Statement 3");
		
		try{
		arr[7]=10;
	}catch(ArrayIndexOutOfBoundsException e){
		System.err.println(e);
	}finally{
		System.out.println(" ;)");
	}

		System.out.println("Statement 4");
		System.out.println("Statement 5");
		System.out.println("Statement 6");


	}
}