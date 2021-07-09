class Solution(object):
    def canPlaceFlowers(flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        if len(flowerbed) == 0:
            return False
        flowerbed.insert(0,0)
        flowerbed.append(0)
        count = 0
        i = 1
        while(i<len(flowerbed)-1):
            if flowerbed[i-1] == flowerbed[i+1] == flowerbed[i] == 0:
                count+=1
                i+=1
            i+=1
        print(count)
        if count <= n:
            return True
        else:
            return False

        
    a = canPlaceFlowers([0,0,1,0,0],1)
    print(a)