
import java.util.HashMap;
import java.util.HashSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AFTAB DUTTA
 */
public class Memoisation {
    public static HashMap<String, String> map=new HashMap<>();
    
    public static boolean validate(String id, String pass){
        if(!map.containsKey(id)){
            return false;
        }else{
            if(pass.equals(map.get(id))){
                return true;
            }
        }
        return false;
    }
    
    public static HashMap<String,String> leaveData=new HashMap<>();
    
    public static HashSet<String> applicants = new HashSet<>();
    
    public static HashMap<String,String> idName=new HashMap<>();
    
    public static String getName(String id){
        return idName.get(id);
    }
    
    public static String[] leave={"Casual Leaves","Sick Leaves","Maternity Leaves","Vacation Leaves","Marriage Leaves"};
    public static String getLeave(int index){
        return leave[index];
    }
    
    public static HashMap <String,Integer> status=new HashMap<>();
    public static int getStatus(String id){
        if(status.containsKey(id)){
            return status.get(id);
        }
        return 0;
    }
    
    
}
