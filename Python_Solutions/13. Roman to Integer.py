class Solution:
    def romanToInt(s):
        final = 0
        values = [ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 ]
        numerals = [ "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" ]
        dic = ["CM","CD","XC","XL","IX","IV"]
        i =0 
        if len(s) == 1:
            return values[numerals.index(s[0])]
        while(i<len(s)-1):
            if str(s[i])+ str(s[i+1]) in dic:
                final +=  values[numerals.index(str(s[i])+ str(s[i+1]))]
                i+=1
            else:
                final += values[numerals.index(s[i])]
            i+=1
        if str(s[-2])+ str(s[-1]) not in dic:
            final += values[numerals.index(s[-1])]
        return final
    a = romanToInt("III")
    print(a)