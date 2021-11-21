#include <bits/stdc++.h>
using namespace std;

const int nmax = 1000+10;
bool visited [nmax][nmax];
char grid[nmax][nmax];

int n,m,cnt;


void dfs (int i, int j){
    cnt++;
    visited[i][j] = true;


    if (i > 0 && grid[i-1][j]=='Y' && !visited[i-1][j])
        dfs(i-1, j);
    if (i < n-1 && grid[i+1][j]=='Y' && !visited[i+1][j])
        dfs(i+1, j);
    if (j < m-1 && grid[i][j+1]=='Y' && !visited[i][j+1])
        dfs(i, j+1);
    if (j > 0 && grid[i][j-1]=='Y' && !visited[i][j-1])
        dfs(i, j-1);

    if (i > 0 && j > 0 && grid[i-1][j-1]=='Y' && !visited[i-1][j-1])
        dfs(i-1, j-1);
    if (i < n-1 && j < m-1 && grid[i+1][j+1]=='Y' && !visited[i+1][j+1])
        dfs(i+1, j+1);
    if (i > 0 && j < m-1 && grid[i-1][j+1]=='Y' && !visited[i-1][j+1])
        dfs(i-1, j+1);
    if (i < n-1 && j > 0 && grid[i+1][j-1]=='Y' && !visited[i+1][j-1])
        dfs(i+1, j-1);




}

int main(){
    cin>>n>>m;
    int ans  = 0;

    for (int i=0;i<n;i++){
        cin>>grid[i];
    }

    for (int i=0;i<n;i++){
        for (int j=0;j<m;j++){
            if (grid[i][j]=='Y' && !visited[i][j]){
                cnt = 0;
                dfs(i, j);
                ans = max(ans,cnt);
            }
        }
    }

    cout<<ans<<endl;
}
