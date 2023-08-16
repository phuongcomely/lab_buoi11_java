package service;

import entities.Book;
import entities.Reader;
import service.impl.IFunction;

import java.util.ArrayList;
import java.util.Scanner;

public class BookService implements IFunction{
    private Book book;
    private ArrayList<Book> books;
    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sách: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tiêu đề sách: ");
        String title = scanner.nextLine();
        System.out.printf("Tên tác giả: ");
        String author = scanner.nextLine();
        int quantity =0;
        try {
            System.out.println("Số lượng sách: ");
             quantity = Integer.parseInt(scanner.nextLine());
            if(quantity<0){
                System.out.println("số lượng sách phải lớn hơn 0!");
            }else {
                System.out.println("Thõa mãn");
            }
        }catch (Exception e){
            System.out.println("Lỗi dữ liệu: "+e.getMessage());

        }
        book = new Book(name, title, author,quantity );
        books.add(book);
        System.out.println("Thêm sách thành công");
    }

    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Nhập id người đọc cần xóa: ");
            int id = Integer.parseInt(scanner.nextLine());
            for(Book book1: books){
                if(book1.getId() == id){
                    books.remove(book1);
                    System.out.println("Xóa thành công!");
                    return;
                }
            }
        }catch (Exception e){
            System.out.println("Dữ liệu id lỗi " +e.getMessage());
        }
        books.remove(book);
    }

    @Override
    public void change() {
        Scanner scanner = new Scanner(System.in);

        try{
            int idChange= 0;
            do{
                System.out.println("Nhập id người đọc cần thay đổi thông tin.");
                idChange = Integer.parseInt(scanner.nextLine());
                for (Book book: books){
                    if(book.getId()==idChange){
                        System.out.println("=====NHẬP THÔNG TIN SỬA ĐỔI SÁCH===== ");
                        System.out.println("Nhập tên: ");
                        String newName = scanner.nextLine();
                        System.out.println("Nhập tiêu đề mới: ");
                        String newTitle = scanner.nextLine();
                        System.out.printf("Tên tác giả: ");
                        String newauthor = scanner.nextLine();
                        System.out.println("Số lượng sách: ");
                        int newQuatity = Integer.parseInt(scanner.nextLine());

                        book.setName(newName);
                        book.setTitleBook(newTitle);
                        book.setAuthor(newauthor);
                        book.setQuantity(newQuatity);

                    }

                }
            }while (idChange < books.size());
            System.out.println("id người đọc không tồn tại. Mời nhập lại! ");

        }catch (Exception e){
            System.out.println("Dữ liệu không hợp lệ");
        }
    }


}
