#include <bits/stdc++.h>
using namespace std;

int main(){
    string str;
    cin>>str;
    map <int, int> mp;
    for (int i=0;i<str.length();i++){
        mp[str[i]]++;
    }

    vector <pair<char, int>> mvp;
    for (auto it: mp){
        mvp.push_back(make_pair(it.second,char(it.first)));
    }
    sort(mvp.begin(), mvp.end());

    cout<<"Most frequent character = "<<char(mvp[(mvp.size()-1)].second)<<endl;
    cout<<"Second last frequent character = "<<char(mvp[(mvp.size()-2)].second)<<endl;

}
