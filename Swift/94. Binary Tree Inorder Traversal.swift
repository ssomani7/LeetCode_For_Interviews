//
//  94. Binary Tree Inorder Traversal.swift
//  
//
//  Created by Shubham Vinod Kamdi on 20/09/21.
//

import Foundation
class Solution {
    var appendFinal: [Int] = []
    var appendStack: [Int] = []
    func inorderTraversal(_ root: TreeNode?) -> [Int] {
        traverse(root)
        return appendFinal
    }

    func traverse(_ node: TreeNode?) {
       if node != nil {
           traverse(node?.left)
           appendFinal.append(node!.val)
           traverse(node?.right)
       } else {
           return
       }
    }
}
