#include <cmath>
#include <cstdlib>
#include <iostream>
#include <string>

using namespace std;

// Finding what segment of a string was replaced to get a new string

int main()
{
	string start, end;
	cin >> start >> end;

	if(start.compare(end) == 0)
		cout << 0 << endl;
	else
	{
		int sIndex = 0;
		while(true)
		{
//			cout << "sIndex = " << sIndex << endl;

			if(sIndex == start.size() || sIndex == end.size())
				break;

			if(start.at(sIndex) != end.at(sIndex))
				break;

			sIndex++;
		}

		int eIndex = 0;
		while(true)
		{

//			cout << "eIndex = " << eIndex << "  Values: " << start.at(start.size() - eIndex) << " " << end.at(end.size() - eIndex) <<  endl;
			if(eIndex == start.size() || eIndex == end.size())
				break;

			if(start.size() - eIndex == sIndex || end.size() - eIndex == sIndex)
				break;

			if(start.at(start.size() - eIndex -1 ) != end.at(end.size() - eIndex -1))
				break;

			eIndex++;
		}

//		cout << "sIndex: "<< sIndex<< "  eIndex: "<<eIndex << endl;

		int len = abs(sIndex - ((int)end.size() - eIndex)) ;
		cout << len << endl;



	}

	return 0;
}
