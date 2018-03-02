// CS Academy round 71 - Matrix Balls

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

vector<vector<int>> grid;
vector<vector<int>> finX;
vector<vector<pair<int, int>>> fin;
const int DX[] = {1, 0, -1, 1, 0, -1, 1, 0, -1};
const int DY[] = {1, 1, 1, 0, 0, 0, -1, -1, -1};


pair<int, int> dfs(int r, int c){

	if(fin[r][c].first == -1){
		int md = -1;
		int mv = grid[r][c];

		for(int d=0; d<9; d++){
			int nx = c + DX[d];
			int ny = r + DY[d];

			if(nx < 0 || ny < 0 || ny >= grid.size() || nx >= grid[ny].size())
				continue;

			int t = grid[ny][nx];
			if(t < mv){
				mv = t;
				md = d;
			}
		}

		if(md == -1){
			fin[r][c] = pair<int, int>(r, c);
		}
		else{
			fin[r][c] = dfs(r+DY[md], c+DX[md]);
		}
	}
	return fin[r][c];
}

int main()
{
	int n,m;
	cin >> n >> m;
	
	grid.resize(n, vector<int>(m));
	fin.resize(n, vector<pair<int, int>>(m, pair<int, int>(-1, -1)));

	for(int i=0; i<n; i++)
		for(int j=0; j<m; j++)
			cin >> grid[i][j];

	vector<vector<int>> out(n, vector<int>(m, 0));
	for(int i=0; i<n; i++)
		for(int j=0; j<m; j++){
			pair<int, int> p = dfs(i, j);
			out[p.first][p.second]++;
		}

	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			cout << out[i][j] << " ";
		}
		cout << endl;
	}

	return 0;
}
