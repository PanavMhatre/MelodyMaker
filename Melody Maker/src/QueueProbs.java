import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProbs {
	
	Queue queue;

	public QueueProbs() {
		queue = new LinkedList<>();
	}
	
	public Queue<Integer> evenFirst(Queue<Integer> nums){
		Queue<Integer> oddNums = new LinkedList<>();;
		Queue<Integer> evenNums = new LinkedList<>();;
		while(!nums.isEmpty()) {
			int number = nums.poll();
			if(number % 2 ==0) {
				evenNums.offer(number);
				
			}else {
				oddNums.offer(number);
			}
			
		}
		
		while(!oddNums.isEmpty()) {
			evenNums.offer(oddNums.poll());
		}
		
		return evenNums;
	}

	public boolean numPalindrome(Queue<Integer> nums) {
		int sizeList = nums.size();
		Queue<Integer> checking = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		for(int i =0;i<sizeList/2;i++) {
			checking.offer(nums.poll());
		}
		while(!checking.isEmpty()) {
			stack.push(checking.poll());
		}
		
		System.out.println(nums);
		System.out.println(checking);
		if(sizeList%2!=0) {
			stack.push(nums.peek());
		}
		System.out.println(stack);
		
		for(int i =0;i<nums.size();i++) {
			if(nums.poll()!=stack.pop()) {
				return false;
			}
		}
		
		return true;
		
	}
	
	
	
	
	
	
}
