
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
    
    
}
