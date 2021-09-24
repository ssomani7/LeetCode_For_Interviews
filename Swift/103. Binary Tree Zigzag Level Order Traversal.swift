//
//  103. Binary Tree Zigzag Level Order Traversal.swift
//  
//
//  Created by Shubham Vinod Kamdi on 24/09/21.
//

import Foundation
class Solution {
    var shouldZigZag: Bool = false
    var tempArr: [TreeNode?] = []
    var tempData: [Int] = []
    var arrToRet: [[Int]] = []
    var leftN: TreeNode?
    var rightN: TreeNode?
    func zigzagLevelOrder(_ root: TreeNode?) -> [[Int]] {
        if root != nil {
            arrToRet.append([root!.val])
            bfsFetch([root])
        }
        tempArr = []
        tempData = []
        leftN = nil
        rightN = nil
        return arrToRet
    }
    func bfsFetch(_ node: [TreeNode?]) {
        tempArr = []
        for index in 0 ..< node.count {
            if let nodeSub = node[index] {
                if let nodeSubR = nodeSub.right {
                    tempArr.append(nodeSub.right)
                    rightN = nodeSub.right
                    tempData.append(nodeSubR.val)
                }
                if let nodeSubL = nodeSub.left {
                    tempArr.append(nodeSub.left)
                    leftN = nodeSub.left
                    tempData.append(nodeSubL.val)
                }
                if index + 1 == node.count {
                    if tempArr.count > 0 {
                        if shouldZigZag {
                            shouldZigZag = false
                            arrToRet.append(Array(tempData.reversed()))
                        } else {
                            shouldZigZag = true
                            arrToRet.append(tempData)
                        }
                        tempData = []
                        bfsFetch(tempArr)
                    }
                }
            }
        }
    }
}
