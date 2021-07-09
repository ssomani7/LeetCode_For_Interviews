s =  "1 + (1 + 1 - 3)"
s = s.replace(" ","")
st = []

def cal(s):
    inps=[]
    i =0
    while(i<len(s)):
        if s[i] == '+':
            inps.append(int(s[i+1]))
            i+=1
        elif s[i] == '-':
            inps.append(int(s[i+1])*(-1))
            i+=1
        else:
            inps.append(int(s[i]))
        i+=1
    return sum(inps)

string = ""
final = ""
for each in s:
    if each == "(":
        st.append(each)
        final = string
        string = ""
        continue
    elif each == ")":
        st.pop(-1)
        final = str(cal(string))
        print(final)
    else:
        string = string + each