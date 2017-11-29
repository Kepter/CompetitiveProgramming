#include <iostream>
#include <string>
using namespace std;


int main()
{
	int numContestants;
	int numSolved;

	cin >> numContestants >> numSolved;

	string temp;

	for(int i=0; i<numContestants; i++)
		getline(cin, temp);

	cout << numSolved << endl;

	return 0;
}
