package medium;

public class Problem2_Add_Two_Number {
    
    public static void main(String[] args) {
        Problem2_Add_Two_Number p2 = new Problem2_Add_Two_Number();
        ListNode l1 = p2.new ListNode(5);
//        l1.next = p2.new ListNode(4);
//        l1.next.next = p2.new ListNode(3);
        ListNode l2 = p2.new ListNode(5);
//        l2.next = p2.new ListNode(6);
//        l2.next.next = p2.new ListNode(4);
        ListNode result = p2.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode result = null;
        int increment = 0;
        while (l1 != null || l2 != null) {
            int curSum = 0;
            if (l1 == null) {
                curSum = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                curSum = l1.val;
                l1 = l1.next;
            } else {
                curSum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            curSum += increment;
            if (root == null) {
                result = new ListNode(curSum % 10);
                root = result;
            } else {
                result.next = new ListNode(curSum % 10);
                result = result.next;
            }
            increment = curSum / 10;
        }
        if (increment != 0) {
            result.next = new ListNode(increment);
        }
        return root;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


