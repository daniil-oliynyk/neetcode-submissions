def inRow(row: List[int], target: int) -> bool:
    left = 0
    right = len(row) - 1
    print(row)
    while left <= right:
        mid = (left+right)//2
        if target == row[mid]:
            return True
        if target > row[mid]:
            left = mid + 1
        else:
            right = mid - 1
    return False
    


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        leftLstIdx = 0
        rightLstIdx = len(matrix) - 1
        
        while leftLstIdx <= rightLstIdx:
            leftLst = matrix[leftLstIdx]
            rightLst = matrix[rightLstIdx]
            mid = (leftLstIdx + rightLstIdx) // 2
            midLst = matrix[mid] 

            print(leftLst)
            print(rightLst)
            print(midLst)

            if (target >= midLst[0]) and (target <= midLst[len(midLst)-1]):
                print("possibly in midLst")
                return inRow(midLst, target)
            if (target >= leftLst[0]) and (target <= leftLst[len(leftLst)-1]):
                print("possibly in leftLst")
                return inRow(leftLst, target)
            if (target >= rightLst[0]) and (target <= rightLst[len(rightLst)-1]):
                print("possibly in rightLst")
                return inRow(rightLst, target)
            
            if target < midLst[0]:
                rightLstIdx = mid - 1
            if target > midLst[len(midLst) - 1]:
                leftLstIdx = mid + 1
        return False
            
            