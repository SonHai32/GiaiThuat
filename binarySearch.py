def binarySearch(arr, l, r, x):
    if r >= l: 
        mid = (l+r)/2
        if arr[mid] == x:
            return mid
        elif arr[mid] > x:
            return binarySearch(arr, l, mid-1, x)
        else:
            return binarySearch(arr, mid+1, r, x)
    else: 
        return -1


print("Nhan so phan tu mang: %d")
n = input()
arr = []

for i in range(n): 
    arr.append(input())
print("find : ")
x = input()

result = binarySearch(arr, 0, len(arr)-1, x)
if result == -1:
    print("Ko tim thay")
else: 
    print("Vi tri %d" % result)




