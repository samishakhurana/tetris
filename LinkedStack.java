
public class LinkedStack<E> implements Stack<E> {
 private SinglyLinkedList<E> list = new SinglyLinkedList<>( ); // an empty list
 public LinkedStack( ) { } // new stack relies on the initially empty list
 public int size( ) { return list.size( ); }

 public boolean isEmpty( ) { return list.isEmpty( ); }

 public void push(E element) { list.addFirst(element); }

 public E top( ) { return list.first( ); }

 public E pop( ) { return list.removeFirst( ); }
}


/*public class LinkedStack<E> implements Stack<E>{
	LinkedList top;
	int size;
	LinkedStack(){
		top=null;
		size=0;
	}
	boolean isEmpty(){
		if(top==null)
			return true;
		else
			return false;
	}
	int getSize(){
		return size;
	}
	E get_top(){
		if(isEmpty()){
			return null;
		}
		return top.get_data();
	}
	void push(E data){
		LinkedList node=new LinkedList(data,null,null);
		if(top==null){
			top=node;
		}
		else{
			top.set_next(node);
			node.set_prev(top);
			node=top;
		}
		size++;
	}
	E pop() throws EmptyStackException{
		E val;
		if(isEmpty()){
			throw new EmptyStackException("Stack is Empty");
		}
		else{
			val=top.data;
			top=top.get_prev();
			top.set_next(null);
		}
	}
}*/