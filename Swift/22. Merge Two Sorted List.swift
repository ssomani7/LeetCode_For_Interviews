//
//  22. Merge Two Sorted List.swift
//  
//
//  Created by Shubham Vinod Kamdi on 12/09/21.
//

import Foundation
class Solution {
    var l1Last: ListNode = ListNode()
    var l1Array: [Int] = []
    var lnArr: [ListNode] = []
    func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        var flag: Bool = true

        if l1 != nil {
            print("l1")
            self.recurssiveCheck(l1!)
        } else if l2 != nil {
            print("l2")
            self.recurssiveCheck(l2!)
        } else {
            return nil
        }
        if l1 != nil {
            l1Last.next = l2
            self.getArraysFromNode(l1!)
        } else {
            self.getArraysFromNode(l2!)
        }
        l1Array.sort()
        if l1Array.count != 0 {
            getListNodeFromArray()
        } else {
            return nil
        }
        return lnArr[0]
    }

    func recurssiveCheck(_ l: ListNode) {
        if l.next != nil {
            recurssiveCheck(l.next!)
        } else {
            l1Last = l
        }
    }

    func getArraysFromNode(_ node: ListNode) {
        if node.val != nil {
            print(node.val)
            l1Array.append(node.val)
            if let node = node.next {
                getArraysFromNode(node)
            }
        }
    }

    func getListNodeFromArray() {
        for index in 0 ..< l1Array.count {
            var ln: ListNode = ListNode()
            ln.val = l1Array[index]
            if index == 0 {
                if index + 1 != l1Array.count {
                    lnArr.append(ln)
                } else if l1Array.count == 1 {
                     lnArr.append(ln)
                }
            } else {
                if index != l1Array.count {
                    lnArr[lnArr.count - 1].next = ln
                    lnArr.append(ln)
                }
            }
        }
    }
}
