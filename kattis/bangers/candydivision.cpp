#include <iostream>
#include <map>
#include <set>
#include <unordered_set>
#include <utility>
#include <vector>

using namespace std;

vector<long long> getPrimes(long long n);
void build(unordered_set<long long>& factors, vector<long long>& primes, vector<bool>& used, long long cur);

int main()
{
	long long n;
	cin >> n;
	cout << n << endl;

	vector<long long> primes = getPrimes(n);
	vector<bool> used(primes.size());
	unordered_set<long long> factors;

	cout << "PRIMES" << endl;
	build(factors, primes, used, 1);

	bool first = true;
	for(int i : factors)
	{
		if(!first)
			cout << " ";
		first = false;
		cout << (i-1);
	}
	cout << endl;


	return 0;
}

vector<long long> getPrimes(long long n)
{
	vector<long long> ret;

	// Remove all 2's
	while(n%2 == 0)
	{
		ret.push_back(2);
		n /= 2;
	}

	// Get all other primes
	for(long long i=3; i <= n; i+=2)
	{
		while(n%i == 0)
		{
			ret.push_back(i);
			n /= i;
		}
	}

	return ret;
}

void build(unordered_set<long long>& factors, vector<long long>& primes, vector<bool>& used, long long cur)
{
	if(factors.count(cur))
		return;

	factors.insert(cur);
	for(long long i=0; i<primes.size(); i++)
	{
		if(!used[i])
		{
			used[i] = true;
			build(factors, primes, used, cur*primes[i]);
			used[i] = false;
		}
	}
}
