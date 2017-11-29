#include <iostream>
using namespace std;


int main()
{
	int n;
	cin >> n;
	int highest = 0;
	for(int i=31; i>=0; i--)
	{
		if(n & (1 << i))
		{
			highest = i;
			break;
		}
	}

	int out = 0;
	for(int i=highest; i>=0; i--)
	{
		if(n & (1<<i))
		{
			out += (1 << highest-i);
		}
	}

	cout << out << endl;

	return 0;
}
