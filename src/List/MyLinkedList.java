package List;

public class MyLinkedList<A> {
	int size;
	Node<A> head;
	Node<A> tail;

	public MyLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}

	public void addElement(A inNode) {
		if (head == null) {
			head = tail = new Node<A>(inNode);
		} else {
			tail.next = new Node<A>(inNode);
			tail = tail.next;
		}
		size++;
	}

	public void updateElement(int index, A content) {
		if (index < 0 || index >= size) {
			return;
		}
		Node<A> curNode = head;
		while (index > 0) {
			curNode = curNode.next;
			index--;
		}
		curNode.content = content;
	}

	public A getElement(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		Node<A> curNode = head;
		while (index > 0) {
			curNode = curNode.next;
			index--;
		}
		return curNode.content;
	}

	public void deleteElement(int index) {
		if (index < 0 || index >= size) {
			return;
		}
		if (index == 0) {
			head = head.next;
			if (size == 1) {
				tail = null;
			}
			size--;
			return;
		}
		Node<A> preNode = null;
		Node<A> curNode = head;
		while (index > 0) {
			preNode = curNode;
			curNode = curNode.next;
			index--;
		}

		preNode.next = curNode.next;
		if (index == (size - 1)) {
			tail = preNode;
		}
		size--;
	}

	public void deleteElement(A deleNode) {
		// 这里可以用来报异常
		if (size == 0) {
			return;
		}

		if (head.content.equals(deleNode)) {
			head = head.next;
			if (size == 1) {
				tail = null;
			}
			size--;
			return;
		}

		Node<A> curNode = head.next;
		Node<A> preNode = head;
		while (curNode != null) {
			if (curNode.content.equals(deleNode)) {
				if (curNode == tail) {
					preNode.next = null;
					tail = preNode;
				} else {
					preNode.next = curNode.next;
				}
				size--;
				return;
			}
			preNode = curNode;
			curNode = curNode.next;
		}
		return;
	}

	public void showList() {
		if (size == 0) {
			System.out.println("链表为空");
			return;
		}
		Node<A> curNode = head;
		while (curNode != null) {
			System.out.print(curNode.content + "->");
			curNode = curNode.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
		myLinkedList.addElement("A");
		myLinkedList.addElement("B");
		myLinkedList.addElement("C");
		myLinkedList.addElement("D");
		myLinkedList.showList();
		myLinkedList.deleteElement("D");
		myLinkedList.showList();
		myLinkedList.updateElement(2, "E");
		myLinkedList.showList();
		System.out.println(myLinkedList.getElement(1));
		myLinkedList.deleteElement(2);
		myLinkedList.showList();
	}
}

class Node<A> {
	public Node(A content) {
		this.content = content;
		next = null;
	}

	A content;
	Node next;
}