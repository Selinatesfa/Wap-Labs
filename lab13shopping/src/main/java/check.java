import java.util.HashMap;
import java.util.Map;

public class check {

 public    check(){
     user newuser1= new user("selina","1111");
     user newuser2= new user("feven","2222");
     user newuser3= new user("eskem","3333");
     user newuser4= new user("feruz","4444");
     map.put(newuser1.getName(),newuser1);
     map.put(newuser2.getName(),newuser2);
     map.put(newuser3.getName(),newuser3);
     map.put(newuser4.getName(),newuser4);
    }
   private   Map<String,user> map= new HashMap<>();
     public   check(user user1)
    {
        user newuser= new user("selina","123");
        map.put(newuser.getName(),newuser);
      map.put(user1.getName(),user1);
    }

    public  boolean validate(String name,String password){
        for (user ur: map.values()){
            if(ur.getName().equals(name) && ur.getPassword().equals(password)){
                return true;            }
        }
      return false;
    }
}
