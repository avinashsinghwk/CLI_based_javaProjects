import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Student {
    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;

    public Student(int id, String name, int grade) {
        this.feesPaid = 0;
        this.feesTotal = 30000;
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void payFees(int fees) {
        feesPaid += fees;
        School.updateTotalMoneyEarned(feesPaid);
    }

    public int getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public int getFeesTotal() {
        return feesTotal;
    }

    public int getRemainingFees() {
        return feesTotal - feesPaid;
    }

    @Override
    public String toString() {
        return "Name : " + name +
                " , Fee Paid Rs. " + feesPaid;
    }
}



 class Teacher {

    private int id;
    private String name;
    private int salary;

    public Teacher(int id, String name, int salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getSalary(){
        return  salary;
    }

    public void setSalary(int salary){
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "Name : " + name
                +" , Total salary earned so far Rs. "
                + salary;
    }
}

 class School {

    private List<Teacher> teachers;
    private List<Student> students;
    private static int  totalMoneyEarned;
    private static int totalMoneySpent;

    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned=0;
        totalMoneySpent=0;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public static void updateTotalMoneyEarned(int MoneyEarned) {
        totalMoneyEarned += MoneyEarned;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public static void updateTotalMoneySpent(int moneySpent) {
        totalMoneyEarned-=moneySpent;
     }

     public void showTeachers() {
         for (Teacher teacher : teachers) {
             System.out.println(teacher);
         }
     }
     public void showStudents() {
         for (Student student : students) {
             System.out.println(student);
         }
     }
}



public class School_Management {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher(1, "Tahseen", 500);
        Teacher teacher2 = new Teacher(2, "Gautam", 700);
        Teacher teacher3 = new Teacher(3, "Jawed", 600);
        Teacher teacher4 = new Teacher(4, "Gajala", 200);
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher1);
        teacherList.add(teacher2);
        teacherList.add(teacher3);
        teacherList.add(teacher4);
        Student student1 = new Student(1, "Arif", 4);
        Student student2 = new Student(2, "Avinash", 12);
        Student student3 = new Student(3, "Chandan", 5);
        Student student4 = new Student(4, "Pankaj", 5);
        Student student5 = new Student(5, "Suraj", 10);
        Student student6 = new Student(6, "Nawed", 11);
        Student student7 = new Student(7, "Dheeraj", 12);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);
        School college1 = new School(teacherList, studentList);
        // college1.addTeacher(teacher4);
        student1.payFees(5000);
        student2.payFees(8000);
        student3.payFees(6000);
        student4.payFees(2000);
        student5.payFees(6000);
        student6.payFees(5000);
        student7.payFees(1000);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n+------------------------------------------+");
            System.out.println("+         School Management System         +");
            System.out.println("+        ( BY: Avinash Kumar Singh )       +");
            System.out.println("+------------------------------------------+\n");
            System.out.println("What do you want to see? (teachers, students, exit)\n");
            System.out.print("Enter your choice : ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("teachers")) {
                System.out.println("\n------------ ALL TEACHERS -----------\n");
                college1.showTeachers();
            } else if (input.equalsIgnoreCase("students")) {
                System.out.println("\n------------ ALL STUDENTS -----------\n");
                college1.showStudents();
            } else if (input.equalsIgnoreCase("exit")) {
                System.out.println("\n -------- THANK YOU --------");
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        scanner.close();
    }
}