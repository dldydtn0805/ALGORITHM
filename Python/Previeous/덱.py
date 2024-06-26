import sys
# sys.stdin = open('input.txt')
input = sys.stdin.readline
from collections import deque
n = int(input())
q = deque()
for _ in range(n):
    a = input().split()
    if a[0] == 'push_front':
        q.appendleft(a[1])
        pass
    elif a[0] == 'push_back':
        q.append(a[1])
        pass
    elif a[0] == 'pop_front':
        if q:
            print(q.popleft())
        else:
            print(-1)
        pass
    elif a[0] == 'pop_back':
        if q:
            print(q.pop())
        else:
            print(-1)
        pass
    elif a[0] == 'size':
        print(len(q))
        pass
    elif a[0] == 'empty':
        if q:
            print(0)
        else:
            print(1)
        pass
    elif a[0] == 'front':
        if q:
            print(q[0])
        else:
            print(-1)
        pass
    elif a[0] == 'back':
        if q:
            print(q[-1])
        else:
            print(-1)
        pass

