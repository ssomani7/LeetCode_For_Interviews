//
//  28. Implement strStr().swift
//  
//
//  Created by Shubham Vinod Kamdi on 13/09/21.
//

import Foundation
class Solution {
    func strStr(_ haystack: String, _ needle: String) -> Int {
        var retIndex: Int = 0
        var hayStackStringArr = toStringArray(haystack)
        var needleStringArr = toStringArray(needle)
        var count: Int = 0
        var countForNeedle: Int = 0
        if haystack == "" && needle == "" {
            return 0
        } else if haystack == "" && needle != "" {
            return -1
        } else if haystack != "" && needle == "" {
            return 0
        }

        if haystack.contains(needle) {
            print(true)
            let array = haystack.components(separatedBy: needle)
            print(array.count)
            print(array[0].count)
            return array[0].count
        } else {
            return -1
        }
        return retIndex
    }

    func toStringArray(_ s: String) -> [String]{
        var retString: [String] = []
        for char in s {
            retString.append(String(char))
        }
        return retString
    }
}
