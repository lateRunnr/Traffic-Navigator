/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Navigator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import static usc_first.homework.matrix_size;

/**
 *
 * @author puneetkoul
 */
public class UCS_First extends navigate {

    UCS_First(int source) {
        List UCS_open = new ArrayList();
        List UCS_print = new ArrayList();
        List UCS_closed = new ArrayList();
        int element_index;
        int i, l, k, flag;
        int ucs_dest = map.get(destination);
        UCS_DS UCS_obj = new UCS_DS(source, 0, 0);
        UCS_DS current, new_obj, temp, print_temp, check;
        UCS_open.add(UCS_obj);

        while (!(UCS_open.isEmpty())) {
            current = (UCS_DS) UCS_open.remove(0);
            UCS_closed.add(current);

            if (current.array_index == ucs_dest) {
                l = UCS_closed.size();
                l = l - 1;

                print_next:
                while (l != 0) {
                    print_temp = (UCS_DS) UCS_closed.get(l);
                    UCS_print.add(print_temp);

                    for (k = 0; k < UCS_closed.size(); k++) {
                        check = (UCS_DS) UCS_closed.get(k);
                        if (print_temp.prev_index == check.array_index) {
                            l = k;
                            continue print_next;
                        }

                    }

                }
                System.out.print(getKeyFromValue(source));
                System.out.print(" ");
                System.out.println("0");

                for (i = UCS_print.size() - 1; i >= 0; i--) {
                    print_temp = (UCS_DS) UCS_print.get(i);
                    System.out.print(getKeyFromValue(print_temp.array_index));  // New Change
                    System.out.print(" ");      //NC
                    System.out.println(print_temp.prev_distance);
                }

                System.exit(0);
                //print closed list
                //Goal State reached
            } else {
                for (i = 0; i < matrix_size; i++) {  //System.out.println("cant come out");
                    flag = 0;
                    if (adj_matrix[current.array_index][i] != -1) {
                        new_obj = new UCS_DS(i, adj_matrix[current.array_index][i] + current.prev_distance, current.array_index);

                        // Checking if already exits in open queue
                        if (flag == 0) {
                            for (k = 0; k < UCS_open.size(); k++) {
                                check = (UCS_DS) UCS_open.get(k);
                                if (check.array_index == new_obj.array_index) {
                                    if (new_obj.prev_distance < check.prev_distance) {
                                        UCS_open.remove(k);
                                        UCS_open.add(new_obj);
                                        Collections.sort(UCS_open, new distance_comparator());
                                    }
                                    flag = 1;
                                }

                            }
                        }

                        // Checking if already exists in closed queue 
                        if (flag == 0) {
                            for (k = 0; k < UCS_closed.size(); k++) {
                                check = (UCS_DS) UCS_closed.get(k);
                                if (check.array_index == new_obj.array_index) {
                                    if (new_obj.prev_distance < check.prev_distance) {
                                        UCS_closed.remove(k);
                                        UCS_open.add(new_obj);
                                        Collections.sort(UCS_open, new distance_comparator());
                                    }

                                    flag = 1;
                                }

                            }
                        }

                        if (flag == 0) {
                            UCS_open.add(new_obj);
                            Collections.sort(UCS_open, new distance_comparator());
                        }

                        //push and comparator opertion  
                    }
                }
            }

        }

    }

    public static Object getKeyFromValue(Object value_temp) {
        for (Object o : map.keySet()) {
            if (map.get(o).equals(value_temp)) {
                return o;
            }
        }
        return null;
    }
}
