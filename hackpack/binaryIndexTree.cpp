struct bit
{
	vector<long> freq;

	bit(int n)
	: freq((1 << ceil(log(n)/log(2))) + 1, 0) {}

	// Adds the value to the index
	void add(int index, long val)
	{
		while(index < freq.size())
		{
			freq[index] += val;
			index += (index & -index);
		}
	}

	// Sum of everything between 0 and hi
	long sum(int hi)
	{
		long ret = 0;
		while(hi > 0)
		{
			ret += freq.at(hi);
			hi -= (hi & -hi);
		}
		return ret;
	}

	// Sum of everything between lo and hi
	long sum(int lo, int hi)
	{
		return sum(hi) - sum(lo-1);
	}
};
