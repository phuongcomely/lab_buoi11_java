package entities;

import java.time.LocalDate;
import java.util.Date;

public class Ticket {
    private Reader reader;
    private Book book;
    private LocalDate borrowedDate;
    private LocalDate payDate;
    private Status status;

    public Ticket(Reader reader, Book book, LocalDate borrowedDate, LocalDate payDate, Status status) {
        this.reader = reader;
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.payDate = payDate;
        this.status = status;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "reader=" + reader +
                ", book=" + book +
                ", borrowedDate=" + borrowedDate +
                ", payDate=" + payDate +
                ", status=" + status +
                '}';
    }
}
