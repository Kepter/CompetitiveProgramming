#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

static int m = 0;
static ll mod = 1000000007;

struct node{
	bool isRed;

	int parent;
	int max;
	vector<int> children;
	vector<ll> ways;

	node(bool red) : ways(), children(){
		isRed = red;
		parent = -1;
		max = 0;
	}
};

int main()
{
	int n;
	cin >> n >> m;

	vector<node> nodes(n, node(false));
	for(int i=1; i<n; i++){
		int p; cin >> p; p--;
		nodes[i].parent = p;
		nodes[p].children.push_back(i);
	}

	for(int i=0; i<m; i++){
		int r; cin >> r; r--;
		nodes[r].isRed = true;
	}

	// first - idx, second - visit num
	deque<pair<int, int>> stack;
	stack.push_back({0, 0});

	while(!stack.empty()){
		int visit = stack.back().second;
		int idx = stack.back().first;
		node *cur = &nodes[idx];
		stack.pop_back();

		if(visit == 1){

			cur->max = 0;
			for(int i=0; i<cur->children.size(); i++){
				cur->max += nodes[cur->children[i]].max;
			}

			cur->ways.resize(cur->max+1);
			vector<int> nways(cur->max+1, 0);
			for(int i=0; i<cur->children.size(); i++){
				for(int i=0; i<cur->max+1; i++)
					nways[i] = cur->ways[i];

				for(int j=0; j<=cur->max; j++){
					for(int k=0; k<=nodes[cur->children[i]].max; k++){
						if(k+j > cur->max) continue;
						nways[k+j] = (nways[k+j] + (cur->ways[j]*nodes[cur->children[i]].ways[k])%mod)%mod;
					}
				}

				for(int k=0; k<=nodes[cur->children[i]].max; k++)
					nways[k] = (nways[k] + nodes[cur->children[i]].ways[k])%mod;

				for(int i=0; i<cur->max+1; i++)
					cur->ways[i] = nways[i];
			}

			if(cur->isRed){
				if(cur->max == 0){
					cur->max = 1;
					int zero = cur->ways[0];
					cur->ways.resize(2);
					cur->ways[0] = zero;
					cur->ways[1] = 1;
				}
				else{
					cur->ways[1] = (cur->ways[1] + 1)%mod;
				}
			}
			else{
				cur->ways[0] = (cur->ways[0] + 1)%mod;
			}
		}

		else{
			stack.push_back({idx, 1});

			for(int i=0; i<cur->children.size(); i++){
				stack.push_back({cur->children[i], 0});
			}
		}
	}

	nodes[0].ways[0] = (nodes[0].ways[0] + 1)%mod;

	for(int i=0; i<=m; i++){
		if(i < nodes[0].ways.size())
			cout << nodes[0].ways[i] << "\n";
		else
			cout << "0\n";
	}

	return 0;
}
