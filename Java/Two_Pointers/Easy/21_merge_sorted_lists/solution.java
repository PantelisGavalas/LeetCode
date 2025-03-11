import java.util.ArrayList;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // if any list is empty
        if (list1 == null) return list2;
        else if (list2 == null) return list1;

        // create ArrayList with values of two LinkedLists
        ArrayList<Integer> mergedList = new ArrayList<>();
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                mergedList.add(list1.val);
                list1 = list1.next;
            }
            else {
                mergedList.add(list2.val);
                list2 = list2.next;
            }
        }
        // complete ArrayList with remaining non-emptied LinkedList
        if (list1 == null) {
            while (list2 != null) {
                mergedList.add(list2.val);
                list2 = list2.next;
            }
        }
        else {
            while (list1 != null) {
                mergedList.add(list1.val);
                list1 = list1.next;
            }
        }

        // create LinkedList from merged ArrayList
        ListNode mergedHead = new ListNode(mergedList.get(0));
        ListNode temp = mergedHead;
        for (int i=1; i< mergedList.size(); i++) {
            while (temp.next != null) temp = temp.next;
            temp.next = new ListNode(mergedList.get(i));
        }

        // return merged LinkedList's head
        return mergedHead;
    }
}