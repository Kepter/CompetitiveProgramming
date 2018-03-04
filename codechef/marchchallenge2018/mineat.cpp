#include <bits/stdc++.h>
using namespace std;

vector<int> piles;
int h;

bool ok(int k){
	int r = 0;
	for(int i=0; i<piles.size(); i++){
		r += piles[i]/k;
		if(piles[i]%k != 0) r++;
	}

	return r <= h;
}

int main()
{
	int t; cin >> t;

	while(t-->0){
		int n; cin >> n>> h;

		piles.resize(n);

		for(int i=0; i<n; i++)
			cin>>piles[i];

		int lo = 1;
		int hi = 1000000000;

		while(lo <= hi){
			int m = lo + (hi-lo)/2;

			if(ok(m)){
				hi = m-1;
			}
			else{
				lo = m+1;
			}
		}

		cout << lo << "\n";
	}
	return 0;
}
