/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Navigator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 *
 * @author puneetkoul
 */
public class navigate {

    static HashMap<String, Integer> map = new HashMap<>();
    static HashMap<String, Integer> stl_dist_map = new HashMap<>();
    static int[][] adj_matrix;
    static int traffic_lines;
    static String start;
    static String destination;
    static int distance = 0;
    static int matrix_size;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("input.txt"));            //Reading the input
        //PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        //System.setOut(out);
        List input = new ArrayList();
        //while(sc.hasNextLine())
        int i, j, k;
        String s;
        for (i = 0; i < 4; i++) {
            s = sc.nextLine();
            input.add(s);
            //System.out.println(s);
        }
        String algorithm = (String) input.get(0);                    //Storing algorithm type
        start = (String) input.get(1);                        //Storing Source
        destination = (String) input.get(2);                  //Storing Destination
        traffic_lines = Integer.valueOf((String) input.get(3));//Traffic Lines

        String[] temp;
        int map_key = 0;
        int col, row;
        for (k = 0; k < traffic_lines; k++) {
            s = sc.nextLine();
            input.add(s);
            temp = s.split("\\s+");

            if (map.get(temp[0]) == null) {
                map.put(temp[0], map_key++);
            }

            if (map.get(temp[1]) == null) {
                map.put(temp[1], map_key++);
            }
        }

        String straight_lines = sc.nextLine();
        int stl_lines = Integer.valueOf(straight_lines);
        int stl_distance;
        String location;
        for (i = 0; i < stl_lines; i++) {
            s = sc.nextLine();
            temp = s.split("\\s+");
            location = temp[0];
            stl_distance = Integer.valueOf(temp[1]);
            stl_dist_map.put(location, stl_distance);
        }

        int time_taken;
        matrix_size = map.size();
        adj_matrix = new int[matrix_size][matrix_size];
        for (i = 0; i < matrix_size; i++) {
            for (j = 0; j < matrix_size; j++) {
                adj_matrix[i][j] = -1;
            }
        }

        for (k = 4; k < input.size(); k++) {
            s = (String) input.get(k);

            temp = s.split("\\s+");
            row = map.get(temp[0]);
            col = map.get(temp[1]);

            time_taken = Integer.valueOf(temp[2]);
            adj_matrix[row][col] = time_taken;

        }

        //Graph creation ends
        ///////////////////////////////////
        String temp1 = algorithm;
        int source1 = map.get(start);
        //System.out.println("Start "+source1);

        switch (algorithm) {
            case "BFS":
                new BFS_First(source1);
                break;
            case "DFS":
                new DFS_Second(source1);
                break;
            case "UCS":
                new UCS_First(source1);
                break;
            case "A*":
                new A_Star(source1);
                break;
            default:
                System.out.println("Invalid algorithm");
                break;
        }

    }
}
