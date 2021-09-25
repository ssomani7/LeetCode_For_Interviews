//
//  107. Binary Tree Level Order Traversal II.swift
//  
//
//  Created by Shubham Vinod Kamdi on 24/09/21.
//

import Foundation
class Solution {
    var returnArray: [[Int]] = []
    var tempNode: [TreeNode] = []
    var tempArr: [Int] = []
    func levelOrderBottom(_ root: TreeNode?) -> [[Int]] {
        if root != nil {
            returnArray.append([root!.val])
            bfs([root!])
        }
        return Array(returnArray.reversed())
    }

    func bfs(_ nodes: [TreeNode?]) {
        tempNode = []
        tempArr = []
        for index in 0 ..< nodes.count {
            let node = nodes[index]!
            if let nodeL = node.left {
                tempNode.append(nodeL)
                tempArr.append(nodeL.val)
            }
            if let nodeR = node.right {
                tempNode.append(nodeR)
                tempArr.append(nodeR.val)
            }
            if index + 1 == nodes.count {
                if tempArr.count > 0 {
                    returnArray.append(tempArr)
                    bfs(tempNode)
                }
            }
        }
    }
}
