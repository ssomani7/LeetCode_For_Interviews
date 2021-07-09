S= "aaccaaa"
stack = []

for i in S:
    if stack and i == stack[-1]:
        stack.pop()
    else:
        stack.append(i)
print(stack)