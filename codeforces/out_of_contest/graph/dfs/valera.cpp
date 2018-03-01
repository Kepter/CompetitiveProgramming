#include <bits/stdc++.h>
using namespace std;

struct N;
struct E;

struct E{
	bool need;
	N* dest;

	E(bool n, N* d){
		need = n;
		dest = d;
	}
};

struct N{
	vector<E> adj;
	bool need;
	int id;

	N(int ID){
		need = false;
		id = ID;
	}

	N(){
		need = false;
		id = -1;
	}
};

bool dfs(N &cur, N &last, bool need){
	bool got = false;

	for(E e : cur.adj){
		if(e.dest->id == last.id) continue;
		got |= dfs(*e.dest, cur, e.need);
	}

	if(!got && need){
		cur.need = true;
		return true;
	}

	return got;
}

int main()
{
	int n;
	cin >> n;

	vector<N> nodes;

	for(int i=0; i<n; i++)
		nodes.push_back(N(i));

	for(int i=0; i<n-1; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		a--; b--;

		nodes.at(a).adj.push_back(E(c == 2, &nodes.at(b)));
		nodes.at(b).adj.push_back(E(c == 2, &nodes.at(a)));
	}

	N t(-1);
	dfs(nodes.at(0), t, false);

	vector<int> needed;
	for(int i=0; i<nodes.size(); i++){
		if(nodes.at(i).need) needed.push_back(i+1);
	}

	cout << needed.size() << endl;
	for(int i=0; i<needed.size(); i++)
		cout << needed.at(i) << " ";
	cout << endl;

	return 0;
}



