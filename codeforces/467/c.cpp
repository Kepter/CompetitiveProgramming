// 937C - Save Energy

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;


int main()
{
	ll k,d,t;
	cin >> k >> d >> t;
	t *= 2;

	ll toOff = k;
	ll toOn = d - k%d;
	if(k%d == 0) toOn = 0;

	ll cTime = toOff+toOn;
	ll cVal = toOff*2 + toOn;

	ll out = (t/cVal)*cTime;
	ll amountCooked = (t/cVal)*cVal;

	if(amountCooked == t){
		cout << out << ".0";
	}

	else{
		ll timeLeft = t - amountCooked;
		if(timeLeft/2 + timeLeft%2 <= toOff){
			out += timeLeft/2;
			cout << out;
			if(timeLeft%2 == 1)
				cout << ".5";
			else
				cout << ".0";
			cout << endl;
		}

		else{
			out += toOff;
			timeLeft -= toOff*2;

			cout << out + timeLeft << ".0" << endl;
		}
	}



	return 0;
}
