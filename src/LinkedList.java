public class LinkedList {

	private Node head;
	private Node tail;
	private int size = 0;

	public void add(int data) {
		Node newNode = new Node(data);
		if (size == 0) {
			head = newNode;
			tail = newNode;
			size++;
		} else {
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
			size++;
		}
	}

	public void printList() {
		Node target = head;
		System.out.print(target.data + ", ");
		target = target.next;
		while(target != head) {
			if(target == tail) {
				System.out.print(target.data);
				target = target.next;
				break;
			}
			
			System.out.print(target.data + ", ");
			target = target.next;
		}
	}

	public int length() {
		return size;
	}
	public int removeFirst() {
		Node temp = head;
		head = temp.next;
		int returnTemp = temp.data;
		temp = null;
		size--;
		return returnTemp;
	}
	
	public int remove(int n) {
		Node target = head;
		Node newNode = null;
		if(n == 0) {
			return removeFirst();
		}
		newNode = node(n-1);
		Node todoDeleteNode = newNode.next;
		newNode.next = todoDeleteNode.next;
		int targetData = todoDeleteNode.data;
		if(todoDeleteNode == tail) {
			tail = newNode;
		}
		todoDeleteNode = null;
		size--;
		
		return targetData;
	}
	Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }
	private static class Node {
		private Node next;
		private int data;

		public Node(int data) {
			this.next = null;
			this.data = data;
		}

	}
	
}
