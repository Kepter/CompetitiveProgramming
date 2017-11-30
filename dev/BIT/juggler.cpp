#include <bits/stdc++.h>
using namespace std;

struct bit
{
	vector<long> freq;

	bit(int n)
	: freq((1 << (int)ceil(log(n)/log(2))) + 1, 0) {}

	// Adds the value to the index
	void add(int index, long val)
	{
		while(index < freq.size())
		{
			freq[index] = (freq[index]+val);
			index += (index & -index);
		}
	}

	// Sum of everything between 0 and hi
	long sum(int hi)
	{
		long ret = 0;
		while(hi > 0)
		{
			ret = (ret+freq.at(hi));
			hi -= (hi & -hi);
		}
		return ret;
	}

	// Sum of everything between lo and hi
	long sum(int lo, int hi)
	{
		return (sum(hi) - sum(lo-1));
	}

	long below(int hi)
	{
		return sum(hi-1);
	}

	long above(int lo)
	{
		return (sum(lo+1, freq.size()-1));
	}

	long tot()
	{
		return sum(freq.size()-1);
	}
};


int main()
{

	while(true)
	{
		int len; cin >> len;
		if(len == 0) break;

		bit balls(len+1);
		vector<int> location(len, -1);
		int hand = 0;

		for(int i=1; i<len+1; i++)
		{
			int a; cin >> a; a--;
			location[a] = i;
			balls.add(i, 1);
		}


		long cost = 0;
		for(int i=0; i<len; i++)
		{
			int nIndex = location[i];
			long up = 0;
			long down = 0;

			// Top between "front" and here
			if(hand < nIndex)
			{
				up = balls.sum(hand, nIndex-1);
				down = balls.below(hand) + balls.above(nIndex-1);
			}

			// To between "back" and here
			else
			{
				down = balls.sum(nIndex, hand-1);
				up = balls.below(nIndex) + balls.above(hand-1);
			}

			balls.add(nIndex, -(1));
			cost += min(up, down)+1;
			hand = nIndex;
		}
		cout << cost << endl;
	}

	return 0;
}
/*
3
3
2
1
0

 */
