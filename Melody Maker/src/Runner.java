import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Runner {

	public static void main(String[] args) {
		QueueProbs probs = new QueueProbs();
		Queue s= probs.evenFirst(new LinkedList<>(Arrays.asList(3,5,4,17,6,83,1,84,16,37)));
		System.out.println(s);
		Boolean t= probs.numPalindrome(new LinkedList<>(Arrays.asList(3,8,17,9,17,8,3)));
		System.out.println(t);
		

	}

}
