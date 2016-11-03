package ques;

class ListNode {
	      public int val;
	      public ListNode next;
	      ListNode(int x) { val = x; next = null; }
	  }
public class TempLinked {
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		ListNode head;
		ListNode hm=new ListNode(0);
		hm.next=a;
		ListNode hmm=new ListNode(0);
		hmm.next=b;
		if(a.val<=b.val){
			head=a;
		}
		else
			head=b;
		ListNode anext=a;
		ListNode bnext=b;
		while(hm.next!=null && hmm.next!=null){
			if(hm.next.val<=hmm.next.val){
				hm=hm.next;
			}
			else{
				anext=hm.next;
				bnext=hmm.next;
				hmm.next=hmm.next.next;
				hm.next=bnext;
				bnext.next=anext;
				hm=hm.next;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		System.out.println(Math.ceil(1.5));
	}
}
