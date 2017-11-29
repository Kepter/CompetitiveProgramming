#include <iostream>
using namespace std;


int main()
{
	bool cards[4][13];
	for(int i=0; i<4; i++)
		for(int j=0; j<13; j++)
			cards[i][j] = false;

	string raw;
	cin >> raw;

	bool dup = false;
	for(int i=0; i<raw.size(); i+=3)
	{

//		cout << raw.at(i) << " " << raw.substr(i+1, 2) << endl;
		char suit = raw.at(i);
		int num = stoi(raw.substr(i+1, 2))-1;

		if(suit == 'P')
		{
			if(cards[0][num])
				dup = true;

			cards[0][num] = true;
		}

		if(suit == 'K')
		{
			if(cards[1][num])
				dup = true;

			cards[1][num] = true;
		}

		if(suit == 'H')
		{
			if(cards[2][num])
				dup = true;

			cards[2][num] = true;
		}

		if(suit == 'T')
		{
			if(cards[3][num])
				dup = true;

			cards[3][num] = true;
		}

	}

	if(dup)
		cout << "GRESKA" << endl;
	else
	{
		for(int i=0; i<4; i++)
		{
			int count = 0;
			for(int j=0; j<13; j++)
				if(cards[i][j])
					count++;
			cout << 13-count << " ";
		}

		cout << endl;
	}

	return 0;
}
