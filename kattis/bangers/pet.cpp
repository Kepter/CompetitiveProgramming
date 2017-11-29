#include <iostream>
using namespace std;


int main()
{
	int grade;
	int score;

	int max = 0;
	int maxID = 0;

	for(int i=0; i<5; i++)
	{
		score = 0;
		for(int i=0; i<4; i++)
		{
			cin >> grade;
			score += grade;
		}

		if(score > max)
		{
			max = score;
			maxID = i;
		}
	}

	cout << maxID+1 << " " << max << endl;




	return 0;
}
