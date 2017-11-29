#include <iostream>

using namespace std;

int dp(int fun[1000], int fear[1000], int numParts, int restVal, int maxFear);

int main()
{
    int numParts, restVal, maxFear;
    int fear[1000];
    int fun[1000];

    cin >> numParts >> restVal >> maxFear;

    while(!(numParts == 0 && restVal == 0 && maxFear == 0))
    {
        for(int i=0; i<numParts; i++)
            cin >> fun[i] >> fear[i];

        int max = dp(fun, fear, numParts, restVal, maxFear);
        cout << max << endl;

        cin >> numParts >> restVal >> maxFear;
    }



    return 0;
}


int dp(int fun[1000], int fear[1000], int numParts, int restVal, int maxFear)
{
    int min[20001];
    fill(begin(min), end(min), -1);
    min[0] = 0;

//    cout << "INIT:\n";
//    for(int i=0; i<21; i++)
//        cout << min[i] << " ";
//    cout << endl;

    for(int i=0; i<numParts; i++)
    {
        for(int j=20000; j>=fun[i]; j--)
        {
            if(min[j - fun[i]] == -1) continue;

            if(min[j] != -1 && min[j - fun[i]] + fear[i] <= maxFear)
            {
                min[j] = std::min(min[j], min[j - fun[i]] + fear[i]);
//                cout << "Updated " << j << " to " << min[j] << endl;
            }

            if(min[j] == -1 && min[j - fun[i]] + fear[i] <= maxFear)
            {
                min[j] = min[j - fun[i]] + fear[i];
//                cout << "Inialized " << j << " to " << min[j] << endl;
            }

            min[j - fun[i]] = std::max(0, min[j-fun[i]] - restVal);
        }

//        cout << "AFTER " << i << ":\n";
//        for(int i=0; i<21; i++)
//            cout << min[i] << " ";
//        cout << endl;
    }

    for(int i=20000; i>= 0; i--)
        if(min[i] != -1) return i;
    return 0;
}

/*
3 1 2
2 1
3 1
5 2

10 5 1
20 2
12 4
3 3
10 6
20 3
19 9
19 7
1 500
15 5
4 2

0 0 0

 */
