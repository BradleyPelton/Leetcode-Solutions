# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        
        bin_list = []
        while head:
            if head is None:
                break
            bin_list.append(str(head.val))
            head = head.next

        # print(bin_list)
        bin_str = "".join(bin_list)
        # print(bin_str)


        dec_int = int(bin_str, 2)
        # print(dec_int)

        return dec_int