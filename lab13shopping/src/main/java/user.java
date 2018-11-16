public class user {
    private String name;
    private String password;
    private shoppingcart shoppingcart;
 public user(String name,String password)
 {
     this.name=name;
     this.password=password;

 }

    public String getPassword()
    {
        return this.password;
    }
 public String getName()
 {
     return this.name;
 }

    public shoppingcart getShoppingcart() {
        return shoppingcart;
    }

    public void setShoppingcart(shoppingcart shoppingcart) {
        this.shoppingcart = shoppingcart;
    }
    public void AddCart(shoppingcart shoppingcart){
     this.shoppingcart= shoppingcart;
    }
}
