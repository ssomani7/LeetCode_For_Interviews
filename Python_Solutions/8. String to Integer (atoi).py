class Solution(object):
    def myAtoi(string):
        """
        :type str: str
        :rtype: int
        """
        string = string.strip()
        negFlag = 1
        out = ""
        if len(string) == 0 or string[0].isalpha():
            return 0
        elif string[0].isdigit() or string[0] == '-' or string[0] == '+':
            for i in range(len(string)):
                if string[i] ==  '-' and i == 0:
                    negFlag = -1
                elif string[i] ==  '+' and i == 0:
                    negFlag = 1
                elif string[i].isdigit():
                    out += string[i]
                else:
                    break
        if len(out) == 0:
            return 0
        else:
            if negFlag*int(out) >= (2)**31-1 or negFlag*int(out) <= -1*2**31:
                return -1*(2)**31 if negFlag == -1 else (2)**31-1
            return negFlag*int(out)


    a = myAtoi("2147483648")
    print(a)