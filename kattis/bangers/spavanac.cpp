#include <iostream>
using namespace std;


int main()
{
	int hour, minute;
	cin >> hour >> minute;

	minute -= 45;
	if(minute < 0)
	{
		minute += 60;
		hour--;
	}

	if(hour < 0)
		hour += 24;

	cout << hour << " " << minute << endl;

	return 0;
}
