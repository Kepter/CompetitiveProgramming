// 932C - Permutation Cycle

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;


int main()
{
	int n, A, B;
	cin >> n >> A >> B;

	if(B < A){
		int t = B;
		B = A;
		A = t;
	}

	int used = 0;
	stringstream buf;

	while((n-used)%B != 0){
		if(n-used-A < 0){
			cout << -1 << endl;
			return 0;
		}

		buf << used+A << " ";
		for(int i=used+1; i<used+A; i++){
			buf << i << " ";
		}
		used += A;
	}
	std::vector<char> s{std::istreambuf_iterator<char>{buf},{}};
	for(int i=0; i<s.size(); i++)
		cout << s[i];

	for(int i=0; i<(n-used)/B; i++){
		cout << used+i*B+B << " ";
		for(int j=used+i*B+1; j<used+i*B+B; j++)
			cout << j << " ";
	}
	cout << endl;

	return 0;
}
