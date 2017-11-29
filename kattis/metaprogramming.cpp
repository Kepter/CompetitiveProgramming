#include <sstream>
#include <string>
#include <iostream>
#include <map>
using namespace std;

// HashMaps 101

int main()
{
	string raw;

	map<string, int> vars;

	while(getline(cin, raw))
	{
		istringstream substream(raw);

		string op;
		substream >> op;

		if(op.compare("define") == 0)
		{
			int val;
			string name;
			substream >> val >> name;

			vars[name] = val;
		}

		if(op.compare("eval") == 0)
		{
			string var1, var2;
			char op;
			substream >> var1 >> op >> var2;

			if(vars.find(var1) == vars.end() || vars.find(var2) == vars.end())
			{
				cout << "undefined" << endl;
				continue;
			}

			if(op == '=')
			{

				if(vars[var1] ==  vars[var2])
					cout << "true" << endl;
				else
					cout << "false" << endl;
			}

			if(op == '>')
			{
				if(vars[var1] >  vars[var2])
					cout << "true" << endl;
				else
					cout << "false" << endl;
			}

			if(op == '<')
			{
				if(vars[var1] <  vars[var2])
					cout << "true" << endl;
				else
					cout << "false" << endl;
			}
		}

	}

	return 0;
}
