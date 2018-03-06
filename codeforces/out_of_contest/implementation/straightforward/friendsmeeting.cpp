// 931A - Friends Meeting

#include <cstdlib>
#include <iostream>

using namespace std;
typedef long long ll;


int main()
{
	int a, b; cin >> a >> b;

	int diff = abs(a-b);
	
	int sum = diff/2;

	sum = (sum*(sum+1));
	if(diff%2 == 1) sum += (diff/2)+1;

	cout << sum << "\n";

	return 0;
}
