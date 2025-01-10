class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)  return head;
        int n = 1;
        ListNode temp = head;
        while (temp.next != null)
        {
            n++;
            temp = temp.next;
        }

        int mid = n/2;
        ListNode midN = head;
        for(int i = 0; i < mid-1; i++)
        {
            midN = midN.next;
        }
        temp = midN.next;
        midN.next = null;
        midN = temp;

        ListNode left = sortList(head);
        ListNode right = sortList(midN);

        return merge(left, right);
    }
    private ListNode merge(ListNode l, ListNode r)
    {
        ListNode s = new ListNode(0);
        ListNode sort = s;
        while(l != null && r != null)
        {
            if(l.val < r.val)
            {
                s.next = l;
                l = l.next;
            }
            else
            {
                s.next = r;
                r = r.next;
            }
            s = s.next;
        }

        if (l != null) {
            s.next = l;
        } else if (r != null) {
            s.next = r;
        }
        return sort.next;
    }
}