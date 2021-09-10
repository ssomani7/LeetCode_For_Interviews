//
//  Palindrome .swift
//  
//
//  Created by Shubham Vinod Kamdi on 09/09/21.
//

import Foundation
class Solution {
    func isPalindrome(_ x: Int) -> Bool {
        var reverseString: String = "\(x)"
        if String(x) == String(reverseString.reversed()) {
            return true
        } else {
            return false
        }

    }
}
