#include <iostream>	
#include <vector>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int n, arr[26][26], cnt; const int dx[] = { 0,0,-1,1 }, dy[] = { 1,-1,0,0 };
bool one[26][26];	vector<int> set_size;

void dfs(int y, int x) {
	for (int i = 0; i < 4; i++) {
		int d_y = y + dy[i], d_x = x + dx[i];
		if (d_y < 0 || d_y >= n || d_x < 0 || d_x >= n)	continue;
		if (one[d_y][d_x]) {
			one[d_y][d_x] = false;
			cnt++;
			dfs(d_y, d_x);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);	cin.tie(NULL);
	cin >> n;
	memset(one, false, sizeof(one));
	for (int i = 0; i < n; i++) {
		string a;	
		cin >> a;
		for (int j = 0; j < n; j++) {
			arr[i][j] = a[j] - '0';
			if (arr[i][j] == 1)
				one[i][j] = true;
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (one[i][j]) {
				cnt = 1;
				one[i][j] = false;
				dfs(i, j);
				set_size.push_back(cnt);
			}
		}
	}
	cout << set_size.size() << endl;
	sort(set_size.begin(), set_size.end());
	for (vector<int>::iterator iter = set_size.begin(); iter != set_size.end(); iter++) {
		int temp = *iter;
		cout << temp << endl;
	}
	return 0;
}