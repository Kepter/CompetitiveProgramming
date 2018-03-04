#include <bits/stdc++.h>
using namespace std;
typedef long long ll;


int main()
{

	int t; cin>>t;

	while(t-->0){
		int n; cin>>n;

		vector<int> inf(n);
		for(int i=0; i<n; i++)
			cin>>inf[i];

		vector<int> votes(n, 0);
		ll delta = 0;

		multiset<ll> vals;
		for(int i=0; i<n; i++){
			votes[i] += distance(vals.lower_bound(delta), vals.end());

			delta += inf[i];
			vals.insert(inf[i]+delta);
		}

		vals.clear();
		delta = 0;
		for(int i=n-1; i>=0; i--){
			votes[i] += distance(vals.lower_bound(delta), vals.end());

			delta += inf[i];
			vals.insert(inf[i]+delta);
		}

		for(int i=0; i<n; i++)
			cout << votes[i] << " ";
		cout << "\n";
	}

	return 0;
}
