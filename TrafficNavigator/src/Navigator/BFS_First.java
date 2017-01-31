/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Navigator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author puneetkoul
 */
public class BFS_First extends navigate {

    BFS_First(int source) {

        List bfs_queue = new ArrayList();
        List bfs_print = new ArrayList();
        List bfs_final_queue = new ArrayList();
        Object value;
        int i, k, final_queue_size;
        int bfs_dest = map.get(destination);
        BFS_DS bfs_obj = new BFS_DS(source, 0, 0);
        BFS_DS current, new_BFSobj, print_bfs_temp, check;
        bfs_queue.add(bfs_obj);

        while (!(bfs_queue.isEmpty())) {

            current = (BFS_DS) bfs_queue.remove(0);
            bfs_final_queue.add(current);

            if (current.bfs_index == bfs_dest) {

                final_queue_size = bfs_final_queue.size();
                final_queue_size = final_queue_size - 1;

                print_next:
                while (final_queue_size != 0) {
                    print_bfs_temp = (BFS_DS) bfs_final_queue.get(final_queue_size);
                    bfs_print.add(print_bfs_temp);

                    for (k = 0; k < bfs_final_queue.size(); k++) {
                        check = (BFS_DS) bfs_final_queue.get(k);
                        if (print_bfs_temp.bfs_prev_index == check.bfs_index) { //System.out.println("Value: "+print_bfs_temp.cost);
                            final_queue_size = k;
                            continue print_next;
                        }

                    }

                }
                System.out.print(getKeyFromValue(source));
                System.out.print(" ");
                System.out.println("0");

                for (i = bfs_print.size() - 1; i >= 0; i--) {
                    print_bfs_temp = (BFS_DS) bfs_print.get(i);
                    System.out.print(getKeyFromValue(print_bfs_temp.bfs_index));  // New Change
                    System.out.print(" ");      //NC
                    System.out.println(print_bfs_temp.cost);
                }

                System.exit(0);
                //Goal State reached
            } else {
                Start:
                for (i = 0; i < matrix_size; i++) {
                    if (adj_matrix[current.bfs_index][i] != -1) {
                        new_BFSobj = new BFS_DS(i, current.cost + 1, current.bfs_index);

                        for (k = 0; k < bfs_queue.size(); k++) {
                            check = (BFS_DS) bfs_queue.get(k);
                            if (check.bfs_index == new_BFSobj.bfs_index) {
                                continue Start;

                            }

                        }
                        for (k = 0; k < bfs_final_queue.size(); k++) {
                            check = (BFS_DS) bfs_final_queue.get(k);
                            if (check.bfs_index == new_BFSobj.bfs_index) {
                                continue Start;
                            }

                        }

                        bfs_queue.add(new_BFSobj);
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
