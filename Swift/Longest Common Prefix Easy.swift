//
//  Longest Common Prefix Easy.swift
//  
//
//  Created by Shubham Vinod Kamdi on 11/09/21.
//

import Foundation
class Solution {
    var commonString: String = ""
    func longestCommonPrefix(_ strs: [String]) -> String {
        var commonString: String = ""
        var arrayForCommon: [String] = []
        if strs.count >= 1 && strs.count <= 200 {
            var firstLetter: [String] = []
            for index in 0 ..< strs.count {
                if strs[index].count <= 200 && strs[index].count >= 0  {
                   if let nextString = getNextString(index, strs) {
                        if index == 0 {
                            getCommon(strs[index], nextString)
                        } else {
                            getCommon(self.commonString, nextString)
                        }
                   } else {
                       if strs.count == 1 {
                           return strs[0]
                       }
                   }
                }
            }
        }
        return self.commonString
    }

    func getCommon(_ firstString: String, _ secondString: String) {
        var countToIterate: Int = 0
        self.commonString = ""
        var firstStr = getStringArray(firstString)!
        var secondStr = getStringArray(secondString)!
        if firstStr.count > secondStr.count {
            countToIterate = firstStr.count
        } else {
            countToIterate = secondStr.count
        }
        for i in 0 ..< countToIterate {
            var char1: String = ""
            var char2: String = ""
            var indexAppended: [Int] = []
            if i < firstStr.count {
                char1 = firstStr[i]
            }
            if i < secondStr.count {
                char2 = secondStr[i]
            }
            if char1 == char2 {
                self.commonString += char1
            } else {
                break
            }
            if i + 1 == countToIterate {
                //arrayForCommon.append(commonString)
                print(commonString)
            }
         }
    }

    func getNextString(_ index: Int,_ s:[String]) -> String? {
        if index + 1 < s.count {
            return s[index + 1]
        }
        return nil
    }

    func getStringArray(_ str: String) -> [String]? {
        var returnString: [String] = []
        for char in str {
            returnString.append(String(char))
        }
        return returnString
    }
}
