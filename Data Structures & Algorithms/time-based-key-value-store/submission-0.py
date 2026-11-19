class TimeMap:

    def __init__(self):
        self.store = {}  # key -> list of [timestamp, value]

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.store:
            self.store[key] = []
        self.store[key].append([timestamp, value])

    def get(self, key: str, timestamp: int) -> str:
        res = ""
        values = self.store.get(key, [])
        l, r = 0, len(values) - 1
        while l <= r:
            m = (l + r) // 2
            if values[m][0] <= timestamp:
                res = values[m][1]   # valid candidate, try for a later one
                l = m + 1
            else:
                r = m - 1            # too late, go left
        return res