package service;

import entities.Reader;
import service.impl.IFunction;
import service.impl.ISearch;

import java.util.ArrayList;
import java.util.Scanner;

public class ReaderService implements IFunction, ISearch{

    private Reader reader;
    private ArrayList<Reader> readers;

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên người đọc: ");
        String name = scanner.nextLine();
        int number = 0;
        try {
            System.out.println("Nhập số điện thoại người đọc: ");
            number = Integer.parseInt(scanner.nextLine());

        }catch (Exception e){
            System.out.println("Lỗi dữ liệu số điện thoại! "+e.getMessage());
        }
        System.out.println("Địa chỉ người đọc: ");
        String address = scanner.nextLine();
        reader = new Reader(name, number, address);
        readers.add(reader);
    }

    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Nhập id người đọc cần xóa: ");
            int id = Integer.parseInt(scanner.nextLine());
            for(Reader reader1: readers){
                if(reader1.getId() == id){
                    readers.remove(reader1);
                    System.out.println("Xóa thành công!");
                    return;
                }
            }
        }catch (Exception e){
            System.out.println("Dữ liệu id lỗi " +e.getMessage());
        }
    }

    @Override
    public void change() {
        Scanner scanner = new Scanner(System.in);

        try{
            int idSearch = 0;
            do{
                System.out.println("Nhập id người đọc cần thay đổi thông tin.");
                idSearch = Integer.parseInt(scanner.nextLine());
                for (Reader reader: readers){
                    if(reader.getId()==idSearch){
                        System.out.println("NHẬP THÔNG TIN SỬA ĐỔI: ");
                        System.out.println("Nhập tên: ");
                        String newName = scanner.nextLine();
                        System.out.println("Nhập Số điện thoại: ");
                        int newNumber = Integer.parseInt(scanner.nextLine());
                        System.out.println("Nhập địa chỉ: ");
                        String newAddress = scanner.nextLine();

                        reader.setName(newName);
                        reader.setNumberPhone(newNumber);
                        reader.setAddress(newAddress);
                        System.out.println("Sửa đổi thông tin người đọc thành công!");
                    }

                }
            }while (idSearch < readers.size());
            System.out.println("id người đọc không tồn tại. Mời nhập lại! ");

        }catch (Exception e){
            System.out.println("Dữ liệu không hợp lệ");
        }

    }


    @Override
    public void search() {
        Scanner scanner = new Scanner(System.in);


        try{
            int idSearch = 0;
            do{
                System.out.println("Nhập id người đọc cần tìm kiếm thông tin.");
                idSearch = Integer.parseInt(scanner.nextLine());
                for (Reader reader1: readers){
                    if(reader1.getId()==idSearch){
                        System.out.println(reader.toString());
                    }
                }
            }while (idSearch < readers.size());
            System.out.println("id người đọc không tồn tại!");

        }catch (Exception e){
            System.out.println("Dữ liệu không hợp lệ");
        }

    }
}
