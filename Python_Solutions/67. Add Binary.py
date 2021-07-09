class Solution:
    def addBinary(a,b):
        carry = 0
        l = max(len(a),len(b))
        
        a= a[::-1]
        b =b[::-1]
        if len(a) < len(b):
            a+=("0"*(max(len(a),len(b))-min(len(a),len(b))))
        elif len(a) > len(b):
            b+=("0"*(max(len(a),len(b))-min(len(a),len(b))))
        out = ""
        for i in range(l):
            if a[i] == b[i] == "0":
                if carry == 0:
                    out+= "0"
                else:
                    out+= "1"
                    carry = 0
            if a[i] == "0" and b[i] == "1":
                if carry == 0:
                    out+= "1"
                else:
                    out+= "0"
                    carry = 1
            if a[i] == "1" and b[i] == "0":
                if carry == 0:
                    out+= "1"
                else:
                    out+= "0"
                    carry = 1
            if a[i] == b[i] == "1":
                if carry == 0:
                    out+= "0"
                    carry = 1
                else:
                    out+= "1"
                    carry = 1
        if carry == 1:
            out+= "1"
        return out[::-1]
    a = addBinary("1","11100")
    print(a)