/*****************************************************************
 * 
 * CSIT212 - Queue.java		Justin Trubela		10/12/21
 * 
 * Purpose: Queue
 * 
 * Task 2 (30 pts.).   Implement  the enqueue(int x), dequeue() 
 * 		function forQueue in Queue.java as discussed in Lecture 5.
 * Task 5 (10 pts. Extra Credit). In the enqueue(int x) function of 
 * 		Queue.java,we do not check if the queue is already full.  
 * 		Implement the capacity check feature for enqueue(int x) to 
 * 		print  the error message.)
 * Task 6 (10 pts Extra Credit).  In the dequeue()function of 
 * 		Queue.java,we do not check if the queue is empty.  
 *		If we dequeue an empty queue,we should also get an error.  
 *		Implement the empty check feature for enqueue(int x).
 * 
 *****************************************************************/


package stack_queue_linkedlist;

public class Queue {

	public int size;
	public int[] array;
	public int head;
	public int tail;

	public Queue () {
		size = 0;
		array = null;
		head = 0;
		tail = 0;
	}

	public Queue (int _size) {
		size = _size;
		array = new int[size];
		head = 0;
		tail = 0;
	}

	/*
	 * Implement the ENQUEUE(Q, x) function
	 */
	public void enqueue(int x) {

		if (tail == array.length && head == 0)
			System.out.println("queue is full");
		else {
			array[tail] = x;
			tail++;
		}

	}

	/*
	 * Implement the DEQUEUE(Q) function
	 */
	public int dequeue() {

		int num = -1;
		if (head == 0 && tail == 0)
			System.out.println("queue is empty");
		else {

			num = array[head];
			head++;

		}
		return num;
	}


	/*
	 * Convert queue to string in the format of #size, head, tail, [#elements]
	 */
	public String toString () {
		String str;

		str = size + ", " + head + ", " + tail + ", [";
		for (int i = head; i%size < tail; i++) 
			str += array[i] + ",";

		str += "]";
		return str;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q;

		q = new Queue(10);
		for (int i = 0; i < 5; i++)
			q.enqueue(i);
		System.out.println(q.toString());
		for (int i = 0; i < 5; i++) 
			q.dequeue();
		System.out.println(q.toString());
	}

}
