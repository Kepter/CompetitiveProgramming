#include <iostream>
#include <map>
#include <string>

using namespace std;


int main()
{
	int runs;
	cin >> runs;
	
	for(int r=0; r<runs; r++)
	{
		map<string, bool> visted;
		string next;

		int trips;
		cin >> trips;
		for(int i=0; i<trips; i++)
		{
			cin >> next;
			visted[next] = true;
		}

		cout << visted.size() << endl;
	}

	return 0;
}
