//
//  35. Search Insert Position.swift
//  
//
//  Created by Shubham Vinod Kamdi on 13/09/21.
//

import Foundation
class Solution {
    var valueToShare: Int = 0
    func searchInsert(_ nums: [Int], _ target: Int) -> Int {
        if nums.contains(target) {
            for index in 0 ..< nums.count {
                if target == nums[index] {
                    print("Contains")
                    return index
                }
            }
        } else {
            if target < nums[0] {
                print("less then 0")
                return 0
            } else {
                recurssiveBreak(nums, target)
            }
        }
        return valueToShare
    }

    func recurssiveBreak(_ arr: [Int], _ target: Int)  {
        var arr1 = arr
        if target > arr[arr.count - 1] {
            print("Found \(target) at: \(arr.count)")
            valueToShare = arr.count
        } else if target < arr[arr.count - 1] {
            print("Splitting  \(target)")
            arr1.remove(at: arr.count - 1)
            recurssiveBreak(arr1, target)
        }
    }
}
