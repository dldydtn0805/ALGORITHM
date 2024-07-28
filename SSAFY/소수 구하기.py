import sys
import math

# sys.stdin = open('input.txt')
m, n = map(int, input().split())

arr = [1 for _ in range(n+1)]

for i in range(2, int(math.sqrt(n)) + 1):
    if arr[i] == 1:
        j = 2
        while i * j <= n:
            arr[i*j] = 0
            j += 1

for i in range(m, n+1):
    if i > 1:
        if arr[i] == 1:
            print(i)
