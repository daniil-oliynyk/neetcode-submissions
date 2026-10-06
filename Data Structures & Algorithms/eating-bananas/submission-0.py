class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        
        res = 0
        left = 1
        right = max(piles)
        
        while left <= right:
            k = (left+right)//2
            t = 0
            for p in piles: 
                t += math.ceil(float(p) / k)
            if t <= h:
                res = k
                right = k - 1
            elif t > h:
                left = k + 1

        
        
        return res