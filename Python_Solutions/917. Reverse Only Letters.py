class Solution:
    def reverseOnlyLetters(Y,M):
        if M in {1,3,5,7,8,10,12}: return 31
        if M in {4,6,9,11}: return 30
        if M == 2 and Y%4 == 0 or Y%100 

    a = reverseOnlyLetters(1836,2)
    print(a)