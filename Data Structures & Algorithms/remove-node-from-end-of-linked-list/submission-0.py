class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        left, right = dummy, head

        # put right n nodes ahead of left
        for _ in range(n):
            right = right.next

        # move both until right falls off the end
        while right:
            left = left.next
            right = right.next

        # left is now just before the node to remove
        left.next = left.next.next
        return dummy.next