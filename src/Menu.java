import java.util.Scanner;

public class Menu {
    StudentManager studentManager = new StudentManager();
    Input in = new Input();

    public void menu() {

        int choice;
        do {
            displayMenu();

            choice = getValidChoice(0, 6);

            switch (choice) {
                case 1:
                    studentManager.addStudent(in.getNewStudent());
                    break;
                case 2:
                    studentManager.updateStudentById(in.getId());
                    break;
                case 3:
                    studentManager.deleteStudentById(in.getId());
                    break;
                case 4:
                    studentManager.showStudent();
                    break;
                case 5:
                    displayStudent();
                    break;
                case 6:
                    displaySortStudent();
                    break;
                case 0:
                    System.exit(0);
            }
            returnOrExit();
        } while (true);
    }

    public void displayMenu() {
        System.out.println("---------QUẢN LÝ HỌC VIÊN TẠI CODEGYM---------");
        System.out.println("1. Thêm thông tin học viên.                   |");
        System.out.println("2. Sửa thông tin học viên theo id.            |");
        System.out.println("3. Xoá học viên theo id.                      |");
        System.out.println("4. Hiển thị học viên toàn bộ học viên.        |");
        System.out.println("5. Tìm kiếm học viên.                         |");
        System.out.println("6. Sắp xếp học viên.                          |");
        System.out.println("0. Thoát.                                     |");
        System.out.println("----------------------------------------------");
    }

    public void displayStudent() {
        do {
            System.out.println("-----------------------------------------");
            System.out.println("1. Theo id.                              |");
            System.out.println("2. Theo tên.                             |");
            System.out.println("3. Theo giới tính.                       |");
            System.out.println("4. Theo lớp.                             |");
            System.out.println("5. Có điểm trung bình trên 8.            |");
            System.out.println("6. Có điểm trung bình từ 6.5 đến 8.      |");
            System.out.println("7. Có điểm trung bình từ 5 đến 6.5.      |");
            System.out.println("8. Có điểm trung bình dưới 5.            |");
            System.out.println("0. Quay lại menu hoặc thoát.             |");
            System.out.println("-----------------------------------------");
            int choice = getValidChoice(0, 8);
            switch (choice) {
                case 1:
                    studentManager.getStudentById(in.getId());
                    break;
                case 2:
                    studentManager.getStudentByName(in.getName());
                    break;
                case 3:
                    studentManager.getStudentByGender(in.getGender());
                    break;
                case 4:
                    studentManager.getStudentByClass(in.getClassName());
                    break;
                case 5:
                    studentManager.above8();
                    break;
                case 6:
                    studentManager.above65();
                    break;
                case 7:
                    studentManager.above5();
                    break;
                case 8:
                    studentManager.under5();
                    break;
                case 0:
                    do {
                        System.out.println("0. Quay lại menu.");
                        System.out.println("1. Thoát.");
                        int input = getValidChoice(0, 1);
                        switch (input){
                            case 0:
                                menu();
                                break;
                            case 1:
                                System.exit(1);
                        }
                    }while (true);
            }

        } while (true);
    }

    public void displaySortStudent() {
        do {
            System.out.println("---------------------------------------------------");
            System.out.println("1. Sắp xếp học viên theo điểm trung bình tăng dần. |");
            System.out.println("2. Sắp xếp học viên theo tên.                      |");
            System.out.println("0. Quay lại menu hoặc thoát                        |");
            System.out.println("---------------------------------------------------");
            int choice = getValidChoice(0, 2);
            switch (choice) {
                case 1:
                    studentManager.sortStudentByAverage();
                    break;
                case 2:
                    studentManager.sortStudentByName();
                    break;
                case 0:
                    do {
                        System.out.println("0. Quay lại menu.");
                        System.out.println("1. Thoát.");
                        int input1 = getValidChoice(0, 1);
                        switch (input1){
                            case 0:
                                menu();
                                break;
                            case 1:
                                System.exit(1);
                        }
                    }while (true);
            }
        } while (true);
    }


    public static void returnOrExit() {
        do {
            System.out.println("0. Quay lại menu.");
            System.out.println("1. Thoát.");
            int input = getValidChoice(0, 1);
            switch (input) {
                case 0:
                    return;
                case 1:
                    System.exit(1);
            }
        } while (true);
    }

    public static int getValidChoice(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Nhập lựa chọn của bạn: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    scanner.nextLine();
                    return choice;
                }
            }
            System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại! ");
            scanner.nextLine();
        }


    }

}
