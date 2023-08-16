package service;

import entities.Book;
import entities.Reader;
import entities.Status;
import entities.Ticket;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TicketService {
    ArrayList<Reader> readers = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
    public Reader nameReader(Scanner scanner) {
        try {
            System.out.println("Nhập id người mượn sách");
            int idReader = Integer.parseInt(scanner.nextLine());

                for (Reader reader : readers) {
                    if (reader.getId() == idReader) {
                        return reader;

                    }
                }
            System.out.println("Id không tồn tại! Nhập lại!");

        } catch (Exception e) {
            System.out.println("Lỗi dữ liệu!" + e.getMessage());
        }
    return null;
    }
    public Book nameBook(Scanner scanner){
        try {
            System.out.println("Nhập id sách: ");
            int idBook = Integer.parseInt(scanner.nextLine());
                for(Book book: books){
                    if(book.getId()==idBook){
                        return book;
                    }
                }
            System.out.println("Id không tồn tại. Nhập lại!");

        }catch (Exception e){
            System.out.println("Lỗi dữ liệu: "+e.getMessage());
        }
    return  null;
    }


    public Status statusBorrow(Scanner scanner){

        while (true){

            try{
                System.out.println("===== Trạng thái mượn sách Y/N =====");
                String choose = scanner.nextLine();
                if(choose.equalsIgnoreCase("Y")){
                    return Status.BORROWING;
                }else if(choose.equalsIgnoreCase("N")) {
                    return Status.PAID;
                }else {
                    System.out.println("Không đúng! Nhập lại!");
                }

            }catch (Exception e){
                System.out.println("Dữ liệu lỗi");
            }

        }

    }
    public Ticket createTicket(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ngày mượn sách: ");
        String dateBorrow = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(dateBorrow, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("Ngày trả sách");
        LocalDate payDate = localDate.plusDays(7); //hạn trả sách sau 7 ngày

        return new Ticket(nameReader(scanner), nameBook(scanner), localDate, payDate, statusBorrow(scanner) );

    }
    public void createListTicket( ArrayList<Ticket> tickets){
        tickets.add(createTicket());

    }


}
