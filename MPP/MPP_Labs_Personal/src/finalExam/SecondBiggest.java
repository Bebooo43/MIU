package finalExam;

import java.util.Iterator;

public class SecondBiggest {

	public static void main(String[] args) {
		int[] array = null;
		int[] array2 = new int[]{};
		int[] array3 = new int[]{1};
		int[] array4 = new int[]{1,2,3,4,5};
		int[] array5 = new int[]{100,97,63,4,500};
		
		System.out.println("Second biggest: "+secondBiggest(array3));
	}
	
	public static Integer secondBiggest(int[] array) {
		if(array == null || array.length < 2) return null;
		int biggest = array[0] > array[1] ? array[0]:array[1];
		int secondBiggest = array[0] > array[1] ? array[1]:array[0];
		
		for (int i = 2; i < array.length; i++) {
			if(array[i] > biggest) {
				secondBiggest = biggest;
				biggest = array[i];
			}else if(array[i] > secondBiggest)
				secondBiggest = array[i];
		}
		
		return secondBiggest;
	}

}
