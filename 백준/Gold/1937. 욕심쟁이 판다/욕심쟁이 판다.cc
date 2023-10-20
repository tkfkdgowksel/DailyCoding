#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;
#define MAX 10000

int n, arr[505][505], dp[505][505];
const int X[] = { 0,1,0,-1 };
const int Y[] = { 1,0,-1,0 };

int D(int y, int x) {
	int& temp = dp[y][x];
	if (temp != -1) return temp;
	temp = 1;
	for (int i = 0; i < 4; i++) {
		int n_y = y + Y[i], n_x = x + X[i];
		if (arr[n_y][n_x] > arr[y][x])	temp = max(temp, D(n_y, n_x) + 1);
	}
	return temp;
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> arr[i][j];
	memset(dp, -1, sizeof(dp));
	int ret = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			ret = max(ret, D(i, j));
		}
	}
	cout << ret << endl;
	return 0;
}

