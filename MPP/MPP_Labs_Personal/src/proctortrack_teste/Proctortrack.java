package proctortrack_teste;

public class Proctortrack {

	public static void main(String[] args) {
		Integer[] list = new Integer[]{19,9,11,0,12};
		Integer[] list2 = new Integer[]{1,2,3,4,5};
		
		System.out.println(findSecondBiggest(list));
		System.out.println(findSecondBiggest(list2));
	}

	static int findSecondBiggest(Integer[] list){
		int biggest = list[0];
		int secondBiggest = list[1];
		
		if(biggest < secondBiggest) {
			int temp = biggest;
			biggest = secondBiggest;
			secondBiggest = temp;
		}
		
		for (int i = 2; i < list.length; i++) {
			if(list[i] > biggest){
				int temp = biggest;
				biggest = list[i];
				secondBiggest = temp;
			}else if(list[i] > secondBiggest) {
				secondBiggest = list[i];
			}
		}
		return secondBiggest;
	}
}
