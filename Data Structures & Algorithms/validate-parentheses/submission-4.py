class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in s:
            if i == '(' or i == '[' or i == '{':
                stack.append(i)
            else:
                if len(stack) != 0:
                    temp = stack.pop()
                    if i == ')' and temp != '(' or i == ']' and temp != '[' or i == '}' and temp != '{':
                        return False
                else:
                    return False   # closer with nothing to match
        return len(stack) == 0