// 931B - World Cup

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;


int main()
{
	int n, a, b; cin >> n >> a >> b;

	vector<int> teams(n);
	vector<int> nteams;
	for(int i=0; i<n; i++)
		teams[i] = (i+1);

	int rounds = 1;

	while(true){
		int ga, gb;
		nteams.clear();
		for(int i=0; i<teams.size(); i+=2){

			nteams.push_back(teams[i]);

			if(teams[i] == a) ga = i/2;
			if(teams[i] == b) gb = i/2;

			if(teams[i+1] == a){
				ga = i/2;
				nteams.pop_back();
				nteams.push_back(teams[i+1]);
			}

			if(teams[i+1] == b){
				gb = i/2;
				nteams.pop_back();
				nteams.push_back(teams[i+1]);
			}
		}

		if(ga == gb) break;
		rounds++;
		teams = nteams;
	}

	if(nteams.size()==1) cout << "Final!\n";
	else cout << rounds << "\n";
	return 0;
}
