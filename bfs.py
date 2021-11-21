input = open('C:/Users/sazza/Desktop/422lab/input.txt', 'r')
lines = input.readlines()

n = int(lines[0])
m = int(lines[1])
grid = []

for i in range(2, n + 2):
    str = lines[i].strip()
    grid.append(str.split(' '))

new_grid = grid.copy()
que = []
human = 0
for i in range(n):
    for j in range(m):
        if grid[i][j] == 'A':
            que.append((i, j))
        elif grid[i][j] == 'H':
            human += 1

time = -1
cnt = len(que)

while not len(que) == 0:
    # print(que)
    if que[0][0] > 0 and grid[que[0][0] - 1][que[0][1]] == 'H':
        que.append((que[0][0] - 1, que[0][1]))
        grid[que[0][0] - 1][que[0][1]] = 'A'
        human -= 1

    if que[0][0] < n - 1 and grid[que[0][0] + 1][que[0][1]] == 'H':
        que.append((que[0][0] + 1, que[0][1]))
        grid[que[0][0] + 1][que[0][1]] = 'A'
        human -= 1

    if que[0][1] < m - 1 and grid[que[0][0]][que[0][1] + 1] == 'H':
        que.append((que[0][0], que[0][1] + 1))
        grid[que[0][0]][que[0][1] + 1] = 'A'
        human -= 1

    if que[0][1] > 0 and grid[que[0][0]][que[0][1] - 1] == 'H':
        que.append((que[0][0], que[0][1] - 1))
        grid[que[0][0]][que[0][1] - 1] = 'A'
        human -= 1

    cnt -= 1
    que.remove(que[0])
    if cnt == 0:
        time += 1
        cnt = len(que)

print("Time:", time, "minutes")
if human == 0:
    print("No one survived")
else:
    print(human, "survived")
# print(grid)
