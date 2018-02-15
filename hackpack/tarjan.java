static int t;
static ArrayDeque<N> s;
static ArrayList<ArrayList<N>> comps; 

static class N{
	long cost;
	int time = -1;
	int lowlink = -1;
	boolean ins = false;
	
	ArrayList<N> adj = new ArrayList<N>();
}

static void dfs(N cur){
	cur.time = cur.lowlink = t++;
	cur.ins = true;
	s.push(cur);
	
	for(N n : cur.adj){
		if(!n.ins){
			if(n.time == -1){ /* FORWARD EDGE */
				dfs(n); 
				cur.lowlink = Math.min(cur.lowlink, n.lowlink);
			}
			
			else {/* CROSS EDGE */}
		}
		else{ /* BACK EDGE */
			cur.lowlink = Math.min(cur.lowlink, n.time);
		}
	}
	
	if(cur.lowlink == cur.time){
		N n = null;
		ArrayList<N> comp = new ArrayList<N>();
		while(n != cur){
			n = s.pop();
			n.ins = false;
			comp.add(n);
		}
		comps.add(comp);
	}
}