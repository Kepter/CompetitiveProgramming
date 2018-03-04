#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;


int main()
{
	int t; cin >> t;

	while(t-->0){
		int n; cin >> n;

		ld lose = 0;

		while(n-->0){
			ld start; cin>>start;
			ld m; cin>>m;
			ld disc; cin>>disc;

			ld price = start;
			price = price*(1+disc/100);
			lose += (start - price*(1-disc/100))*m;
		}

		printf("%Lf\n", lose);
	}

	return 0;
}
