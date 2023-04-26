import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    Input in = new Input();
    private final List<Student> students = ReadWriteFile.getInstance().readFile();

    public StudentManager() {
    }


    public void addStudent(Student student) {
        boolean check = true;
        if (student.getAverage() >= 0 && student.getAverage() <= 10 && student.getId() > 0) {
            for (Student student1 : students) {
                if (student1.getId() == student.getId()) {
                    System.err.println("Id đã tồn tại!");
                    check = false;
                    return;
                }
            }
            if (check) {
                students.add(student);
                ReadWriteFile.getInstance().writeFile(students);
            }


        } else if (student.getAverage() < 0 && student.getAverage() > 10) {
            System.err.println("Điểm không hợp lệ!");
        } else {
            System.err.println("Id không hợp lệ!");
        }

    }


    public void getStudentById(int id) {
        boolean check = false;
        System.out.printf("%-5s %-20s %-15s %-15s %-15s %-15s %-15s\n",
                "Id" , "Tên", "Giới tính", "Tên lớp","Email", "Địa chỉ", "GPA" );
        for (Student student : students) {
            if (id == student.getId()) {
                System.out.println(student);
                check = true;
            }
        }
        if (!check) {
            System.err.println("Id không tồn tại!");
        }

    }

    public void getStudentByName(String name) {
        students.sort(new SortStudentById());
        boolean check = false;
        System.out.printf("%-5s %-20s %-15s %-15s %-15s %-15s %-15s\n",
                "Id" , "Tên", "Giới tính", "Tên lớp","Email", "Địa chỉ", "GPA" );
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(student);
                check = true;
            }
        }
        if (!check) {
            System.err.println("Tên không tồn tại!");
        }
    }

    public void getStudentByClass(String className) {
        students.sort(new SortStudentById());
        boolean check = false;
        System.out.printf("%-5s %-20s %-15s %-15s %-15s %-15s %-15s\n",
                "Id" , "Tên", "Giới tính", "Tên lớp","Email", "Địa chỉ", "GPA" );
        for (Student student : students) {
            if (student.getClassName().toLowerCase().contains(className.toLowerCase())) {
                System.out.println(student);
                check = true;
            }
        }
        if (!check) {
            System.err.println("Lớp không tồn tại!");
        }
    }

    public void getStudentByGender(String gender) {
        students.sort(new SortStudentById());
        boolean check = false;
        System.out.printf("%-5s %-20s %-15s %-15s %-15s %-15s %-15s\n",
                "Id" , "Tên", "Giới tính", "Tên lớp","Email", "Địa chỉ", "GPA" );
        for (Student student : students) {
            if (student.getGender().equalsIgnoreCase(gender)) {
                System.out.println(student);
                check = true;

            }
        }
        if (!check) {
            System.err.println("Giới tính không tồn tại!");
        }
    }


    public void updateStudentById(int id) {
        boolean check = false;
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).getId()) {
                index = i;
                check = true;
            }
        }
        if (!check) {
            System.err.println("Id không tồn tại!");
            return;
        }
        do {
            System.out.printf("%-5s %-20s %-15s %-15s %-15s %-15s %-15s\n",
                    "Id" , "Tên", "Giới tính", "Tên lớp","Email", "Địa chỉ", "GPA" );
            System.out.println(students.get(index));
            System.out.println("------------------------------");
            System.out.println("1. Sửa id.                    |");
            System.out.println("2. Sửa tên.                   |");
            System.out.println("3. Sửa giới tính.             |");
            System.out.println("4. Sửa tên lớp.               |");
            System.out.println("5. Sửa email.                 |");
            System.out.println("6. Sửa địa chỉ.               |");
            System.out.println("7. Sửa điểm trung bình.       |");
            System.out.println("8. Sửa toàn bộ thông tin.     |");
            System.out.println("0. Quay lại menu hoặc thoát   |");
            System.out.println("------------------------------");

            int choice = Menu.getValidChoice(0, 8);
            switch (choice) {
                case 1:
                    System.out.println("Nhập id:");
                    int newId = new Scanner(System.in).nextInt();
                    boolean checkId = in.checkId(newId);
                    if (checkId) {
                        do {
                            System.out.println("Id đã tồn tại! Mời bạn nhập lại id:");
                            int ID = new Scanner(System.in).nextInt();
                            checkId = in.checkId(ID);
                            if (!checkId) {
                                newId = ID;
                            }
                        }while (checkId);

                    }
                    students.get(index).setId(newId);
                    break;
                case 2:
                    students.get(index).setName(in.getName());
                    break;
                case 3:
                    students.get(index).setGender(in.getGender());
                    break;
                case 4:
                    students.get(index).setClassName(in.getClassName());
                    break;
                case 5:
                    students.get(index).setEmail(in.getEmail());
                    break;
                case 6:
                    students.get(index).setAddress(in.getAddress());
                    break;
                case 7:
                    students.get(index).setAverage(in.getAverage());
                    break;
                case 8:
                    students.set(index, in.getNewStudent());
                    break;
                case 0:
                    return;
            }
        } while (true);

    }


    public void deleteStudentById(int id) {
        boolean check = false;
        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).getId()) {
                students.remove(students.get(i));
                check = true;
            }
        }
        if (!check) {
            System.err.println("Id không tồn tại!");
        }
    }


    public void showStudent() {
        students.sort(new SortStudentById());
        System.out.printf("%-5s %-20s %-15s %-15s %-15s %-15s %-15s\n",
                "Id" , "Tên", "Giới tính", "Tên lớp","Email", "Địa chỉ", "GPA" );
        students.forEach(System.out::println);
    }


    public void above8() {
        students.sort(new SortStudentById());
        System.out.printf("%-5s %-20s %-15s %-15s %-15s %-15s %-15s\n",
                "Id" , "Tên", "Giới tính", "Tên lớp","Email", "Địa chỉ", "GPA" );
        students.stream().filter(student -> student.getAverage() > 8).forEach(System.out::println);
    }

    public void above65() {
        students.sort(new SortStudentById());
        System.out.printf("%-5s %-20s %-15s %-15s %-15s %-15s %-15s\n",
                "Id" , "Tên", "Giới tính", "Tên lớp","Email", "Địa chỉ", "GPA" );
        students.stream().filter(student -> student.getAverage() <= 8 && student.getAverage() >= 6.5).forEach(System.out::println);
    }

    public void above5() {
        students.sort(new SortStudentById());
        System.out.printf("%-5s %-20s %-15s %-15s %-15s %-15s %-15s\n",
                "Id" , "Tên", "Giới tính", "Tên lớp","Email", "Địa chỉ", "GPA" );
        students.stream().filter(student -> student.getAverage() <= 6.5 && student.getAverage() >= 5).forEach(System.out::println);
    }

    public void under5() {
        students.sort(new SortStudentById());
        System.out.printf("%-5s %-20s %-15s %-15s %-15s %-15s %-15s\n",
                "Id" , "Tên", "Giới tính", "Tên lớp","Email", "Địa chỉ", "GPA" );
        students.stream().filter(student -> student.getAverage() < 5).forEach(System.out::println);
    }

    public void sortStudentByAverage() {
        System.out.printf("%-5s %-20s %-15s %-15s %-15s %-15s %-15s\n",
                "Id" , "Tên", "Giới tính", "Tên lớp","Email", "Địa chỉ", "GPA" );
        students.sort(new SortStudentByAverage());
        students.forEach(System.out::println);
    }

    public void sortStudentByName() {
        System.out.printf("%-5s %-20s %-15s %-15s %-15s %-15s %-15s\n",
                "Id" , "Tên", "Giới tính", "Tên lớp","Email", "Địa chỉ", "GPA" );
        students.sort(new SortStudentByName());
        students.forEach(System.out::println);
    }
}


