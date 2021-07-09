class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        digLogs = []
        letLogs = []
        
        for log in logs:
            logWords = log.split(' ')
            if logWords[1].isalpha():
                letLogs.append(log)
            else:
                digLogs.append(log)
        letLogs = sorted(letLogs, key =lambda x : (x.split(' ')[1:], x.split(' ')[0]))
        return letLogs + digLogs