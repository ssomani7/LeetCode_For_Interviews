class Solution:
    def licenseKeyFormatting(S,K):
        S_new=S.replace('-','')[::-1]
        group=(len(S_new)+K-1)//K
        out=[]
        for i in range(group):
            out.append(S_new[i*K:(i+1)*K][::-1].upper())
        return '-'.join(out[::-1])


        # import textwrap
        # S = S.replace("-","")
        # S = S.upper()
        # a = textwrap.wrap(S[::-1],K)
        # return '-'.join(each[::-1] for each in a[::-1])

    a = licenseKeyFormatting("5F3Z-2e-9-w",4)
    print(a)