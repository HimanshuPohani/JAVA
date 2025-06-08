
public class Book {
    private String title;
    private String author;
    private double price;

    private static int bookCount = 0;

    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        bookCount++;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        bookCount++;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    
    public void applyDiscount(double discountPercentage) {
        if (discountPercentage >= 0 && discountPercentage <= 100) {
            price -= (price * discountPercentage / 100);
        }
    }

  
    public static int getBookCount() {
        return bookCount;
    }

 
    public static void main(String[] args) {
      
        Book book1 = new Book("Atomic Habits", "James Clear", 500);
        Book book2 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki", 400);

       
        Book book3 = new Book();

       
        book1.applyDiscount(10); 
        book2.applyDiscount(5);  

        
        System.out.println("Book 1: " + book1.getTitle() + ", Price after discount: ₹" + book1.getPrice());
        System.out.println("Book 2: " + book2.getTitle() + ", Price after discount: ₹" + book2.getPrice());
        System.out.println("Book 3: " + book3.getTitle() + ", Price: ₹" + book3.getPrice());

       
        System.out.println("Total number of books created: " + Book.getBookCount());
        
    }
}
