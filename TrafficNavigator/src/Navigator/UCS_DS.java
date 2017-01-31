/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Navigator ;

/**
 *
 * @author puneetkoul
 */
public class UCS_DS extends navigate {

    public int array_index;
    public int prev_distance;
    public int prev_index;

    UCS_DS(int source, int i, int j) {
        this.array_index = source;
        this.prev_distance = i;
        this.prev_index = j;
    }
}
