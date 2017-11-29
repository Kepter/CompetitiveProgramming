#include <iostream>
#include <iomanip>

using namespace std;


int main()
{
	long double cost, numLawns, tot;
	cin >> cost >> numLawns;

	tot = 0;
	for(int i=0; i<numLawns; i++)
	{
		long double width, length;
		cin >> width >> length;

		tot += (width*length*cost);
	}

	cout << setprecision(15) <<tot << endl;

	return 0;
}
