
#include <iostream>
#include <string>
using namespace std;


int main()
{
	int days;
	cin >> days;

//	cout << "days: " << days << endl;

	int temp;
	int out = 0;
	for(int i=0; i<days; i++)
	{
		cin >> temp;
		if(temp < 0)
			out++;

//		cout << "Day " << i << " " << temp << endl;
	}

	cout << out << endl;
	return 0;
}
