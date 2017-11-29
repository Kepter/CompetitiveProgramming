#include <iostream>
using namespace std;


int main()
{
	int numRows, numCols;
	cin >> numRows >> numCols;
	
	char **map = new char*[numRows];
	for(int i=0; i<numRows; i++)
		map[i] = new char[numCols];

	for(int i=0; i<numRows; i++)
		for(int j=0; j<numCols; j++)
			cin >> map[i][j];

//	for(int i=0; i<numRows; i++)
//	{
//		for(int j=0; j<numCols; j++)
//			cout << map[i][j];
//		cout << endl;
//	}

	int spots[5] = {};
	int squished = 0;
	for(int i=0; i<numRows-1; i++)
	{
		for(int j=0; j<numCols-1; j++)
		{
			squished =0;
			if(map[i][j] == '#')
				continue;

			if(map[i][j] == 'X')
				squished++;

			if(map[i+1][j] == '#')
				continue;

			if(map[i+1][j] == 'X')
				squished++;

			if(map[i][j+1] == '#')
				continue;

			if(map[i][j+1] == 'X')
				squished++;

			if(map[i+1][j+1] == '#')
				continue;

			if(map[i+1][j+1] == 'X')
				squished++;

			spots[squished]++;
		}
	}

	cout << spots[0] << endl;
	cout << spots[1] << endl;
	cout << spots[2] << endl;
	cout << spots[3] << endl;
	cout << spots[4] << endl;


	return 0;
}
