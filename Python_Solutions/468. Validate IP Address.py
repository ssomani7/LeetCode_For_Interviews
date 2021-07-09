class Solution:
    def validIPAddress(IP):
        w = "Niether"
        if ":" in IP:
            tmp = IP.split(":")
            if len(tmp) != 8:
                return w
            for each in tmp:
                if each.isalnum() and len(each) <=4 and (len(each) <= 4 or each.isnumeric()):
                    w = "IPv6"
                else:
                    print(each)
                    w = "Neither"
                    break
        elif "." in IP:
            tmp = IP.split(".")
            if len(tmp) != 4:
                return w
            for each in tmp:
                if each.isnumeric() and len(each) <=3 and int(each) < 256 and int(each) >= 0 and (len(str(int(each))) == len(each)): 
                        w = "IPv4"
                else:
                    w = "Neither"
                    break
        return w
            
    a = validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")
    print(a)
        