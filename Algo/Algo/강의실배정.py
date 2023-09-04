
import heapq
# import sys
# sys.stdin = open('input.txt')
n = int(input())
q = []
for _ in range(n):
    a, b = map(int,input().split())
    q.append((a,b))
q.sort()

room = []
heapq.heappush(room,q[0][1])
for i in range(1,n):
    if q[i][0] < room[0]:
        heapq.heappush(room,q[i][1])
    else:
        heapq.heappop(room)
        heapq.heappush(room, q[i][1])

print(len(room))