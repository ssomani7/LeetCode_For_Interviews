class Solution:
    def fullJustify(words, maxWidth):
        out = []
        i=0
        string = ""
        final = []
        while(i<len(words)):
            if len(string) + len(words[i]) < maxWidth:
                string = string + words[i] + " "
            else:
                string = string[:-1]
                out.append(list(string.split(" ")))
                string = words[i] + " "
            if i == len(words)-1:
                string = string[:-1]
                out.append(list(string.split(" ")))
            i+=1

        
        print(out)
        for each in out:
            if len(each) > 1:
                req = int((maxWidth - len(''.join(each)))/(len(each)-1))
                rem = (maxWidth - len(''.join(each)))%(len(each)-1)
                string = (" " * req)
                string = each[0] +each[-1]
                for i in range(1,len(each)-1):
                    string += each[i] + (" " * req)
            print(string)

        """         print(int((maxWidth - len(''.join(out[0])))/(len(out[0])-1) ))
        for i in range(len(out)):
            if len(out[i])>1:
                req = int((maxWidth - len(''.join(out[i])))/(len(out[i])-1))
                rem = (maxWidth - len(''.join(out[i])))%(len(out[i])-1)
                print(out[i],req,rem)
                string = ""
                for j in range(len(out[i])):
                    string = string + out[i][j] + (" " * req)
                final.append(string)
            else:
                req = maxWidth - len(''.join(out[i]))
                string = out[i][0] + (" " * req)
                final.append(string)
            print(final) """
    a = fullJustify(["This", "is", "an", "example", "of", "text", "justification."],16)
    print(a)
