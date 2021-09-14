//
//  58. length of the last word.swift
//  
//
//  Created by Shubham Vinod Kamdi on 14/09/21.
//

import Foundation
class Solution {
    func lengthOfLastWord(_ s: String) -> Int {
        var subArray = s.components(separatedBy: CharacterSet.whitespaces)
        for word in subArray.reversed() {
           if word == "" {
               //white spaces which turn into empty elements
           } else {
                return word.count
           }
        }
        return 1
    }
}
