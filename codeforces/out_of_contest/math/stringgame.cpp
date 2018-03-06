// 931E - Game with String

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;


int main()
{
	string l; cin >> l;

	int totDistinct = 0;

	for(int c=0; c<26; c++){
		int maxDistinct = 0;
		for(int d=1; d<l.length(); d++){
			int seen[26];
			for(int i=0; i<26; i++)
				seen[i]= 0;

			for(int i=0; i<l.length(); i++){
				if(l[i]-'a' != c) continue;
				seen[l[(i+d)%l.length()]-'a']++;
			}

			int numDistinct = 0;
			for(int i=0; i<26; i++)
				if(seen[i] == 1) numDistinct++;

			maxDistinct = max(maxDistinct, numDistinct);
		}
		totDistinct += maxDistinct;
	}

//	cout << maxDistinct << " " << l.length() << endl;
	printf("%Lf\n", totDistinct/(long double)l.length());

	return 0;
}
