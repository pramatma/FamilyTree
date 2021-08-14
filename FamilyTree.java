import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;

/*
@Author Pramatma Ram
@Website www.pramatma.com
 */
class Persion{

    private HashMap<String, List<Persion>> relations = null;
    private String name = null;
    //assuming names are unique, we can use ids in case duplicate

    Persion(){
        this.relations = new HashMap<>();
    }

    Persion(String name){
        this.relations = new HashMap<>();
        this.name = name;
    }

    //get persion name
    public String getName(){
        return this.name;
    }

    //add relation
    public void addRelation(String relationName) {
        if (!relations.containsKey(relationName)) {
            relations.put(relationName, new ArrayList<Persion>());
        }
    }
    public void updateRelations(String name, String relationName){
        if(!relations.containsKey(relationName)){
            List connectingpeople = new ArrayList<>();
            connectingpeople.add(new Persion(name));
            relations.put(relationName, connectingpeople);
        }else{
            List people = relations.get(relationName);
            people.add(new Persion(name));
            relations.put(relationName,people);
        }
    }

    //get count of son
    public int getCountofSon(){
        if(!relations.containsKey("son")){
            return 0;
        }
        else{
            return relations.get("son").size();
        }
    }

    public int getCountofDaughtor(){
        if(!relations.containsKey("daughtor")){
            return 0;
        }
        else{
            return relations.get("daughtor").size();
        }
    }

}

public class FamilyTree {
    
    //ArrayList used to store all persion details
    ArrayList<Persion> persions = new ArrayList<>();
    
    //adding new persion
    private void addPersion(String name){
        Persion persion = new Persion(name);
        persions.add(persion);
        System.out.println(name+"  added in family");
    }

    //add relation
    private void addRelation(String relationName){
        Persion persion = new Persion();
        persion.addRelation(relationName);
        System.out.println(relationName+"  added as relation");
    }
    //getCounOfSon
    private int getCountOfSon(String parentName){
        Persion persion = null;
        for(int i=0;i<persions.size();i++){
            //we can use other searching algorithms for optimization
            if(persions.get(i).getName().equals(parentName)){
                persion = persions.get(i);
                break;
            }
        }
        if(persion != null){
            return persion.getCountofSon();
        }
        else{
            System.out.println("No parent found");
            return 0;
        }
    }

    //get Count of Daughtor
    private int getCountOfDaughtor(String parentName){
        Persion persion = null;
        for(int i=0;i<persions.size();i++){
            //we can use other searching algorithms for optimization
            if(persions.get(i).getName().equals(parentName)){
                persion = persions.get(i);
                break;
            }
        }
        if(persion != null){
            return persion.getCountofDaughtor();
        }
        else{
            System.out.println("No parent found");
            return 0;
        }
    }
    private  void connectRelations(String name1, String name2, String relation){
        Persion persion2 = null;
        for(int i = 0;i<persions.size();i++){
            if(persions.get(i).getName().equals(name2)) {
                persion2 = persions.get(i);
                break;
            }
        }
        if(persion2 != null){
            persion2.updateRelations(name1,relation);
            if(!persions.contains(new Persion(name1))){
                persions.add(new Persion(name1));
            }
        }
        else{
            System.out.println(name2+"  not found");
        }
    }

    private void queryProcessing(String query){
        /*
          Query could be processed in efficient way using Tries but for simplification
          i'm using if-else beacuse set of input string is less
         */
        String[] queryArray = query.trim().split(" ");
        if(queryArray[0].equals("family-tree")){
            if(queryArray[1].equals("add") && queryArray[2].equals("relationship")){
                this.addRelation(queryArray[3]);
            }else if(queryArray[1].equals("add") && queryArray.length == 3){
                this.addPersion(queryArray[2]);
            }
            else if(queryArray[1].equals("connect")){
            this.connectRelations(queryArray[2], queryArray[6], queryArray[4]);
            }
            else if(queryArray[1].equals("count")){
                if(queryArray[2].equals("sons")){
                    System.out.println(this.getCountOfSon(queryArray[4]));
                }
                else{
                    System.out.println(this.getCountOfDaughtor(queryArray[5]));
                }
            }
            else{
                System.out.println("Wrong query");
            }
        }else{
            System.out.println("Please enter valid query string");
        }

    }

   public static void main(String[] args) {
        Main obj = new Main();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter your queries below on given formate");
            String query = sc.nextLine();
            obj.queryProcessing(query);
        }
        
    }
}

