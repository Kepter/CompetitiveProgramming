#include <algorithm>
#include <cctype>
#include <iostream>
#include <string>
#include <utility>
#include <vector>

using namespace std;


int main()
{
	int sets, length;
	cin >> sets >> length;
	
	while(sets != 0 || length != 0)
	{
		vector<pair<string, int>> vals(length);
		for(int i=0; i<length; i++)
		{
			vals[i].first = "";
			vals[i].second = i;
		}

		vector<string> input(sets);
		for(int i=0; i<sets; i++)
		{
			cin >> input[i];


			for(int j=0; j<input[i].size(); j++)
			{
				vals[j].first += tolower(input[i].at(j));
			}
		}

		sort(vals.begin(), vals.end());

		for(int i=0; i<sets; i++)
		{
			for(int j=0; j<length; j++)
			{
				cout << input[i].at(vals[j].second);
			}
			cout << endl;
		}

		cin >> sets >> length;
	}

	return 0;
}

