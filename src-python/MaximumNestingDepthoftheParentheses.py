class Solution(object):
    def maxDepth(self, s):
        max = 0
        ret = 0
        for c in s:
            if c == '(':
                max = max + 1
                if (ret < max):
                    ret = max
            elif c == ')':
                max = max - 1
        return ret
