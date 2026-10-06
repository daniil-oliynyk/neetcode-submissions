class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        if len(s) == 1:
            return 1
        temp = set()
        l = 0
        longest = 0
        
        for r in range(len(s)):
        
            while s[r] in temp:
                temp.remove(s[l])
                l += 1
            temp.add(s[r])
            longest = max(longest, r-l+1)
        return longest