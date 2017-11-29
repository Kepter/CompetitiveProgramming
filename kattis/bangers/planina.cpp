#include <iostream>
#include <cmath>
using namespace std;


int main()
{
	int iter;
	int squares = 1;
	int edges = 4;

	cin >> iter;
	
	int tot = 4;
	for(int i=0; i<iter; i++)
	{
		tot += 3*squares;
		tot += sqrt(squares)*2;

		squares *= 4;
	}

	cout << tot;


	return 0;
}
