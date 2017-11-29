#include <bits/stdc++.h>
using namespace std;


int main()
{
	int stars; cin >> stars;
	int a = 2, b = 1;

	while(a*2 - 1 <= stars)
	{
//		cout << " -- a: " << a << endl;
		b = a - 1;
		if(stars%(a+b) == 0 || stars%(a+b) == a) cout << a << " " << b << endl;

		b++;
		if(stars%(a+b) == 0 || stars%(a+b) == a) cout << a << " " << b << endl;

		a++;
	}

	return 0;
}
