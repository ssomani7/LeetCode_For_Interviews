//
//  101. Symmetric Tree.swift
//  
//
//  Created by Shubham Vinod Kamdi on 22/09/21.
//
import Foundation
class Solution {
    var leftInorder: [Int] = []
    var rightInorder: [Int] = []
    func isSymmetric(_ root: TreeNode?) -> Bool {
        isSemmetric(root?.left, root?.right)
    }

    func isSemmetric(_ node1: TreeNode?,_ node2: TreeNode?) -> Bool {
        if node1 == nil && node2 == nil {
            return true
        }
        if node1 == nil || node2 == nil {
            return false
        }
        if node1?.val == node2?.val {
            return isSemmetric(node1?.left, node2?.right) && isSemmetric(node1?.right,node2?.left)
        }
        return false
    }
}
