package src.LEETCODE;

import java.util.PriorityQueue;

/* leet_23 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
 */
public class leet_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode nd1 = new ListNode(2);
		ListNode nd11 = new ListNode(1, nd1);
		ListNode nd2 = new ListNode(4);
		ListNode nd21 = new ListNode(3, nd2);
		ListNode nd3 = new ListNode(6);
		ListNode nd31 = new ListNode(5, nd3);
		ListNode[] ndl = { nd21, nd11, nd31 };

		mergeKLists(ndl);
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		PriorityQueue<ListNode> que = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);

		ListNode node = new ListNode(0);
		ListNode tail = node;

		for (ListNode list : lists) {
			if (list != null) { // ??
				que.add(list);
			}

		}


		while(!que.isEmpty()) {
			tail.next = que.poll();
			tail = tail.next;

		  	if(tail.next != null) { // ??
		  		que.add(tail.next);
			}

		}

		while(node != null) {
			System.out.println(node.val);
			if(node.next != null) { node = node.next; }
		}

		return node.next;
	}

}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
