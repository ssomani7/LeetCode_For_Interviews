//
//  83. Remove Duplicates from Sorted List.swift
//  
//
//  Created by Shubham Vinod Kamdi on 17/09/21.
//

import Foundation
class Solution {
    var extractElement: [Int] = []
    var nodeArr: [ListNode] = []
    func deleteDuplicates(_ head: ListNode?) -> ListNode? {
        var node = head
        while node?.val ?? nil != nil {
            let currentVal = node!.val
            let tempNode = node!.next
            if !extractElement.contains(currentVal) {
                extractElement.append(currentVal)
                recursiveCheck(tempNode, currentVal)
            }
            node = tempNode
            print(extractElement.count)
        }
        node = nil
        extractElement.sort()
        for index in 0 ..< extractElement.count {
            var node = ListNode()
            node.val = extractElement[index]
            nodeArr.append(node)
            if index != 0 {
                 nodeArr[index - 1].next = node
            }
        }
        if nodeArr.count != 0 {
            return nodeArr[0]
        } else {
            //EMPTY INPUT
            return node
        }
    }

    func recursiveCheck(_ node: ListNode?, _ val: Int) {
        if !extractElement.contains(val) {
            if let safeNode = node {
                if val != safeNode.val {
                    print(safeNode.val)
                    extractElement.append(safeNode.val)
                    if let safeNext = safeNode.next {
                        recursiveCheck(safeNext, val)
                    }
                }
            }
        }
    }
}
