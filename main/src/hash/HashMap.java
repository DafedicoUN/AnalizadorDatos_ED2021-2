package hash;

import java.util.ArrayList;

public class HashMap {

    private static ArrayList<Map> initList() {
        int max = 2048;
        ArrayList<Map> s = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            s.add(new Map());
        }
        return s;
    }

    ArrayList<Map> array = initList();

    public static int hash(String s) {
        int hash_value = 0;
        String space = " ";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' '){
                return hash_value;
            }
            hash_value += s.charAt(i);
        }
        return hash_value;
    }

    public void add(String ID, String emal){
        int hashValue = hash(ID);
        array.get(hashValue).add(ID, emal);
    }

    public String contains(String s){
        int hashValue = hash(s);
        return array.get(hashValue).contains(s);
    }

    public void clear(){
        array = initList();
    }

    public void delete(String s){
        int hashValue = hash(s);
        array.get(hashValue).delete(s);
    }

}
