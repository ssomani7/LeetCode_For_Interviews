//
//  Reverse Integer.swift
//
//
//  Created by Shubham Vinod Kamdi on 09/09/21.
//
//

import Foundation
class Solution {
    func reverse(_ x: Int) -> Int {
        var intToString = "\(x)"
        var reversedString: String = ""
        var returnInt: Int = 0
        var count: Int = 0
        let a = 2
         if (x > 2147483648) || x < -2147483648 {
           return 0
         } else {
            for char in intToString.reversed() {
                if x > 0 {
                    count += 1
                    reversedString += String(char)
                    if count == intToString.count {
                        returnInt = Int(reversedString) ?? 0
                    }
                } else {
                    if char != "-" {
                        reversedString += String(char)
                    } else {
                        returnInt = (Int(reversedString)  ?? 0) * -1
                    }
                }
            }
        }
        if returnInt > 2147483648 || returnInt < -2147483648 {
            returnInt = 0
        }
        return returnInt
    }
}
