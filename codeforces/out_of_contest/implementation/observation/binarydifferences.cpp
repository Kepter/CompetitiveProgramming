// CS Academy round 71 - Binary Differences

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;


int main()
{
	int n; cin>> n;
	
	vector<int> v(n);
	for(int i=0; i<n; i++){
		cin >> v[i];
		if(v[i] == 0) v[i]--;
	}

	int t = 0;
	int sum = 0;
	for(int i=0; i<n; i++){
		if(sum < 0) sum = 0;
		sum += v[i];
		t = max(t, sum);
	}

	int b = 0;
	sum = 0;
	for(int i=0; i<n; i++){
		if(sum > 0) sum = 0;
		sum += v[i];
		b = min(b, sum);
	}

	cout << -b + t + 1<< endl;

	return 0;
}
