package view;

import entities.Ticket;
import service.BookService;
import service.ReaderService;
import service.TicketService;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        ReaderService readerService = new ReaderService();
        BookService bookService = new BookService();
        TicketService ticketService = new TicketService();
        ArrayList<Ticket> tickets = new ArrayList<>();

        try{
            System.out.println(" Chọn Đối tượng cần quản lý 1: reader 2:book 3:ticker");
            int choose = Integer.parseInt(scanner.nextLine());
           switch (choose){
               case 1:
                    System.out.println("===== CHỌN CHỨC NĂNG CHO NGƯỜI ĐỌC =====");
                    System.out.println(" 1--- Thêm");
                    System.out.println(" 2--- Xóa");
                    System.out.println(" 3--- Sửa đổi");
                    System.out.println(" 4--- Tìm kiếm");
                    try{
                        System.out.println("Nhập lựa chọn của bạn: ");
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice){
                            case 1:
                                readerService.add();
                                break;
                            case 2:
                                readerService.delete();
                                break;
                            case 3:
                                readerService.change();
                                break;
                            case 4:
                                readerService.search();
                                break;
                            default:
                                System.out.println("Lựa chọn không phù hợp! Nhập lại!");
                                break;
                        }


                    }catch (Exception e){
                        System.out.println("Lỗi!" + e.getMessage());

                    }
                   break;

               case 2:
                   System.out.println("===== CHỌN CHỨC NĂNG CHO QUẢN LÝ SÁCH =====");
                   System.out.println(" 1--- Thêm");
                   System.out.println(" 2--- Xóa");
                   System.out.println(" 3--- Sửa đổi");
                    try{
                        System.out.println("Nhập lựa chọn: ");
                        int option = Integer.parseInt(scanner.nextLine());
                        switch (option){
                            case 1:
                                bookService.add();
                                break;
                            case 2:
                                bookService.delete();
                                break;
                            case 3:
                                bookService.change();
                                break;
                            default:
                                System.out.println("Lựa chọn ko phù hợp! Chọn lại!");
                                break;
                        }
                    }catch (Exception e){
                        System.out.println("Lỗi dữ liệu lựa chọn: "+e.getMessage());
                    }

               case 3:
                   System.out.println("===== CHỌN CHỨC NĂNG CHO QUẢN LÝ PHIẾU MƯỢN SÁCH =====");
                   System.out.println(" 1--- Tạo phiếu");
                   System.out.println(" 2--- Thêm vào ds phiếu mượn");
                   try {
                       System.out.println("Nhập lựa chọn: ");
                       int option = Integer.parseInt(scanner.nextLine());
                       switch (choose){
                           case 1:
                               ticketService.createTicket();
                               break;
                           case 2:
                               ticketService.createListTicket(tickets);
                               break;
                           default:
                               System.out.println("Chọn lại!");

                       }
                   }catch (Exception e){
                       System.out.println(e.getMessage());
                   }

            }

        }catch (Exception e){
            System.out.println("Lỗi dữ liệu " +e.getMessage());
        }

    }
}
