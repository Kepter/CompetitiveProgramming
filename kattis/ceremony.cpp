#include <iostream>
#include <algorithm>
#include <deque>
using namespace std;


int main()
{
	int numBlocks;
	cin >> numBlocks;

	deque<int> heights(numBlocks);

	for(int i=0; i<numBlocks; i++)
		cin >> heights[i];

	sort(heights.begin(), heights.end());

	int charges = 0;
	int removed = 0;
	while(!heights.empty())
	{
		if(heights.size() > heights.back() - removed)
		{
			removed++;
			charges++;
			while(!heights.empty() && heights.front()-removed <= 0)
				heights.pop_front();
		}

		else
		{
			charges++;
			heights.pop_back();
		}
	}

	cout << charges << endl;

	return 0;
}

/*
6
2 1 8 8 2 3

5
1 1 1 1 3

*/
