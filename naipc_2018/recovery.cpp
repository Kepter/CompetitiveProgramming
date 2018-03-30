#include <bits/stdc++.h>

#define ll long long
#define ld long double

using namespace std;

int main(){

	string rawRow, rawCol;
	cin >> rawRow >> rawCol;

	int rowOff = 0;
	int colOff = 0;

	char rowTarget = rawCol.length()%2 == 0 ? '1' : '0';
	char colTarget = rawRow.length()%2 == 0 ? '1' : '0';

	vector<bool> rowOk(rawRow.length(), true);
	vector<bool> colOk(rawCol.length(), true);

	for(int i=0; i<rawRow.length(); i++){
		if(rawRow[i] == rowTarget){
			rowOff++;
			rowOk[i] = false;
		}
	}

	for(int i=0; i<rawCol.length(); i++){
		if(rawCol[i] == colTarget){
			colOff++;
			colOk[i] = false;
		}
	}

	if(colOff%2 != rowOff%2){
		cout << -1 << endl;
		return 0;
	}

	vector<vector<int>> out(rawRow.length(), vector<int>(rawCol.length(), 1));

	if(rowOff > colOff){
		for(int i=0; i<rawRow.length() && rowOff > colOff; i++){
			if(!rowOk[i]){
				rowOk[i] = true;
				out[i][0] = 0;
				rowOff--;
			}
		}
	}

	if(colOff > rowOff){
		for(int i=0; i<rawCol.length() && colOff > rowOff; i++){
			if(!colOk[i]){
				colOk[i] = true;
				out[0][i] = 0;
				colOff--;
			}
		}
	}

	for(int i=0; i<rawRow.length(); i++){
		for(int j=0; j<rawCol.length(); j++){
			if(!rowOk[i] && !colOk[j]){
				out[i][j] = 0;
				rowOk[i] = true;
				colOk[j] = true;
			}
		}
	}

	for(int i=0; i<rawRow.length(); i++){
		for(int j=0; j<rawCol.length(); j++){
			cout << out[i][j];
		}
		cout << "\n";
	}


	return 0;
}
