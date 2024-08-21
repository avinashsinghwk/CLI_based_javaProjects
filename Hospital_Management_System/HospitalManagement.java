import java.util.*;

/* Hospital Management System Project in Java */

class doctor {
    String did, dname, specilist, appoint, doc_qual;
    int droom;

    void new_doctor() {
        Scanner input = new Scanner(System.in);
        System.out.print("id:-");
        did = input.nextLine();
        System.out.print("name:-");
        dname = input.nextLine();
        System.out.print("specilization:-");
        specilist = input.nextLine();
        System.out.print("work time:-");
        appoint = input.nextLine();
        System.out.print("qualification:-");
        doc_qual = input.nextLine();
        System.out.print("room no.:-");
        droom = input.nextInt();
        input.close();
    }

    void doctor_info() {
        System.out.println(did + "\t" + dname + "  \t" + specilist + "     \t" + appoint + "    \t" + doc_qual
                + "       \t" + droom);
    }
}

class patient {
    String pid, pname, disease, sex, admit_status;
    int age;

    void new_patient() {
        Scanner input = new Scanner(System.in);
        System.out.print("id:-");
        pid = input.nextLine();
        System.out.print("name:-");
        pname = input.nextLine();
        System.out.print("disease:-");
        disease = input.nextLine();
        System.out.print("sex:-");
        sex = input.nextLine();
        System.out.print("admit_status:-");
        admit_status = input.nextLine();
        System.out.print("age:-");
        age = input.nextInt();
        input.close();
    }

    void patient_info() {
        System.out.println(
                pid + "\t" + pname + " \t" + disease + "     \t" + sex + "      \t" + admit_status + "\t" + age);
    }
}

class medical {
    String med_name, med_comp, exp_date;
    int med_cost, count;

    void find_medi() {
        System.out.println(med_name + "  \t" + med_comp + "    \t" + exp_date + "     \t" + med_cost);
    }
}

class facility {
    String fecility;
    int lab_cost;

    void feci_list() {
        System.out.println(fecility + "\t\t" + lab_cost);
    }
}

public class HospitalManagement {
    public static void main(String args[]) {
        int count1 = 2, count2 = 2, count3 = 2, count4 = 4;
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println("      * Welcome to Hospital Management System Project in Java *");
        System.out.println("                       ( Avinash Kumar Singh )");
        System.out.println("-----------------------------------------------------------------------");
        doctor[] d = new doctor[25];
        patient[] p = new patient[100];
        facility[] f = new facility[20];
        medical[] m = new medical[100];
        int i;
        for (i = 0; i < 25; i++)
            d[i] = new doctor();
        for (i = 0; i < 100; i++)
            p[i] = new patient();
        for (i = 0; i < 20; i++)
            f[i] = new facility();
        for (i = 0; i < 100; i++)
            m[i] = new medical();

        d[0].did = "1";
        d[0].dname = "Dr.Avinash";
        d[0].specilist = "ENT";
        d[0].appoint = "5-11AM";
        d[0].doc_qual = "MBBS,MD";
        d[0].droom = 17;
        d[1].did = "2";
        d[1].dname = "Dr.Anya";
        d[1].specilist = "Physician";
        d[1].appoint = "10-3AM";
        d[1].doc_qual = "MBBS,MD";
        d[1].droom = 45;

        p[0].pid = "12";
        p[0].pname = "Pankaj";
        p[0].disease = "Cancer";
        p[0].sex = "Male";
        p[0].admit_status = "y";
        p[0].age = 30;
        p[1].pid = "13";
        p[1].pname = "Sumit";
        p[1].disease = "Cold";
        p[1].sex = "Male";
        p[1].admit_status = "y";
        p[1].age = 23;

        m[0].med_name = "Corex";
        m[0].med_comp = "Cino pvt";
        m[0].exp_date = "9-5-16";
        m[0].med_cost = 55;
        m[0].count = 8;
        m[1].med_name = "Nytra";
        m[1].med_comp = "Ace pvt";
        m[1].exp_date = "4-4-15";
        m[1].med_cost = 500;
        m[1].count = 5;

        f[0].fecility = "X-ray     ";
        f[0].lab_cost = 800;
        f[1].fecility = "CT Scan   ";
        f[1].lab_cost = 1200;
        f[2].fecility = "OR Scan   ";
        f[2].lab_cost = 500;
        f[3].fecility = "Blood Bank";
        f[3].lab_cost = 50;

        Scanner input = new Scanner(System.in);
        int choice, j, c1, status = 1, s1 = 1, s2 = 1;
        while (status == 1) {
            System.out.println("\n                              MAIN MENU");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("1. Doctos  2. Patients  3. Medicines  4. Facility  5. Exit");
            System.out.println("-----------------------------------------------------------------------");
            System.out.print("Enter your choice : ");
            choice = input.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println(
                            "----------------------------------------------------------------------");
                    System.out.println("                      *DOCTOR SECTION*");
                    System.out.println(
                            "----------------------------------------------------------------------");
                    s1 = 1;
                    while (s1 == 1) {
                        System.out.println("1.Add New Entry\n2.Existing Doctors List");
                        c1 = input.nextInt();
                        switch (c1) {
                            case 1: {
                                d[count1].new_doctor();
                                count1++;
                                break;
                            }
                            case 2: {
                                System.out.println(
                                        "-------------------------------------------------------------------------");
                                System.out.println("id \t Name\t Specilist \t Timing \t Qualification \t Room No.");
                                System.out.println(
                                        "--------------------------------------------------------------------------");
                                for (j = 0; j < count1; j++) {
                                    d[j].doctor_info();
                                }
                                break;
                            }
                        }
                        System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
                        s1 = input.nextInt();
                    }
                    break;
                }
                case 2: {
                    System.out.println(
                            "--------------------------------------------------------------------------------");
                    System.out.println("                     *PATIENT SECTION*");
                    System.out.println(
                            "--------------------------------------------------------------------------------");
                    s2 = 1;
                    while (s2 == 1) {
                        System.out.println("1.Add New Entry\n2.Existing Patients List");
                        c1 = input.nextInt();
                        switch (c1) {
                            case 1: {
                                p[count2].new_patient();
                                count2++;
                                break;
                            }
                            case 2: {
                                System.out.println(
                                        "--------------------------------------------------------------------------------");
                                System.out.println("id \t Name \t Disease \t Gender \t Admit Status \t Age");
                                System.out.println(
                                        "--------------------------------------------------------------------------------");
                                for (j = 0; j < count2; j++) {
                                    p[j].patient_info();
                                }
                                break;
                            }
                        }
                        System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
                        s2 = input.nextInt();
                    }
                    break;
                }
                case 3: {
                    System.out.println(
                            "----------------------------------------------------------------------");
                    System.out.println("Name \t Company \t Expiry Date \t Cost");
                    System.out.println(
                            "----------------------------------------------------------------------");
                    for (j = 0; j < count3; j++) {
                        m[j].find_medi();
                    }
                    break;
                }

                case 4: {
                    System.out.println(
                            "--------------------------------------------------------------------------------");
                    System.out.println("Fecilities\t\t Cost");
                    System.out.println(
                            "--------------------------------------------------------------------------------");
                    for (j = 0; j < count4; j++) {
                        f[j].feci_list();
                    }
                    break;
                }

                case 5: {
                    input.close();
                    System.out.println("\nThank You.........");
                    System.exit(0);
                }
                default: {
                    System.out.println(" You Have Enter Wrong Choice!!!");
                }
            }
            System.out.println("\nReturn to MAIN MENU Press 1");
            status = input.nextInt();
        }
    }

}