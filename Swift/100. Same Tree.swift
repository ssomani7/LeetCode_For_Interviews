//
//  100. Same Tree.swift
//  
//
//  Created by Shubham Vinod Kamdi on 21/09/21.
//

import Foundation
class Solution {
    func isSameTree(_ p: TreeNode?, _ q: TreeNode?) -> Bool {
        if p == nil && q == nil {
            return true
        }
        if p?.val == q?.val {
            return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
        }
        return false
    }

}
