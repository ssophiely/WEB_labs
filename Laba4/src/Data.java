import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class Data {
    private ArrayList<String> L1 = new ArrayList<>();
    private ArrayList<String> L2 = new ArrayList<>();

    public Data(String[] l1, String[] l2){
        Collections.addAll(L1, l1);
        Collections.addAll(L2, l2);
    }

    private void write_to_file(boolean f){
        try(FileWriter writer = new FileWriter("results.txt", false))
        {
            String s1 = String.join(", ", L1);
            String s2 = String.join(", ", L2);
            if (f){
                writer.write(s1 + "  ->  " + s2 + "  ->  L1 входит в L2");
            } else {
                writer.write(s1 + "  ->  " + s2 + "  ->  L1 не входит в L2");
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e);
        }
    }

    public boolean is_in_list(){
        ListIterator<String> p2 = L2.listIterator();
        while (p2.nextIndex()+L1.size()<=L2.size()){
            int ind=p2.nextIndex();
            if (L2.subList(ind, ind+L1.size()).equals(L1)){
                write_to_file(true);
                return true;
            }
            String el = p2.next();
        }
        write_to_file(false);
        return false;
    }
}
