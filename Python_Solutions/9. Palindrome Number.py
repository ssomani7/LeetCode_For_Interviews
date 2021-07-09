A = 1234321
A = [char for char in str(A)]
if len(A)%2 == 0:
    C = A[len(A)//2:][::-1]
    B = A[:len(A)//2]
else:
    C = A[len(A)//2+1:][::-1]
    B = A[:len(A)//2]
print(C)
print(B)
if C == B:
    print('Same')