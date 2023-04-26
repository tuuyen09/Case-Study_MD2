import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private final List<Student> students;
    ValidEmail validEmail = new ValidEmail();

    public Input() {
        students = ReadWriteFile.getInstance().readFile();
    }

    public Student getNewStudent() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập id: ");
        int id = input.nextInt();
        boolean check = checkId(id);
        if (check) {
            do {
                System.out.println("Id đã tồn tại! Mời bạn nhập lại id:");
                int newId = new Scanner(System.in).nextInt();
                check = checkId(newId);
                if (!check) {
                    id = newId;
                }
            } while (check);
        }
        Scanner input1 = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name = input1.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Nhập giới tính: Nam/Nữ ");
        String gender = input2.nextLine();
        boolean checkGender = getValidGenger(gender);
        if (!checkGender){
            do {
                System.out.println("Giới tính không hợp lệ! Mời bạn nhập lại giới tính:");
                String newGender = new Scanner(System.in).nextLine();
                checkGender = getValidGenger(newGender);
                if (checkGender){
                    gender = newGender;
                }
            } while (!checkGender);
        }
        Scanner input3 = new Scanner(System.in);
        System.out.println("Nhập tên lớp: ");
        String className = input3.nextLine();
        Scanner input4 = new Scanner(System.in);
        System.out.println("Nhập email: ");
        String email = input4.nextLine();
        boolean result = validEmail.validate(email);
        if (!result) {
            do {
                System.out.println("Nhập email đúng định dạng: ");
                String correct = new Scanner(System.in).nextLine();
                result = validEmail.validate(correct);
                if (result) {
                    email = correct;
                }
            } while (!result);
        }
        Scanner input5 = new Scanner(System.in);
        System.out.println("Nhập địa chỉ: ");
        String add = input5.nextLine();
        Scanner input6 = new Scanner(System.in);
        System.out.println("Nhâp điểm trung bình: ");
        double aver = input6.nextDouble();


        Student student = new Student(id, name, gender, className, email, add, aver);
        return student;
    }

    public int getId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập id: ");
        int id = input.nextInt();
        return id;
    }

    public String getClassName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên lớp: ");
        String cn = input.nextLine();
        return cn;
    }

    public String getGender() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập giới tính: Nam/Nữ ");
        String gender = input.nextLine();
        return gender;
    }

    public String getName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name = input.nextLine();
        return name;
    }

    public String getAddress() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập địa chỉ: ");
        String add = input.nextLine();
        return add;
    }

    public String getEmail() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập email: ");
        String email = input.nextLine();
        return email;
    }

    public double getAverage() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập điểm trung bình: ");
        double aver = input.nextDouble();
        return aver;
    }

    public boolean checkId(int id){
        boolean check = false;
        for (Student student : students){
            if (student.getId() == id) {
                check = true;
                break;
            }
        }
        return check;
    }
    public boolean getValidGenger (String gender){
        boolean check = false;
        if (gender.equalsIgnoreCase("nam") || gender.equalsIgnoreCase("nữ") ){
            check = true;
        }
        return check;
    }
}
