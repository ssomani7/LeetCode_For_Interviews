//
//  88. Merge Sorted Array.swift
//  
//
//  Created by Shubham Vinod Kamdi on 20/09/21.
//

import Foundation
class Solution {
    func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
        var pointer: Int = 0
        while m + pointer < m + n {
            if nums1[m + pointer] == 0 {
                nums1[m + pointer] = nums2[pointer]
            }
            pointer += 1
        }
        nums1.sort()
    }
}
