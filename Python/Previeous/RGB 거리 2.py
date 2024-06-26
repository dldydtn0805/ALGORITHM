import sys
# sys.stdin = open('input.txt')

N = int(input())
RGB = [list(map(int, input().split())) for _ in range(N)]

ans = I = 1e9
for i in range(3):
    dp = [[I, I, I] for _ in range(N)]  # dp가 각 R, G, B로 시작했을 때
    dp[0][i] = RGB[0][i]  # 처음 집 색칠
    for j in range(1, N):  # 2번째 집부터 R, G, B로 색칠했을 때 최소값 갱신
        dp[j][0] = RGB[j][0] + min(dp[j - 1][1], dp[j - 1][2])  # 
        dp[j][1] = RGB[j][1] + min(dp[j - 1][0], dp[j - 1][2])
        dp[j][2] = RGB[j][2] + min(dp[j - 1][0], dp[j - 1][1])
    for c in range(3):
        if i != c:  # 첫번째 집과 N번째 집이 다른 경우만 선택
            ans = min(ans, dp[-1][c])
print(ans)