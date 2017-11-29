#include <iostream>
#include <sstream>
using namespace std;


int main()
{
	int lines;
	cin  >> lines;

	bool isFirst = true;
	while(lines != 0)
	{
		if(!isFirst)
			cout << endl;

		isFirst = false;

		string next;
		getline(cin, next);

		int pixels = -1;
		bool isError = false;

		for(int i=0; i<lines; i++)
		{
			getline(cin, next);
			istringstream line(next);

			int linePixels = 0;
			char cur;line >> cur;
			while(!line.eof())
			{
				int count; line >> count;

				cout << string(count, cur);
				linePixels += count;

				if(cur == '.')
					cur = '#';
				else
					cur = '.';
			}

			if(pixels == -1)
				pixels = linePixels;
			else if(pixels != linePixels)
				isError = true;

			cout << endl;
		}

		if(isError)
			cout << "Error decoding image" << endl;

		cin >> lines;
	}

	return 0;
}

/*
12
# 8 2 4 4 3
. 1 2 4 2 2 2 6 1 1
. 1 2 5 2 1 2 6 1 1
. 1 2 5 1 2 2 6 1 1
. 1 2 4 2 2 2 6 1 1
. 1 7 3 2 6 1 1
. 1 2 4 2 2 2 6 1 1
. 1 2 5 2 1 2 6 1 1
. 1 2 5 2 2 2 5 1 1
. 1 2 5 2 2 2 4 2 1
. 1 2 4 2 4 2 3 1 2
# 7 8 2 4
35
. 11 7 12
. 10 10 10
. 10 10 10
. 9 12 9
. 9 12 9
. 9 12 9
. 9 12 9
. 9 12 9
. 9 4 1 7 9
. 9 2 5 5 9
. 10 12 8
. 10 12 8
. 9 7 2 5 7
. 8 3 1 3 3 6 6
. 7 3 9 5 7
. 7 3 9 6 5
. 6 4 9 7 4
. 6 4 10 6 4
. 5 4 11 7 3
. 5 4 12 6 3
. 4 4 13 6 3
. 4 4 13 6 3
. 4 4 13 6 3
. 4 4 13 6 3
. 4 4 12 7 3
. 3 1 2 3 11 8 2
# 4 3 4 9 8 2
# 4 4 4 8 1 5 2 2
# 2 6 4 7 2 6 3
# 2 7 3 6 3 7 2
# 2 8 3 3 5 7 2
# 1 9 11 5 4
# 4 6 11 3 4 2
. 1 25 4
. 5 6 8 6 5
0

 */
