#include <cmath>
#include <iostream>

using namespace std;


int main()
{
	int height, angle;
	cin >> height >> angle;

	double len = ceil(height/sin(angle *(3.14159265/180)));


	cout << len << endl;

	return 0;
}
