// 931F - Teodor is not a liar!

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

struct DE{
	vector<int> delta;
	DE(int n) : delta(n+1, 0){}

	void add(int l, int r, int v){
		delta[l] += v;
		delta[r+1] -= v;
	}

	vector<int> getArray(){
		vector<int> ret(delta.size()-1);
		int sum = 0;
		for(int i=0; i<ret.size(); i++){
			sum += delta[i];
			ret[i] = sum;
		}

		return ret;
	}
};

vector<int> fastLIS(vector<int> &vals){
	vector<int> ret(vals.size());
	map<int, int> t;
	t[0] = 0;

	for(int i=0; i<vals.size(); i++){
		int closest = (--t.upper_bound(vals[i]))->second;
		ret[i] = closest+1;
		t[vals[i]] = closest+1;

		while(true){
			auto next = t.upper_bound(vals[i]);
			if(next == t.end()) break;
			if((*next).second > closest+1) break;
			t.erase(next);
		}
	}

	return ret;
}

int main()
{
	int n, m; cin >> n >> m;
	DE delta(m);

	for(int i=0; i<n; i++){
		int l, r; cin >> l >> r;
		delta.add(l-1, r-1, 1);
	}

	vector<int> count = delta.getArray();
	vector<int> down = fastLIS(count);
	reverse(count.begin(), count.end());
	vector<int> up = fastLIS(count);

	int best = 0;
	for(int i=0; i<m; i++)
		best = max(best, up[i]+down[m-i-1]);

	cout << best-1 << "\n";
	return 0;
}
