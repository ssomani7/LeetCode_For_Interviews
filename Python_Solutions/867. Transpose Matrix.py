class Solution(object):
    def transpose(chips):
        

        # works for only 3*3 matrix
        odd , even = 0 ,0
        for i in chips:
            if i%2 ==0:
                even += 1
            else:
                odd += 1
        return min(even,odd)
        
    a = transpose( [1,2,3,2424])
    print(a)