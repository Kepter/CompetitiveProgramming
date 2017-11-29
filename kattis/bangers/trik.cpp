#include <iostream>
#include <string>
using namespace std;


int main()
{
	string raw;
	cin >> raw;

	int location[3] = {1,0,0};
	int temp;
	for(int i=0; i<raw.size(); i++)
	{
		if(raw.at(i) == 'A')
		{
			temp = location[0];
			location[0] = location[1];
			location[1] = temp;
		}

		if(raw.at(i) == 'B')
		{
			temp = location[1];
			location[1] = location[2];
			location[2] = temp;
		}

		if(raw.at(i) == 'C')
		{
			temp = location[0];
			location[0] = location[2];
			location[2] = temp;
		}
	}

	if(location[0])
		cout << "1" << endl;

	if(location[1])
		cout << "2" << endl;

	if(location[2])
		cout << "3" << endl;

	return 0;
}
