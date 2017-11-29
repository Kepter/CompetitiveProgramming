#include <iostream>
using namespace std;


int main()
{
	bool nums[42] = {false};

	for(int i=0; i<10; i++)
	{
		int n;
		cin >> n;
		nums[n%42] = true;
	}

	int count = 0;
	for(int i=0;  i<42; i++)
		if(nums[i])
			count++;

	cout << count << endl;

	return 0;
}
