import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.*;
public class test{
  //todo: change scanner with argparse, should be faster
  static void clientOpener() {
    Boolean run=true;
    String address =" https://www.fandango.com";
    Scanner scan = new Scanner(System.in);
    while(run){
    System.out.print("search by zip or by city (z/c): ");
    String answer = scan.next();
    System.out.println(answer);
    if(answer.equals("z")){
        System.out.print("insert zipcode: ");
        String zip = scan.next();
        address+="/"+zip+"_movietimes?q="+zip;
        run =false;
    }
    else if (answer.equals("c")){
        System.out.print("insert city: ");

        String city = scan.next();
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(city);
        boolean found = matcher.find();
        System.out.println(city);

        if(found){

          city = city.replaceAll("\\s","+");
        }
        address= address+"/"+city+"_ca_movietimes"; //can change the last part of the address based on what state your in
        // im just assuming im using this in california for now
        run = false;
    }
    else{System.out.println("invalid input try again");}}
    try{
      Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome"+address});
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }

  //public static void main(String[] args){
    //clientOpener();
  //}
}
