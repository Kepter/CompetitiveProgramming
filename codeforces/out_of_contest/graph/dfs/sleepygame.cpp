// 937D - Sleepy Game
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

struct Node{
	vector<int> adj;
};

vector<Node> nodes;
vector<int> visited;
vector<bool> onSc;
deque<int> sc;
bool cycle;

bool dfs(bool isOdd, int idx){
	if(nodes[idx].adj.size() == 0){
		if(isOdd){
			sc.push_back(idx);
			return true;
		}
		return false;
	}

	if(onSc[idx]) cycle = true;

	if(visited[idx] == 2) return false;
	visited[idx]++;

	sc.push_back(idx);
	onSc[idx] = true;
	for(int i=0; i<nodes[idx].adj.size(); i++){
		if(dfs(!isOdd, nodes[idx].adj[i])) return true;
	}
	sc.pop_back();
	onSc[idx] = false;

	return false;
}

int main(){
	int n,m;
	cin >> n >> m;

	nodes.resize(n);
	visited.resize(n, 0);
	onSc.resize(n, false);
	cycle = false;

	for(int i=0; i<n; i++){
		int e; cin >> e;
		for(int j=0; j<e; j++){
			int t; cin >> t; t--;
			nodes[i].adj.push_back(t);
		}
	}

	int s; cin >> s; s--;
	if(dfs(false, s)){
		cout << "Win" << endl;
		for(int i=0; i<sc.size(); i++)
			cout << sc[i]+1 << " ";
		cout << endl;
	}
	else if(cycle){
		cout << "Draw" << endl;
	}
	else{
		cout << "Lose" << endl;
	}

	return 0;
}
