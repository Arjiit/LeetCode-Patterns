class Node {
	int data;
	Node next;

	Node(int data, Node next) {
	this.data = data;
	this.next = next;
	}
}

public class lowHighLinkedList {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};

		Node head = null;
		for (int i=a.length-1; i>=0;i--){
			head = new Node(a[i], head); // creating a linked list from reverse
			//printlist(head);
		}

		head = rearrange(head);
		printlist(head);
	}

	public static Node rearrange(Node head) {
		Node dummy = head;
		boolean low = true;

		while(head.next != null) {
			if(low) {
				if (head.data > head.next.data) {
					swap(head, head.next);
				}
				low = !low;
			} else {
				if (head.data < head.next.data) {
					swap(head, head.next);
				}
				low = !low;
			}
			head = head.next;
		}
		return dummy;
	}

	public static void swap(Node head1, Node head2) {
		int temp = head1.data;
		head1.data = head2.data;
		head2.data = temp;
	}

	public static void printlist(Node head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
}