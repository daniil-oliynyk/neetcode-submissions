class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones = [-s for s in stones]
        maxHeap = stones
        heapq.heapify(maxHeap)

        while len(maxHeap) >= 2:
            x = heapq.heappop(maxHeap)
            y = heapq.heappop(maxHeap)
            if x == y:
                continue
            x = -x
            y = -y
            z = -(x - y)
            heapq.heappush(maxHeap,z)
        
        if len(maxHeap) != 0:
            return -maxHeap[0]
        return 0

