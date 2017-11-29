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
			freq[index] = (freq[index]+val)%1000000007L;
			index += (index & -index);
		}
	}

	// Sum of everything between 0 and hi
	long sum(int hi)
	{
		long ret = 0;
		while(hi > 0)
		{
			ret = (ret+freq.at(hi))%1000000007L;
			hi -= (hi & -hi);
		}
		return ret;
	}

	// Sum of everything between lo and hi
	long sum(int lo, int hi)
	{
		return (sum(hi) - sum(lo-1) + 1000000007L)%1000000007L;
	}

	long below(int hi)
	{
		return sum(hi-1);
	}

	long above(int lo)
	{
		return (sum(lo+1, freq.size()-1) + 1000000007L)%1000000007L;
	}

	long tot()
	{
		return sum(freq.size()-1);
	}
};

/*
3
3
-7 8 -8
4
1 4 1 4
5
1 4 1 4 1

*/

int main()
{
	int runs; cin >> runs;

	for(int r=0; r<runs; r++)
	{
		int len; cin >> len;
		vector<int> vals(len);
		vector<int> s(len);

		for(int i=0; i<len; i++)
		{
			cin >> vals[i];
			s[i] = vals[i];
		}

		sort(s.begin(), s.end());
		map<int, int> c;

		int id = 1;
		for(int i=0; i<len; i++)
		{
			if(c.count(s[i]) == 0)
				c[s[i]] = id++;
		}

		for(int i=0; i<len; i++)
			vals[i] = c[vals[i]];


		long sub = 0;
		bit up(id);
		bit down(id);
		bit seg(id);

		for(int i=0; i<len; i++)
		{
			long pu = up.above(vals[i]);
			long pd = down.below(vals[i]);

			up.add(vals[i], pd+1);
			down.add(vals[i], pu+1);

			sub  = (sub + 2 + seg.above(vals[i]) + seg.below(vals[i]))%1000000007L;
			seg.add(vals[i], 1);
		}

		cout << (up.tot() + down.tot() - sub + 1000000007L)%1000000007L << endl;

	}

	return 0;
}
