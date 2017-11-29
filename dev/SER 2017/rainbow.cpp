#include <bits/stdc++.h>
using namespace std;

struct Edge
{
	int dest;
	int src;
	int color;
	bool removed;
	Edge(int s, int d, int c)
	{
		color = c;
		dest = d;
		src = s;
		removed = false;
	}
};

struct S
{
	int cur, last;
	S(int c, int l)
	{
		cur = c;
		last = l;
	}
};

int main()
{
	int num; cin >> num;

	vector<list<Edge>> adj(num, list<Edge>());
	for(int i=0; i<num-1; i++)
	{
		int a, b, c; cin >> a >> b >> c;
		a--; b--;

		adj.at(a).push_back(Edge(a, b, c));
		adj.at(b).push_back(Edge(b, a, c));
	}

	int valid = num;
	vector<int> colors(num);
	vector<int> last(num, -1);
	vector<bool> removed(num, false);
	deque<Edge> q;

	for(int i=0; i<num; i++)
	{
		for(list<Edge>::iterator j = adj.at(i).begin(); j != adj.at(i).end(); j++)
		{
			if(last.at(j->color) != i)
			{
				last[j->color] = i;
				colors[j->color] = 1;
			}

			else
			{
				colors[j->color]++;
			}
		}

		for(list<Edge>::iterator j = adj.at(i).begin(); j != adj.at(i).end(); j++)
		{
			if(colors.at(j->color) > 1 && !j->removed)
			{
				q.push_back(*j);
			}
		}


	}

	while(q.size() != 0)
	{
		Edge e = q.front(); q.pop_front();

		if(!removed.at(e.dest))
		{
			removed[e.dest] = true;
			valid--;
		}

		for(list<Edge>::iterator it = adj.at(e.dest).begin(); it !=  adj.at(e.dest).end() && adj.at(e.dest).size() != 0; )
		{
			if(it->dest == e.src)
			{
				it++;
				continue;
			}
			q.push_back(*it);
			it = adj.at(e.dest).erase(it);
		}
	}

	cout << valid << endl;
	for(int i=0; i<num; i++)
		if(!removed[i]) cout << i+1 << endl;

	return 0;
}
