//
//  20. Valid Parentheses.swift
//  
//
//  Created by Shubham Vinod Kamdi on 11/09/21.
//

class Solution {
    var appendBraces: [String] = []
    func isValid(_ s: String) -> Bool {
        var strArray = self.getStringArray(s)!
        if strArray != nil {
            for index in 0 ..< s.count {
                let char = strArray[index]
                if char == "(" {
                    appendBraces.append("(")
                } else if char == "{" {
                    appendBraces.append("{")
                } else if char == "[" {
                    appendBraces.append("[")
                } else if char == ")" {
                    if appendBraces.count == 0 {
                        return false
                    } else {
                        if appendBraces[appendBraces.count - 1] == "(" {
                            appendBraces.remove(at:appendBraces.count - 1 )
                        } else {
                            return false
                        }
                    }
                } else if char == "}" {
                    if appendBraces.count == 0 {
                        return false
                    } else {
                        if appendBraces[appendBraces.count - 1] == "{" {
                            appendBraces.remove(at:appendBraces.count - 1 )
                        } else {
                            return false
                        }
                    }
                } else if char == "]" {
                     if appendBraces.count == 0 {
                        return false
                    } else {
                        print(appendBraces[appendBraces.count - 1])
                        if appendBraces[appendBraces.count - 1] == "[" {
                            appendBraces.remove(at:appendBraces.count - 1)
                        } else {
                            return false
                        }
                     }
                } else {
                    return false
                }
                if index + 1 == s.count {
                    if appendBraces.count == 0 {
                        return true
                    } else {
                        return false
                    }
                }
            }
        }
        return false
    }

    func getStringArray(_ s: String) -> [String]? {
        var arr: [String] = []
        for chr in s {
            arr.append("\(chr)")
        }
        return arr
    }

}
