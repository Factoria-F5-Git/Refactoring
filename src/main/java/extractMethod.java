import java.util.List;

// Refactoring 1. extract method
class Order {

    public List<Product> products;
    public User user;

    Order(List<Product> products, User user){
        this.products = products;
        this.user = user;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.quantity * product.price;
        }

        switch (user.country) {
            case "US":
                total *= 0.85;
                break;
            case "RU":
                total *= 0.75;
                break;
            case "CN":
                total *= 0.9;
                break;
        }

        return total;
    }
}

class Product {
    public Double quantity;
    public Double price;
}

//Refactoring 2. encapsulate field
class User {
    public String country;
}