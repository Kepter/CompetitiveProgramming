#include <bits/stdc++.h>
using namespace std;

struct E
{
	int dest, cost;
	E(int D, int C)
	{
		dest = D;
		cost = C;
	}
};

struct Node
{
	vector<int> est;
	vector<E> adj;

	int sGold, dGold;
	Node() : est(), adj()
	{
		sGold = -1;
		dGold = -1;
	}
};

struct S
{
	int day, gold, node;
	S(int D, int G, int N)
	{
		day = D;
		gold = G;
		node = N;
	}
};

bool operator<(const S &a, const S &b)
{
	if(a.day != b.day) return a.day > b.day;
	return a.gold > b.gold;
}

inline int valueOn(int day, Node n)
{
	return max(0, n.sGold - n.dGold*day);
}

inline int hh(int a, int b)
{
	return ((a+b)*(a+b+1))/2 + b;
}

unordered_map<int, int> memo;
int maxGold(int day, int node, int lDay, vector<Node> &nodes)
{
	if(day >= lDay) return valueOn(day, nodes[node]);

	int p = hh(day, node);
	if(memo.count(p) == 1) return memo[p];

	int m = 0;

	for(int i=0; i<nodes[node].adj.size(); i++)
		m = max(m, maxGold(day+nodes[node].adj[i].cost, nodes[node].adj[i].dest, lDay, nodes));

	m += valueOn(day, nodes[node]);
	memo[p] = m;
	return m;
}

int main()
{
	int numNodes, numEdges; cin >> numNodes >> numEdges;

	vector<Node> nodes(numNodes, Node());
	int days = -1;
	for(int i=0; i<numNodes; i++)
	{
		cin >> nodes[i].sGold >> nodes[i].dGold;
		days = max(days, (int)ceil(nodes[i].sGold / (double)nodes[i].dGold));
	}
	days++;
	for(int i=0; i<numNodes; i++)
		nodes[i].est.resize(days+1, 0);

	for(int i=0; i<numEdges; i++)
	{
		int a, b, t; cin >> a >> b >> t;
		a--; b--;
		nodes[a].adj.push_back(E(b, t));
		nodes[b].adj.push_back(E(a, t));
	}

	int best = maxGold(0, 0, days, nodes);
	cout << best << endl;

	return 0;
}
