/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Navigator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author puneetkoul
 */
public class DFS_Second extends navigate {

    DFS_Second(int source) {

        List dfs_stack = new ArrayList();
        List dfs_print = new ArrayList();
        List dfs_closed = new ArrayList();

        int i, k, final_size, flag;
        int dfs_dest = map.get(destination);

        DFS_DS dfs_obj = new DFS_DS(source, 0, 0);
        DFS_DS current, print_dfs_temp, check, new_DFSobj;
        dfs_stack.add(dfs_obj);

        while (!(dfs_stack.isEmpty())) {
            System.out.print("Size ");
            System.out.println(dfs_stack.size() - 1);
            current = (DFS_DS) dfs_stack.remove(dfs_stack.size() - 1);
            dfs_closed.add(current);

            if (current.dfs_index == dfs_dest) { //System.out.println("we are euqlajv");
                final_size = dfs_closed.size();
                final_size = final_size - 1;

                print_next:
                while (final_size != 0) {
                    print_dfs_temp = (DFS_DS) dfs_closed.get(final_size);
                    dfs_print.add(print_dfs_temp);

                    for (k = 0; k < dfs_closed.size(); k++) {
                        check = (DFS_DS) dfs_closed.get(k);
                        if (print_dfs_temp.dfs_prev_index == check.dfs_index) {
                            final_size = k;
                            //System.out.println("final: print");
                            continue print_next;
                        }

                    }

                }
                System.out.print(getKeyFromValue(source));
                System.out.print(" ");
                System.out.println("0");

                for (i = dfs_print.size() - 1; i >= 0; i--) {
                    print_dfs_temp = (DFS_DS) dfs_print.get(i);
                    //dfs_print.add(print_dfs_temp);
                    System.out.print(getKeyFromValue(print_dfs_temp.dfs_index));  // New Change
                    System.out.print(" ");      //NC
                    System.out.println(print_dfs_temp.dfs_cost);
                    //  System.out.print()
                }

                System.exit(0);
                //Goal State reached
            } else {
                Start:
                for (i = matrix_size - 1; i >= 0; i--) {
                    if (adj_matrix[current.dfs_index][i] != -1) {
                        new_DFSobj = new DFS_DS(i, current.dfs_cost + 1, current.dfs_index);

                        //neew 
                        for (k = 0; k < dfs_stack.size(); k++) {
                            check = (DFS_DS) dfs_stack.get(k);
                            if (check.dfs_index == new_DFSobj.dfs_index) {
                                continue Start;

                            }

                        }
                        for (k = 0; k < dfs_closed.size(); k++) {
                            check = (DFS_DS) dfs_closed.get(k);
                            if (check.dfs_index == new_DFSobj.dfs_index) {
                                continue Start;
                            }
                        }

                        dfs_stack.add(new_DFSobj);

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
