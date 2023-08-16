package entities;

public class Book {
    private static int autoId;
    private int id;
    private String name;
    private String titleBook;
    private String author;
    private int quantity;

    public Book(String name, String titleBook, String author, int quantity) {
        this.id = ++autoId;
        this.name = name;
        this.titleBook = titleBook;
        this.author = author;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", titleBook='" + titleBook + '\'' +
                ", author='" + author + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
