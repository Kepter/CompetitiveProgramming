#include <iostream>
using namespace std;


int main()
{
	int perMonth;
	cin >> perMonth;
	
	int months;
	cin >> months;

	int next;
	int extra = 0;
	for(int i=0; i<months; i++)
	{
		cin >> next;
		extra += perMonth - next;
	}

	cout << extra+perMonth << endl;

	return 0;
}
