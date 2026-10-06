# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        length = 0
        curr = head
        while curr:
            length += 1
            curr = curr.next
        
        # if n == length:
        #     head = head.next
        #     return head

        curr = head #reset curr
        toremove = length - n
        if toremove==0:
            return head.next

        for i in range(0,length-n-1):
            if curr is not None:
                curr = curr.next
        if curr is None:
            return head
        
        temp = curr.next
     
        # Update the links to bypass the node to be deleted
        curr.next = curr.next.next

        return head

