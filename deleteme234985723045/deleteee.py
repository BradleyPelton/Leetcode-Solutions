num1 = input()
str1 = input()
num2 = input()
str2 = input()

set1 = set(str1.split(" "))
set2 = set(str2.split(" "))

set3 = set1.symmetric_difference(set2)
print(len(set3))