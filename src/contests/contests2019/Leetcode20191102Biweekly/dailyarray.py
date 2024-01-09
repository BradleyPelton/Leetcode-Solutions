

class contests2020q4.leetcode20201017.Solution:
    def transformArray(self, arr: List[int]) -> List[int]:
        while True:
            copyArr = arr[:]
            try:
                for i in range(1,len(arr)-1):
                    if arr[i-1] < arr[i] and arr[i+1] < arr[i]:
                        copyArr[i] = arr[i] - 1
                    elif arr[i-1] > arr[i] and arr[i+1] > arr[i]:
                        copyArr[i] = arr[i] + 1
                    else:
                        pass
            except IndexError:
                pass
            # print(arr)
            # print(copyArr)
            if copyArr == arr:
                break
            arr = copyArr
        return(copyArr)
            

