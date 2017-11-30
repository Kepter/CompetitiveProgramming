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
	int runs; cin >> runs;

	for(int r=0; r<runs; r++)
	{
		int len, avg; cin >> len >> avg;

		vector<int> cum(len+1);
		cum[0] = 0;
		int shift = 0;
		int tot = -1e9;
		for(int i=1; i<=len; i++)
		{
			int s;
			cin >> s; s -= avg;
			cum[i] = cum[i-1] + s;
			shift = min(shift, cum[i]);
			tot = max(tot, cum[i]);
		}
		shift = -shift + 1;
		tot += shift;


		bit sums(tot+1);
		sums.add(shift, 1);
		long count = 0;
		for(int i=1; i<=len; i++)
		{
			count += sums.sum(cum[i]+shift);
			sums.add(cum[i]+shift, 1);
		}

		cout << count << endl;
	}
	return 0;
}
/*
2
5 3
5 1 2 4 6
9 6
10 1 10 1 10 1 10 1 10

*/
