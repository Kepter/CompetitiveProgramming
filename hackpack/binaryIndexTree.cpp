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
