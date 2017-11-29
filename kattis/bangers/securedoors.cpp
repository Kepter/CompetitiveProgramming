#include <iostream>
#include <map>
#include <string>

using namespace std;


int main()
{
	map<string, bool> people;

	int length;
	cin >> length;

	for(int i=0; i<length; i++)
	{
		string action, name;
		cin >> action >> name;

		bool isEnter = (action.compare("entry") == 0);

		cout << name << " " << (isEnter ? "entered" : "exited");

		if(people.count(name))
		{
			if(people[name] == isEnter)
				cout << " (ANOMALY)";
		}
		else if(!isEnter)
			cout << " (ANOMALY)";

		cout << endl;

		people[name] = isEnter;
	}

	return 0;
}

/*
8
entry Abbey
entry Abbey
exit Abbey
entry Tyrone
exit Mason
entry Demetra
exit Latonya
entry Idella

 */
