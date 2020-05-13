import java.util.List;

class Order {

    private List<Product> products;
    private User user;

    Order(List<Product> products, User user){
        this.products = products;
        this.user = user;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.quantity * product.price;
        }

        // Apply regional discounts.
        switch (user.getCountry()) {
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

    Double quantity;
    Double price;

    Product(Double quantity, Double price){
        this.quantity = quantity;
        this.price = price;
    }
}

class User {

    private String country;

    // what is the advantage of this getter?
    public String getCountry(){
        return country;
    }

    User(String country){
        this.country = country;
    }
}