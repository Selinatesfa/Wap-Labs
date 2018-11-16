import java.util.ArrayList;
import java.util.List;

public class shoppingcart {
    private   List<product> products=new ArrayList<>();
    public shoppingcart(){
           }
    public List<product> getProducts() {
        return products;
    }

    public void setProducts(List<product> products) {
        this.products = products;
    }
    public void AddProduct(product product)
    {
        products.add(product);
    }
}
