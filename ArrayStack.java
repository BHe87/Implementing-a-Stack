public class ArrayStack<T> implements Stack<T>
{
	private T[] Stack = (T[]) new Object[10];
	private T[] newStack;
	int size = 0;//variable to abstract out the complexities of a stack and represents how many things are in our stack

	public T pop()throws UnsupportedOperationException//removes whatever is on top of our stack
	{
		if(isEmpty())//checks if the array/stack is empty since you can't pop from an empty stack
		{
			throw new UnsupportedOperationException();
		}
		else
		{
			return (T) Stack[--size];//decrements the size variable to match the index of our array and returning the most recent thing added
		}
	}

	public void push(T thing)//adds the parameter passed to the top of our stack
	{
		ensureCapacity();
		Stack[size] = thing;//since size represents how many items are in our stack, the value at index size is the top of our stack
		size++;
	}

	public T peek()//taking a look at whatever is on top of our stack
	{
		if(isEmpty())//check to see if the stack is empty since you can't peek from an empty stack
		{
			return null;
		}
		else
		{	
			return (T) Stack[size - 1];//returning the object at the top of our stack
		}
	}

	private void ensureCapacity()//checks to see if the stack is full
	{
		if(size == Stack.length)//this means the stack is full
		{
			newStack = (T[]) new Object[Stack.length * 2 + 1];
			System.arraycopy(Stack, 0, newStack, 0, size);//makes more space to put stuff in
			Stack = newStack;	
		}
	}
	
  	public boolean isEmpty()//if our stack is empty then the size will be 0 and vice versa
  	{
  		return size == 0;
  	}
}