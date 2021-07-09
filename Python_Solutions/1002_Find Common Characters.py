wordlist= ["bella","label","rolller", 'le']
import collections
res = collections.Counter(wordlist[0])
for a in wordlist:
    res &= collections.Counter(a)
print(list(res.elements()))
#print(list(res.elements()))
