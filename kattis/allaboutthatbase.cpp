#include <iostream>
#include <string>
using namespace std;


int main()
{
	int runs;
	cin >> runs;
	for(int r=0; r<runs; r++)
	{
		string val1, val2, res;
		char op, eq;

		cin >> val1 >> op >> val2 >> eq >> res;
//		cout << val1 << " " << op << " " << val2 << " " << eq << " "<< res << " " << endl;

		bool isValid[36] = {false};


//		for(int i=0; i<36; i++)
//			if(isValid[i])
//				cout << "true ";
//			else
//				cout << "false ";

		// try interpreting in each base 1 to 36
		for(int i=1; i<37; i++)
		{
			int first=0, second=0, result=0, mult = 1;
			char cur;

//			cout << " --- FIRST VAL --- " << endl;
			// Try reading each digit of val1
			for(int j=val1.size()-1; j>=0; j--)
			{
				cur = val1.at(j);
//				cout << "Reading: "<< cur << endl;
				if(isdigit(cur))
				{
					if((cur - '1')<i)
						first += (cur - '0')*mult;
					else
						goto skip;
				}

				else
				{
					if((cur - 'a' + 9)<i)
						first += (cur - 'a' + 10)*mult;
					else
						goto skip;
				}

//				cout << "First is now " << first << endl;
				mult *= i;
			}

			mult = 1;
//			cout << " --- SECOND VAL --- " << endl;
			// Try reading each digit of val2
			for(int j=val2.size()-1; j>=0; j--)
			{
				cur = val2.at(j);
//				cout << "Reading: "<< cur << endl;
				if(isdigit(cur))
				{
					if((cur - '1')<i)
						second += (cur - '0')*mult;
					else
						goto skip;
				}

				else
				{
					if((cur - 'a' + 9)<i)
						second += (cur - 'a' + 10)*mult;
					else
						goto skip;
				}
//				cout << "Second is now " << second << endl;
				mult *= i;
			}

			mult = 1;
//			cout << " --- RESULT VAL --- " << endl;
			// Try reading each digit of result
			for(int j=res.size()-1; j>=0; j--)
			{
				cur = res.at(j);
//				cout << "Reading: "<< cur << endl;
				if(isdigit(cur))
				{
					if((cur - '1')<i)
						result += (cur - '0')*mult;
					else
						goto skip;
				}

				else
				{
					if((cur - 'a' + 9)<i)
						result += (cur - 'a' + 10)*mult;
					else
						goto skip;
				}
//				cout << "Result is now " << result << endl;
				mult *= i;
			}

			// Check if the math works
			if(op == '+')
			{
				if((first + second) == result)
					isValid[i] = true;
			}

			if(op == '-')
			{
				if((first - second) == result)
					isValid[i] = true;
			}

			if(op == '*')
			{
				if((first * second) == result)
					isValid[i] = true;
			}

			if(op == '/')
			{
				double sec = second;
				double fir = first;

				if(second != 0)
					if((fir / sec) == result)
						isValid[i] = true;
			}

			skip:;

//			cout << " ------------- Base " << i <<" is ";
//			if(isValid[i])
//				cout << "VALID" << endl;
//			else
//				cout << "INVALID" << endl;
		}


		// Output for whatever is valid
		bool someValid = false;
		for(int i=0; i<36; i++)
		{
			if(isValid[i])
			{
				someValid = true;
				if(i < 9)
				{
					cout << (i+1);
				}
				else if(i < 35)
				{
					char c = (i + 'a' - 9);
					cout << c;
				}
				else
				{
					cout << '0';
				}
			}
		}

		if(!someValid)
			cout << "invalid";
		cout << endl;
	}
	

	return 0;
}
