// ans is total number of edges removed and al is adjacency list of the tree.
int dfs(int node) {
    visit[node]=true;
    int num_vertex=0;
    for(int i=0;i<al[node].size();i++)
    {
        if(!visit[al[node][i]])
        {
            int num_nodes=dfs(al[node][i]);
            if(num_nodes%2==0)
                ans++;
            else
                num_vertex+=num_nodes;
        }
    }
    return num_vertex+1;
}

