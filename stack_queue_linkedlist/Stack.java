/*****************************************************************
 * 
 * CSIT212 - Stack.java		Justin Trubela		10/12/21
 * 
 * Purpose: Stack
 * 
 * Task 1 (30 pts).  Implement the empty(), push(int x), and pop() 
 * 		function for Stack in Stack.java as discussed in Lecture 5.
 * Task 4 (10 pts Extra Credit).  In the push(int x)function of 
 * 		Stack.java, by default, we never check if the stack is 
 * 		already full.  
 * 		If we insert an element into a full stack,  we should get an 
 * 		error.  Implement the capacity check feature for push(int x).
 * 
 *****************************************************************/


package stack_queue_linkedlist;


public class Stack {
	public int size;
	public int top;
	public int[] array;
	
	public Stack () {
		size = 0;
		top = -1;
		array = null;
	}
	
	public Stack (int _size) {
		size = _size;
		top = -1;
		array = new int[size];
	}
	
	/*
	 * Implement the Stack-Empty(S) function
	 */
	public boolean empty () {
		if (top < 0) {
			return true;
		}
		return false; 
	}

	/*
	 * Implement the Push(S, x) function
	 */
	public void push (int x) {
		try {
			top++;
			array[top] = x;
		} catch (Exception fullStack) {
			// TODO: handle exception
			System.err.println("Overflow: Stack is full. ");
			top--;
		}

	}
	
	/*
	 * Implement the Pop(S) function
	 * Return -1 if the stack is empty
	 */
	public int pop () {
		if (top < 0) {
			return -1;
		}
		else {
			top = top-1;
			return array[top+1];
		}
	}
	
	/*
	 * Convert stack to string in the format of #size, [#elements]
	 */
	public String toString () {
		String str;
		
		str = "Stack size: " + size + ", [";
		for (int i = 0; i <= top; i++)
			str += array[i] + ", ";
		
		str += "]";
		return str;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s;

		//initialize stack
		s = new Stack(10);
		
		//Check to see if stack is empty before pushing
		System.out.println(s.toString() + " - Stack empty: " + s.empty() + "\n");

		/********
		 * PUSH *
		 ********/
		for (int i = 0; i < 11; i++)
			s.push(i);

		//Check to see if stack is empty after push
		System.out.print("After Push\n" + s.toString() + " - Stack empty: " + s.empty());
		
		
		/********
		 * POP *
		 ********/
		//pop 2 numbers
		System.out.print("\nAfter Pop \n");
		for (int i = 0; i < 2; i++)
			s.pop();
		//Check to see if stack is empty after pop
		System.out.println(s.toString() + " - Stack empty: " + s.empty());

	}
	

}
