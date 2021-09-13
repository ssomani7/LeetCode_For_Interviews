//
//  26. Remove Duplicates from Sorted Array.swift
//  
//
//  Created by Shubham Vinod Kamdi on 12/09/21.
//

import Foundation
class Solution {
    func removeDuplicates(_ nums: inout [Int]) -> Int {
        var mainPointer: Int = 0
        if nums.count != 0 {
            for secondaryPointer in 1 ..< nums.count {
                if nums[mainPointer] != nums[secondaryPointer] {
                    print(nums[secondaryPointer])
                    mainPointer += 1
                    nums[mainPointer] = nums[secondaryPointer]
                }
            }
        } else {
            return 0
        }
        return mainPointer + 1
    }

}
