# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        queue = deque()
        res = []

        queue.append(root)
        while len(queue) > 0:
            right = None
            length = len(queue)
            for i in range(length):
                node = queue.popleft()
                if node:
                    right = node
                    queue.append(node.left)
                    queue.append(node.right)
            if right:
                res.append(right.val)
        return res