/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Navigator;

/**
 *
 * @author puneetkoul
 */
public class DFS_DS {

    int dfs_index;
    int dfs_cost;
    int dfs_prev_index;

    DFS_DS(int i, int j, int k) {
        this.dfs_index = i;
        this.dfs_cost = j;
        this.dfs_prev_index = k;
    }

}
