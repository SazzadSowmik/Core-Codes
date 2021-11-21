import numpy as np

def dfs(i, j):
    global cnt
    cnt += 1
    visited[i][j] = True

    if i > 0 and grid[i - 1][j] == 'Y' and not (visited[i - 1][j]):
        dfs(i - 1, j)
    if i < n - 1 and grid[i + 1][j] == 'Y' and not (visited[i + 1][j]):
        dfs(i + 1, j)
    if j < m - 1 and grid[i][j + 1] == 'Y' and not (visited[i][j + 1]):
        dfs(i, j + 1)
    if j > 0 and grid[i][j - 1] == 'Y' and not (visited[i][j - 1]):
        dfs(i, j - 1)

    if i > 0 and j > 0 and grid[i - 1][j - 1] == 'Y' and not (visited[i - 1][j - 1]):
        dfs(i - 1, j - 1)
    if i < n - 1 and j < m - 1 and grid[i + 1][j + 1] == 'Y' and not (visited[i + 1][j + 1]):
        dfs(i + 1, j + 1)
    if i > 0 and j < m - 1 and grid[i - 1][j + 1] == 'Y' and not (visited[i - 1][j + 1]):
        dfs(i - 1, j + 1)
    if i < n - 1 and j > 0 and grid[i + 1][j - 1] == 'Y' and not (visited[i + 1][j - 1]):
        dfs(i + 1, j - 1)


ans = 0
input = open('C:/Users/sazza/Desktop/422/input.txt', 'r')
lines = input.readlines()
grid = []

for i in lines:
    i = i.strip()
    str = i.split(' ')
    grid.append(str)
#print(grid)

n = len(grid)
m = len(grid[0])
cnt = 0
visited = np.zeros((n, m))
visited = visited > 0

for i in range(n):
    for j in range(m):
        if grid[i][j] == 'Y' and not (visited[i][j]):
            cnt = 0
            dfs(i, j)
            ans = max(ans, cnt)

print(ans)
