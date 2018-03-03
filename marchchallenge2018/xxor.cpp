#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n, q; cin >> n >> q;

	vector<vector<vector<int>>> count(n, vector<vector<int>>(32, vector<int>(2, 0)));

	for(int i=0; i<n; i++){
		int v; cin>>v;

		for(int j=0; j<32; j++){
			if(i>0) count[i][j][0] = count[i-1][j][0];
			if(i>0) count[i][j][1] = count[i-1][j][1];

			if(((1<<j) & v) != 0) count[i][j][1]++;
			else count[i][j][0]++;
		}
	}

	for(int i=0; i<q; i++){
		int l, r; cin>>l>>r;
		l--; r--;

		int out = 0;
		for(int j=0; j<31; j++){
			int ones = count[r][j][1];
			int zeros = count[r][j][0];

			if(l > 0){
				ones -= count[l-1][j][1];
				zeros -= count[l-1][j][0];
			}
			if(zeros > ones) out += 1<<j;
		}
		cout << out << "\n";
	}

	return 0;
}
