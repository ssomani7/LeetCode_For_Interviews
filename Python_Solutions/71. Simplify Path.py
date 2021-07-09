class Solution:
    def simplifyPath(path):
        path = [x for x in path.split('/') if x != ""]
        st = []
        bc = []
        for each in path:
            if each == ".":
                continue
            elif each == "..":
                if len(st) != 0:
                    del st[0]
            else:
                st.insert(0,each)
        st = st[::-1]
        s = ""
        if len(st) == 0:
            return ""
        for each in st:
            s += "/" + each
        
        return s


        print(path)
        out = []

    a = simplifyPath("/a/../../b/../c//.//")
    print(a)