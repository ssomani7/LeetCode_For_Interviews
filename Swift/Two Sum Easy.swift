//
//  02 March.swift
//  
//
//  Created by Shubham Vinod Kamdi on 07/09/21.
//

import Foundation
class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        for index1 in 0 ..< nums.count {
            for index2 in (index1+1) ..< nums.count {
                let first = nums[index1]
                let second = nums[index2]
                if target == second + first {
                    return [index1,index2]
                }
            }
        }
        return []
    }
}
