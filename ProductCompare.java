package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Product
{
    String name;
    String category;
    double price;
    double rating;

    public Product(String name, String category, double price, double rating) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}

class ProdctCategoryComparator implements Comparator<Product>
{
    @Override
    public int compare(Product o1, Product o2)
    {
        return o1.getCategory().compareTo(o2.getCategory());
    }
}
class RatingCompartor implements Comparator<Product>
{
    @Override
    public int compare(Product o1, Product o2)
    {
        //return Double.compare(o1.getRating(), o2.getRating()) ;// ascending
        return Double.compare(o2.getRating(), o1.getRating()); //descending
    }
}
class PriceCompartor implements Comparator<Product>
{
    @Override
    public int compare(Product o1, Product o2)
    {
        //return Double.compare(o1.getPrice(), o2.getPrice()); // ascending
        return Double.compare(o2.getPrice() , o1.getPrice());// descending
    }
}
class ChainedComparator implements Comparator<Product>{

    List<Comparator<Product>> chainedComparator ;
    @SafeVarargs
    public ChainedComparator(Comparator<Product> ... comparators)
    {
        chainedComparator = Arrays.asList(comparators);
    }

    @Override
    public int compare(Product o1, Product o2)
    {
        for(Comparator<Product> comparator : chainedComparator)
        {
            int result = comparator.compare(o1,o2);
            if(result != 0)
                return result;
        }
        return 0;
    }
}
public class ProductCompare {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>(List.of(
                new Product("iPhone 14", "Electronics", 799.99, 4.5),
                new Product("Samsung Galaxy S23", "Electronics", 749.99, 4.5),
                new Product("Dell XPS 13", "Computers", 999.99, 4.6),
                new Product("Apple Watch", "Wearables", 399.99, 4.8),
                new Product("Sony WH-1000XM5", "Audio", 349.99, 4.9)
        ));

        Comparator<Product> comparator = Comparator.comparing(Product::getCategory)
                .thenComparing(Product::getRating).reversed()
                .thenComparing(Product:: getPrice);

        //products.sort(comparator);
//        for(Product p :products)
//        {
//            System.out.println(p);
//        }
        ChainedComparator chainedComparator = new ChainedComparator(
                new ProdctCategoryComparator(),
                new RatingCompartor(),
                new PriceCompartor()
        );
        products.sort(chainedComparator);
        for(Product p :products)
        {
            System.out.println(p);
        }
    }
}
