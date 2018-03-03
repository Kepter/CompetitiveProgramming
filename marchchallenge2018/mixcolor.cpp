#include <bits/stdc++.h>
using namespace std;

int main()
{
	int t; cin >> t;

	while(t-->0){
		int n; cin >> n;

		set<int> seen;
		int change = 0;

		for(int i=0; i<n; i++){
			int c; cin >> c;
			if(seen.count(c)) change++;
			else seen.insert(c);
		}

		cout << change << "\n";
	}

	return 0;
}
