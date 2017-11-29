struct min_queue
{
	deque<int> regq;
	deque<int> minq;

	min_queue() : regq(), minq() {}

	void push(int x)
	{
		regq.push_back(x);

		while(!minq.empty() && minq.back() > x) minq.pop_back();
		minq.push_back(x);
	}

	void pop()
	{
		int popped = regq.front();
		regq.pop_front();
		if(popped == minq.front()) minq.pop_front();
	}

	int min()
	{
		if(regq.empty()) return 1e9;
		return minq.front();
	}

	void clear()
	{
		regq.clear();
		minq.clear();
	}

	int size()
	{
		return regq.size();
	}
};
