#include <bits/stdc++.h>
using namespace std;

int main()
{
	int t; cin >> t;

	while(t-->0){
		int n; cin >> n;

		vector<int> lens(n);
		for(int i=0; i<n; i++)
			cin>>lens[i];

		vector<int> g(n);
		for(int i=0; i<n; i++)
			cin>>g[i];

		bool f = true;
		bool b = true;

		for(int i=0; i<n; i++){
			if(lens[i] > g[i]) f = false;
		}

		for(int i=0; i<n; i++){
			if(lens[i] > g[n-1-i]) b = false;
		}

		if(b&&f){
			cout << "both" << endl;
		}
		else if(b){
			cout << "back" << endl;
		}
		else if(f){
			cout << "front" << endl;
		}
		else{
			cout << "none" << endl;
		}

	}
	return 0;
}
