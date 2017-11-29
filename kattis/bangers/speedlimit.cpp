#include <iostream>
using namespace std;


int main()
{
	int sets;
	cin >> sets;

	while(sets != -1)
	{
		int dist = 0;
		int lastTime = 0;
		for(int r=0; r<sets; r++)
		{
			int speed, time;
			cin >> speed >> time;
			dist += speed*(time - lastTime);
			lastTime = time;
		}
		cout << dist << " miles" << endl;
		cin >> sets;
	}



	return 0;
}
