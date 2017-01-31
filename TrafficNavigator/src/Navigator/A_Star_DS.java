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
public class A_Star_DS {

    public int index;
    public int cost;
    public int prev_cost;
    public int prev_index;

    A_Star_DS(int source, int i, int j, int k) {
        this.index = source;
        this.cost = i;
        this.prev_cost = j;
        this.prev_index = k;

    }

}
