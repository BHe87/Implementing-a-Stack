public class LinkedStack<T> implements Stack<T>
{
	Node<T> head = null; //head node of the stack
	Node<T> nodeToPop, newNode;
	int size = 0;//variable to abstract out the complexities of a stack and represents how many things are in our stack

	private class Node<T>//inner class to make nodes
	{
		public T value;
		public Node<T> next;

		private Node(T value, Node next)//constructor for node
		{
			this.value = value;
			this.next = next;
		}
	}

	public T pop()throws UnsupportedOperationException//removes whatever is on top of our stack
	{
		if(isEmpty())//checks if the stack is empty since you can't pop from an empty stack
		{
			throw new UnsupportedOperationException();
		}
		nodeToPop = head;//this is the node on top
		head = head.next;//moves the head node to the second on top, which in turn removes the original head from the list
		size--;
		return nodeToPop.value;//returns just the value of the node on top and not the whole node
	}

	public T peek()//taking a look at whatever is on top of our stack (we don't have to check if anything is null because head is set to null if there's nothing in our stack)
	{
		return head.value;//this is the value of the top node
	}

	public void push(T thing)//adds the parameter thing to the top of our stack
	{
		newNode = new Node(thing, head);//making a new node with the value of the parameter passed and a next that points to head which is the top of our stack
		head = newNode;//making our new node the head means it's on top of our stack
		size++;
	}
  
  	public boolean isEmpty()//if our stack is empty then the size will be 0 and vice versa
  	{
  		return size == 0;
  	}
}