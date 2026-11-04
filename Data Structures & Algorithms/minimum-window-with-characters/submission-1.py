from collections import Counter

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ""

        need = Counter(t)
        window = {}
        have, required = 0, len(need)
        best_len, best_l = float("inf"), 0
        l = 0

        for r, c in enumerate(s):
            # expand: add s[r]
            window[c] = window.get(c, 0) + 1
            if c in need and window[c] == need[c]:
                have += 1

            # shrink while the window is still valid
            while have == required:
                if r - l + 1 < best_len:
                    best_len, best_l = r - l + 1, l

                lc = s[l]
                window[lc] -= 1
                if lc in need and window[lc] < need[lc]:
                    have -= 1
                l += 1

        return "" if best_len == float("inf") else s[best_l:best_l + best_len]