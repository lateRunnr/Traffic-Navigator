/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Navigator;

import java.util.Comparator;

/**
 *
 * @author puneetkoul
 */
public class A_Star_distance_comparator implements Comparator<A_Star_DS> {

    //@Override
    public int compare(A_Star_DS o1, A_Star_DS o2) {

        return o1.cost - o2.cost;
    }

}
