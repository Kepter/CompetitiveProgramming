// CS Academy Round 71 - Replace A

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;


int main()
{
	string in, out = "";
	cin >> in;
	
	bool la = false;
	for(int i=0; i<in.length(); i++){
		if(in[i] == 'B'){
			out += 'B';
			la = false;
		}
		else{
			if(la) continue;
			la = true;
			out += 'A';
		}
	}
	cout << out << endl;

	return 0;
}
