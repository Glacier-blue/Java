

public class Book {
    private String name;//书名
    private String author;//作者
    private Double price;//价格
    private String state;

    public Book(String name, String author, Double price,String state) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.state=state;
    }





    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", state='" + state + '\'' +
                '}';
    }
}