public class ArrayManipulations {
	
	public static void main(String[] args) {
		
		//------------------------//
		//  Initialize the array  //
		//------------------------//
		
		int[]Array = {4,8,12,16,20};
		
		//  Get array length  //
		int length = Array.length;
		
		//  Calculate sum  //
		int sum = 0;
		for (int Arrays : Array) {
			sum+=Arrays;
		
		}
		
		System.out.println("Sum of the elements in the array is: "+ sum);
		
		//---------------------//
		//  Calculate average  //
		//---------------------//
		
		double average= (double) sum/length;
		
		System.out.println("The average of the element in the array is: "+ average);
		
		//  Find max value  //
		int maximumValue =Array[0];
		for (int Arrays : Array) {
			if(Arrays > maximumValue) {
				maximumValue=Arrays;
			}
		}
		
		System.out.println("The maximum value in the array is: "+ maximumValue);
		
		//------------------//
		//  Find min value  //
		//------------------//
		
		int minimumValue =Array[0];
		for (int Arrays : Array) {
			if(Arrays < minimumValue) {
				minimumValue=Arrays;
			}
		}
		
		System.out.println("The minimum value in the array is: "+ minimumValue);
		
		//---------------------//
		//  Reverse the array  //
		//---------------------//
		
		System.out.println("The reversed array is: ");
		
		for (int i = length-1; i >= 0; i--){
			
			System.out.println(Array[i]);
		}
		
	
	}
	
}