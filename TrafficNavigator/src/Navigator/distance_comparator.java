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
public class distance_comparator implements Comparator<UCS_DS> {

    public int compare(UCS_DS o1, UCS_DS o2) {

        return o1.prev_distance - o2.prev_distance;
    }
}
