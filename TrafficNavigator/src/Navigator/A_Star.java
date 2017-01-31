/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Navigator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author puneetkoul
 */
class A_Star extends navigate {

    public A_Star(int source) {
         List A_open=new ArrayList();
         List A_print = new ArrayList();
         List A_closed=new ArrayList();
       
        Object value;
        String current_loc;
        int i,l,k,flag,m,z;
        int A_dest=map.get(destination);
        current_loc=(String) getKeyFromValue(source);
        A_Star_DS A_obj = new A_Star_DS(source,stl_dist_map.get(current_loc),0,0);
        A_Star_DS current,new_obj,check,print_temp,temp1;
        A_open.add(A_obj);
        
        while(!(A_open.isEmpty()))
        {
        current=(A_Star_DS) A_open.remove(0);
        A_closed.add(current);
        
        if(current.index==A_dest)
        {   
             l=A_closed.size();
             l=l-1;
            print_next: while(l!=0)
          {
              print_temp=(A_Star_DS) A_closed.get(l);
              A_print.add(print_temp);
              
              // Obtaining parents for printing
              for(k=0;k<A_closed.size();k++)
                            { check=(A_Star_DS) A_closed.get(k);
                               if (print_temp.prev_index == check.index)
                               {
                                 l=k;
                                 continue print_next;
                               }
                                
                            }
                
          }
        
          
            System.out.print(getKeyFromValue(source));
            System.out.println(" 0");
            
            for (i=A_print.size()-1;i>=0;i--)
            {  print_temp= (A_Star_DS) A_print.get(i);
              System.out.print(getKeyFromValue(print_temp.index));  // New Change
              System.out.print(" ");      //NC
              System.out.println(print_temp.prev_cost);
            }
            
            System.exit(0);
         
        }
        
        else   // when current doesnt have destination
        
        {  //flag=0;
        for(i=0;i<matrix_size;i++)
            { flag=0;  
                if (adj_matrix[current.index][i]!=-1)
                        {   
                            value=i;
                            current_loc=(String) getKeyFromValue(value);
                            //stl_dist_map contains straight line distance mapping
                            new_obj=new A_Star_DS(i,adj_matrix[current.index][i]+ stl_dist_map.get(current_loc)+current.prev_cost,adj_matrix[current.index][i]+current.prev_cost,current.index);
                            
                            // Checking if new object is already in open queue
                            if (flag == 0)
                            {
                            for(k=0;k<A_open.size();k++)
                            {  check = (A_Star_DS) A_open.get(k);
                               if (check.index == new_obj.index)
                               {
                                   if(new_obj.cost < check.cost )
                               {
                                A_open.remove(k);
                                A_open.add(new_obj);
                                Collections.sort(A_open, new A_Star_distance_comparator());
                                //flag=1;
                               }
                                flag=1;
                               }
                                
                            }
                            }

                            //checking if new obj is already in the closed queue
                            
                            if (flag == 0)
                            { 
                            for(k=0;k<A_closed.size();k++)
                            {  check = (A_Star_DS) A_closed.get(k);
                               if (check.index == new_obj.index)
                               {
                                   if(new_obj.cost < check.cost)
                                   {
                                       //Result Check
                                   //System.out.println("Less Value found in closed queue for "+getKeyFromValue(new_obj.index));
                                   //Result Check
                                       
                                      A_closed.remove(k);
                                      A_open.add(new_obj);
                                      Collections.sort(A_open, new A_Star_distance_comparator());
                                      
                                   }
                                 flag=1;
                               }
                                
                            }
                            }
                            // if above two conditions are not met
                            if(flag==0)
                            { 
                            A_open.add(new_obj);
                            Collections.sort(A_open, new A_Star_distance_comparator());
                            }
                         
                            
                            
                        }
            }
        
        }
        
        }
        
        
        }
        
    // Getting value to key mapping from hasmap
    public static Object getKeyFromValue(Object value_temp) {
      for (Object o : map.keySet()) {
      if (map.get(o).equals(value_temp)) {
        return o;
      }
    }
    return null;
        
        
    }
    
    
    
}
