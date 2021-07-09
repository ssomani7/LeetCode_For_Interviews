class Solution:
    def diStringMatch(S):
        out = []
        valLow , valHigh = 0, len(S)
        for each in S:
            if each == "I":
                out.append(valLow)
                valLow += 1
            else:
                out.append(valHigh)
                valHigh -= 1
        print(out)
    diStringMatch("DDDDD")