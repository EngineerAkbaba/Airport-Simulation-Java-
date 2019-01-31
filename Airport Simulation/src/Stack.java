
public class Stack
{
	private  int top;
	private  Flight[] elements;

	public Stack (int capacity)
	{
		elements=new Flight[capacity];
		top = -1;
	}
	
	void Push (Flight data)
	{
		if(isFull())
		{
			System.out.println("Stack overflow");
		}
		else
		{
			top++;
			elements[top] = data;
		}
	}
	
	Flight Pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
			return null;
		}
		else
		{
			Flight retData=elements[top];
			top--;
			return retData;
		}
	}
	
	Object Peek()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
			return null;
		}
		else
		{
			return (elements[top]);
		}
	}
	
	public boolean isEmpty()
	{
		return top==-1;
	}
	
	public boolean isFull()
	{
		return (top+1==elements.length);
	}
	
	int size()
	{
		return top+1;
	}
	
	int capacity()
	{
		return elements.length;
	}
	
}
