#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

struct segtree{
	vector<ll> vmin, vmax, delta;
	vector<int> minidx, maxidx;
	int n;

	segtree(int N):
		vmin(N*4 + 1, 0),
		vmax(N*4 + 1, 0),
		delta(N*4 + 1, 0),
		minidx(N*4 + 1, -1),
		maxidx(N*4 + 1, -1)
	{
		n = N;
		int nextIdx = 0;

		dfs(1, nextIdx, 0, n-1);
	}

	void dfs(int cur, int &nextIdx, int lr, int rr){
		if(lr == rr){
			minidx[cur] = nextIdx;
			maxidx[cur] = nextIdx++;
			return;
		}

		int mid = (lr + rr)/2;

		minidx[cur] = nextIdx;
		maxidx[cur] = nextIdx;
		dfs(cur*2, nextIdx, lr, mid);
		dfs(cur*2 + 1, nextIdx, mid+1, rr);
	}

	void prop(int i){
		set(i*2, delta[i]);
		set(i*2 + 1, delta[i]);
		delta[i] = 0;
	}

	void set(int i, ll val){
		delta[i] += val;
		vmax[i] += val;
		vmin[i] += val;
	}

	void update(int left, int right, ll val){
		update(1,0,n-1,left,right,val);
	}

	void update(int i, int lr, int rr, int left, int right, ll val){
		if (lr == left && rr == right)
			set(i, val);
		else {
			prop(i);
			int mid = (lr + rr) / 2;
			if (left <= mid)
				update(i * 2, lr, mid, left, min(mid,  right), val);
			if (mid < right)
				update(i * 2 + 1, mid + 1, rr, max(mid + 1, left), right, val);

			if(vmin[i*2] <= vmin[i*2 + 1]){
				vmin[i] = vmin[i*2];
				minidx[i] = minidx[i*2];
			}
			else{
				vmin[i] = vmin[i*2 + 1];
				minidx[i] = minidx[i*2 + 1];
			}

			if(vmax[i*2] >= vmax[i*2 + 1]){
				vmax[i] = vmax[i*2];
				maxidx[i] = maxidx[i*2];
			}
			else{
				vmax[i] = vmax[i*2 + 1];
				maxidx[i] = maxidx[i*2 + 1];
			}
		}
	}

	pair<pair<ll, ll>, pair<ll, ll>> query(int left, int right){
		return query(1, 0, n-1, left, right);
	}

	pair<pair<ll, ll>, pair<ll, ll>> query(int i, int lr, int rr, int left, int right){

		if (lr == left && rr == right){
			return {{vmin[i], minidx[i]}, {vmax[i], maxidx[i]}};
		}
		else {
			prop(i);
			int mid = (lr + rr) / 2;

			pair<pair<ll, ll>, pair<ll, ll>> ret;
			ret = {{numeric_limits<long>::max(), -1}, {numeric_limits<long>::min(), -1}};

			if (left <= mid) {
				pair<pair<ll, ll>, pair<ll, ll>> l = query(i * 2, lr, mid, left, min(mid, right));

				if(ret.first.first > l.first.first){
					ret.first = l.first;
				}

				if(ret.second.first < l.second.first){
					ret.second = l.second;
				}
			}
			if (mid < right) {
				pair<pair<ll, ll>, pair<ll, ll>> r = query(i * 2 + 1, mid + 1, rr, max(mid + 1, left), right);

				if(ret.first.first > r.first.first){
					ret.first = r.first;
				}

				if(ret.second.first < r.second.first){
					ret.second = r.second;
				}
			}
			return ret;
		}
	}
};


int main()
{
	int n, q; cin >> n >> q;

	segtree xtree(n);
	segtree ytree(n);

	for(int i=0; i<n; i++){
		int x, y; cin >> x >> y;
		xtree.update(i, i, x);
		ytree.update(i, i, y);

	}


	for(int i=0; i<q; i++){
		int a, b; cin >> a >> b;

		if(b-a <= 1){
			cout << "0"<< endl;
			continue;
		}

		a--; b--;

		pair<pair<ll, ll>, pair<ll, ll>> xpair = xtree.query(a, b);
		pair<pair<ll, ll>, pair<ll, ll>> ypair = ytree.query(a, b);
		pair<pair<ll, ll>, pair<ll, ll>> temp;
		pair<pair<ll, ll>, pair<ll, ll>> nx, ny;
		ll size = 1e12;

//		cout << "X min: " << xpair.first.first <<":"<< xpair.first.second << "  X max: " << xpair.second.first <<":"<<xpair.second.second << endl;
//		cout << "Y min: " << ypair.first.first <<":"<< ypair.first.second << "  Y max: " << ypair.second.first <<":"<<ypair.second.second << endl << endl;

		int undoX, undoY;

		// Remove x min
		xtree.update(xpair.first.second, xpair.first.second, xpair.second.first - xpair.first.first);
		undoX = -(xpair.second.first - xpair.first.first);

		if(ypair.first.second == xpair.first.second){
			ytree.update(xpair.first.second, xpair.first.second, ypair.second.first - ypair.first.first);
			undoY = -(ypair.second.first - ypair.first.first);
		}
		else{
			temp = ytree.query(xpair.first.second, xpair.first.second);
			ytree.update(xpair.first.second, xpair.first.second, ypair.first.first - temp.first.first);
			undoY = -(ypair.first.first - temp.first.first);
		}

		nx = xtree.query(a, b);
		ny = ytree.query(a, b);
		size = min(size, max(max((nx.second.first - nx.first.first), 1LL), max((ny.second.first - ny.first.first), 1LL)));
//		cout << "XMIN: " << max(max((nx.second.first - nx.first.first), 1LL), max((ny.second.first - ny.first.first), 1LL)) << endl;

		xtree.update(xpair.first.second, xpair.first.second, undoX);
		ytree.update(xpair.first.second, xpair.first.second, undoY);

		// Remove x max
		xtree.update(xpair.second.second, xpair.second.second, xpair.first.first - xpair.second.first);
		undoX = -(xpair.first.first - xpair.second.first);
		if(ypair.first.second == xpair.second.second){
			ytree.update(xpair.second.second, xpair.second.second, ypair.second.first - ypair.first.first);
			undoY = -(ypair.second.first - ypair.first.first);
		}
		else{
			temp = ytree.query(xpair.second.second, xpair.second.second);
			ytree.update(xpair.second.second, xpair.second.second, ypair.first.first - temp.first.first);
			undoY = -(ypair.first.first - temp.first.first);
		}

		nx = xtree.query(a, b);
		ny = ytree.query(a, b);
		size = min(size, max(max((nx.second.first - nx.first.first), 1LL), max((ny.second.first - ny.first.first), 1LL)));
//		cout << "XMAX: " << max(max((nx.second.first - nx.first.first), 1LL), max((ny.second.first - ny.first.first), 1LL)) << endl;

		xtree.update(xpair.second.second, xpair.second.second, undoX);
		ytree.update(xpair.second.second, xpair.second.second, undoY);

		// Remove y min
		ytree.update(ypair.first.second, ypair.first.second, ypair.second.first - ypair.first.first);
		undoY = -(ypair.second.first - ypair.first.first);
		if(xpair.first.second == ypair.first.second){
			xtree.update(ypair.first.second, ypair.first.second, xpair.second.first - xpair.first.first);
			undoX = -(xpair.second.first - xpair.first.first);
		}
		else{
			temp = xtree.query(ypair.first.second, ypair.first.second);
			xtree.update(ypair.first.second, ypair.first.second, xpair.first.first - temp.first.first);
			undoX = -(xpair.first.first - temp.first.first);
		}

		nx = xtree.query(a, b);
		ny = ytree.query(a, b);
		size = min(size, max(max((nx.second.first - nx.first.first), 1LL), max((ny.second.first - ny.first.first), 1LL)));
//		cout << "YMIN: " << max(max((nx.second.first - nx.first.first), 1LL), max((ny.second.first - ny.first.first), 1LL)) << endl;

		xtree.update(ypair.first.second, ypair.first.second, undoX);
		ytree.update(ypair.first.second, ypair.first.second, undoY);

		// Remove y max
		ytree.update(ypair.second.second, ypair.second.second, ypair.first.first - ypair.second.first);
		undoY = -(ypair.first.first - ypair.second.first);
		if(xpair.first.second == ypair.second.second){
			xtree.update(ypair.second.second, ypair.second.second, xpair.second.first - xpair.first.first);
			undoX = -(xpair.second.first - xpair.first.first);
		}
		else{
			temp = xtree.query(ypair.second.second, ypair.second.second);
			xtree.update(ypair.second.second, ypair.second.second, xpair.first.first - temp.first.first);
			undoX = -(xpair.first.first - temp.first.first);
		}

		nx = xtree.query(a, b);
		ny = ytree.query(a, b);
		size = min(size, max(max((nx.second.first - nx.first.first), 1LL), max((ny.second.first - ny.first.first), 1LL)));
//		cout << "YMAX: " << max(max((nx.second.first - nx.first.first), 1LL), max((ny.second.first - ny.first.first), 1LL)) << endl;

		xtree.update(ypair.second.second, ypair.second.second, undoX);
		ytree.update(ypair.second.second, ypair.second.second, undoY);

//		xpair = xtree.query(a, b);
//		ypair = ytree.query(a, b);
//		cout << "X min: " << xpair.first.first <<":"<< xpair.first.second << "  X max: " << xpair.second.first <<":"<<xpair.second.second << endl;
//		cout << "Y min: " << ypair.first.first <<":"<< ypair.first.second << "  Y max: " << ypair.second.first <<":"<<ypair.second.second << endl << endl;
		cout << size << endl;

	}

	return 0;
}
