// 931C - Laboratory Work

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;


int main()
{
	
	int n; cin >> n;

	int lo = 10000000;
	int hi = -10000000;
	vector<int> vals(n);
	for(int i=0; i<n; i++){
		cin >> vals[i];
		lo = min(lo, vals[i]);
		hi = max(hi, vals[i]);
	}

	int diff = hi-lo;
	if(diff < 2){
		cout << n << "\n";
		for(int i=0; i<n; i++)
			cout << vals[i] << " ";
		cout << "\n";
		return 0;
	}

	int topCount = 0;
	int midCount = 0;
	int botCount = 0;

	for(int i=0; i<n; i++){
		if(vals[i] == lo) botCount++;
		else if(vals[i] == hi) topCount++;
		else midCount++;
	}

	int swapDown = min(topCount, botCount)*2;
	int swapUp = (midCount/2)*2;

	if(swapDown > swapUp){
		cout << n-swapDown << "\n";

		midCount += swapDown;
		topCount -= swapDown/2;
		botCount -= swapDown/2;

		for(int i=0; i<botCount; i++)
			cout << lo << " ";

		for(int i=0; i<midCount; i++)
			cout << lo+1 << " ";

		for(int i=0; i<topCount; i++)
			cout << hi << " ";
		cout << "\n";
	}

	else{
		cout << n-swapUp << "\n";
		midCount -= swapUp;
		topCount += swapUp/2;
		botCount += swapUp/2;


		for(int i=0; i<botCount; i++)
			cout << lo << " ";

		for(int i=0; i<midCount; i++)
			cout << lo+1 << " ";

		for(int i=0; i<topCount; i++)
			cout << hi << " ";
		cout << "\n";
	}

	return 0;
}
