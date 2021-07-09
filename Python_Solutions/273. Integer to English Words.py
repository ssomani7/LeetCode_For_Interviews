class Solution:
    def numberToWords(num):
        import textwrap
        if num == 0:
            return "Zero"
        comma = {1:"",2: "Thousand", 3: "Million", 4: "Billion", 5: "Trillion"}
        def toWord(num):
            
            num = "0"*(3-len(num)) + num
            ts = ""
            dec = {0:"",1: "One",2:"Two",3 : "Three",4:"Four",5:"Five",6:"Siz",7:"Seven",8:"Eight",9:"Nine"}
            dec1 = {10:"Ten",11: "Eleven",12:"Twelve",13 : "Thirteen",14:"Fourteen",15:"Fifteen",16:"Sixteen",17:"Seventeen",18:"Eighteen",19:"Nineteen"}
            dec2 = {2:"Twenty",3:"Thirty",4:"Fourty",5:"Fifty",6:"Sixty",7:"Seventy",8:"Eighty",9:"Ninety"}

            if num[0] != "0":
                ts += dec[int(num[0])] + " Hundred "
            if len(num) > 1:
                if num[1] != "0":
                    if int(num[1]+num[2]) in dec1:
                        ts += dec1[int(num[1]+num[2])] + " "
                        return ts
                    else:
                        ts += dec2[int(num[1])] + " "
            if len(num) > 2:
                ts += dec[int(num[2])]
            return ts

        num = str(num)[::-1]
        tmp = (textwrap.wrap(str(num), 3))
        s = []
        l = 1
        
        for each in tmp:
            if int(each) * 1 != 0:
                s.append(toWord(each[::-1]) + " " + comma[l])
            l+=1
        s = s[::-1]
        return (' '.join(s)).strip().replace("  "," ")

    a = numberToWords(1000000)
    print(a)
