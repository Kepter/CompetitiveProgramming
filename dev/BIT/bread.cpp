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
	int len; cin >> len;
	vector<int> order(len);

	for(int i=0; i<len; i++)
		cin >> order[i];

	bit count(len+1);

	long inversions = 0;
	for(int i=0; i<len; i++)
	{
		inversions += count.above(order[i]);
		count.add(order[i], 1);
	}

	for(int i=0; i<len; i++)
		cin >> order[i];

	bit count2(len+1);
	long inversions2 = 0;
	for(int i=0; i<len; i++)
	{
		inversions2 += count2.above(order[i]);
		count2.add(order[i], 1);
	}

//	cout << inversions << " " << inversions2 << endl;
	inversions %= 2;
	inversions2 %= 2;
//	cout << inversions << " " << inversions2 << endl;
	if(inversions == inversions2)
		cout << "Possible" << endl;
	else
		cout << "Impossible" << endl;

	return 0;
}
