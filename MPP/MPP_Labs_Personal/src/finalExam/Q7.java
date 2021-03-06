package finalExam;

import java.util.Arrays;

public class Q7 {

	  public static void main(String[] args) {
	        int[][] array = {{0,1}, {3,5}};
	        Arrays.stream(array).flatMapToInt(x -> Arrays.stream(x)).forEach(System.out::print);
	    }
	    
	    public static int[] flattenArray(int[][] a) {
	        int finalSize = 0;
	        for(int i=0; i<a.length; i++) {
	            finalSize += a[i].length;
	        }
	        int[] result = new int[finalSize];
	        int count = 0;
	        for(int i=0; i<a.length; i++) {
	            for (int j = 0; j < a[i].length; j++) {
	                result[count++] = a[i][j];
	            }
	        }
	        return result;
	    }
}
