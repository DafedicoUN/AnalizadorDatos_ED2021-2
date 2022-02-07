package hash;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.compare;

public class HashSet {

    private static ArrayList<Set> initList() {
        ArrayList<Set> s = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            s.add(new Set()); // or null, but this can cause some problems ... (try to find an empty representation for an "activity" instance)
        }
        return s;
    }

    ArrayList<Set> array = initList();

    public int hash(String s) {
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

    public void add(String s){
        int hashValue = hash(s);
        array.get(hashValue).add(s);
    }

    public void contains(String s){
        int hashValue = hash(s);
        System.out.println(array.get(hashValue).contains(s));
    }
}



