#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;


int main()
{
	int matches, boxW, boxH;
	cin >> matches >> boxW >> boxH;
	
	double m = sqrt(boxW*boxW + boxH*boxH);
	int used = 0;
	int next;
	for(int i=0; i<matches; i++)
	{
		cin >> next;
		if(next > m)
			cout << "NE" << endl;
		else
			cout << "DA" << endl;
	}

	return 0;
}
