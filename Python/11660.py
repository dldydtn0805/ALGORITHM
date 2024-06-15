import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

for i in range(N):
    for j in range(N):
        if i == 0 and j == 0:
            arr[i][j] = arr[i][j]
        elif j == 0:
            arr[i][j] = arr[i-1][j] + arr[i][j]
        elif i == 0:
            arr[i][j] = arr[i][j-1] + arr[i][j]
        else:
            arr[i][j] = arr[i-1][j]+arr[i][j-1]+arr[i][j]-arr[i-1][j-1]

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    x1 -= 1
    y1 -= 1
    x2 -= 1
    y2 -= 1
    if x1 == 0 and y1 == 0:
        print(arr[x2][y2])
    elif x1 == 0:
        print(arr[x2][y2] - arr[x2][y1-1])
    elif y1 == 0:
        print(arr[x2][y2] - arr[x1-1][y2])
    else:
        print(arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1])

