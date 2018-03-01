// 246D - Colorful Graph
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef vector<int> vi;

int main()
{
	int n, m;
	cin >> n >> m;

	vi color(n);
	for(int i=0; i<n; i++)
		cin >> color[i];

	vector<unordered_set<int>> diversity(100001);

	for(int i=0; i<m; i++){
		int a, b;
		cin >> a >> b;

		a--;
		b--;
		if(color[a] == color[b])
			continue;

		diversity[color[a]].insert(color[b]);
		diversity[color[b]].insert(color[a]);
	}

	int mCount = -1;
	int mColor = -1;

	for(int i=0; i<n; i++){
		int c = color[i];
		int cnt = diversity[c].size();

		if(cnt > mCount || (cnt == mCount && c < mColor)){
			mCount = cnt;
			mColor = c;
		}
	}

	cout << mColor << endl;
	return 0;
}
