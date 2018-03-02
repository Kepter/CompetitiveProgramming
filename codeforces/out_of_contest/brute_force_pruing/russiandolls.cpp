// CS Academy round 71 - Russian Dolls

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll gMin;

ll stateCost(set<int> state, map<int, ll> count){
	if(state.size() <= 1) return 0;
	ll ret = 0;


	auto it = state.rbegin();
	ll topVal = count[*it];
	it++;

	while(it != state.rend()){
		if(count[*it] > topVal){
			ll change = count[*it] - topVal;
			ret += change;
			if(change*2 > topVal || (*it)-1 <= 0) return (ll)1e12;

			if(state.count((*it)-1)){
				count[(*it)-1] = count[(*it)-1] + change*2;
			}
			else{
				state.insert((*it)-1);
				count[(*it)-1] = change*2;
			}
		}
		it++;
	}

	return ret;
}

ll minCost(set<int> state, map<int, ll> count, ll cost){
	if(cost >= gMin) return gMin;

//	cout << "Start " << cost <<": " << *(--state.end())<<" - " << count[*(--state.end())] << " gMin:  " << gMin << endl;
	ll ret = (ll)1e12;

	// "solve" this state, if we can:
	ret = min(ret, stateCost(state, count)+cost);
	gMin = min(gMin, ret);

	// "move down" the top value

	int top = *(--state.end());

	if(top > 1){
		int change = count[top];
		if(state.count(top-1)){
			count[top-1] += change*2;
			cost += change;
		}
		else{
			state.insert(top-1);
			count[top-1] = change*2;
			cost += change;
		}
		state.erase(--state.end());
		ret = min(ret, minCost(state, count, cost));
	}

	gMin = min(gMin, ret);
	return ret;
}


int main()
{
	set<int> init;
	map<int, ll> count;
	gMin = (ll)1e12;

	int n; cin >> n;
	for(int i=0; i<n; i++){
		int v; cin >> v;
		if(init.count(v)){
			count[v]++;
		}
		else{
			init.insert(v);
			count[v] = 1;
		}
	}

	cout << minCost(init, count, 0) << endl;

	return 0;
}
