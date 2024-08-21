import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class IDGenerator {

  private static int id = 1;

  public static int next() {
    int thisOne = id++;
    return thisOne;
  }
}

class Patient {

  int patientId;
  String patientName;
  String city;

  public Patient(String patientName, String city) {
    this.patientName = patientName;
    this.city = city;
    this.patientId = IDGenerator.next();
  }

  public int getPatientId() {
    return patientId;
  }

  public void setPatientId(int patientId) {
    this.patientId = patientId;
  }

  public String getPatientName() {
    return patientName;
  }

  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

}

class Doctor {

  String regNo;
  String docName;
  List<Patient> patientList;

  public Doctor(String regNo, String docName) {
    this.regNo = regNo;
    this.docName = docName;
    this.patientList = new ArrayList<Patient>();
  }

  public String getRegNo() {
    return regNo;
  }

  public void setRegNo(String regNo) {
    this.regNo = regNo;
  }

  public String getDocName() {
    return docName;
  }

  public void setDocName(String docName) {
    this.docName = docName;
  }

  public List<Patient> getPatientList() {
    return patientList;
  }

  public void setPatientList(List<Patient> patientList) {
    this.patientList = patientList;
  }

  public int addPatient(Patient p) {
    this.patientList.add(p);
    return this.patientList.size();
  }

  public int releasePatient(Patient p) {
    this.patientList.remove(p);
    return this.patientList.size();
  }

}

public class Hospital_Management_System {

  List<Doctor> doctorList = new ArrayList<Doctor>();

  public int registerDoctor(Doctor d) throws Exception {
    for (Doctor doc : doctorList) {
      if (doc.regNo.equals(d.regNo)) {
        throw new Exception("Doctor already exist");
      }
    }
    doctorList.add(d);
    return doctorList.size();
  }

  public int hospitalizePatient(String regNo, Patient p) throws Exception {
    for (Doctor doc : doctorList) {
      if (doc.regNo.equals(regNo)) {
        doc.patientList.add(p);
        return doc.patientList.size();
      }
    }
    return -1;
  }

  public int releasePatient(int patientId) {
    for (Doctor doc : doctorList) {
      for (Patient patient : doc.patientList) {
        if (patient.patientId == patientId) {
          doc.patientList.remove(patient);
          return doc.patientList.size();
        }
      }
    }
    return -1;
  }

  public int patientCountPerCity(String city) {
    int count = 0;
    for (Doctor doc : doctorList) {
      for (Patient patient : doc.patientList) {
        if (patient.city.equals(city)) {
          count++;
          break;
        }
      }
    }
    return count;
  }

  public void showAllDoctors() {
    if (doctorList.isEmpty()) {
      System.out.println("\nNo doctors registered yet.....");
      return;
    }
    for (Doctor doctor : doctorList) {
      System.out.println("Doctor Name: " + doctor.docName + ", Registration Number: " + doctor.regNo);
    }
  }

  public void showAllPatients() {
    if (doctorList.isEmpty()) {
      System.out.println("\nNo doctors registered yet.....");
      return;
    }

    boolean foundPatients = false;
    for (Doctor doctor : doctorList) {
      if (!doctor.patientList.isEmpty()) {
        foundPatients = true;
        System.out.println("Doctor: " + doctor.docName);
        for (Patient patient : doctor.patientList) {
          System.out.println(String.format("  Patient Name: %s, Patient ID: %s, City: %s", patient.patientName,
              patient.patientId, patient.city));
        }
      }
    }

    if (!foundPatients) {
      System.out.println("No patients hospitalized yet.");
    }
  }

  public static void main(String[] args) {
    Hospital_Management_System hospital = new Hospital_Management_System();

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\n------ Hospital Management System -------");
      System.out.println("       ( BY : Avinash Kumar Singh )      \n");
      System.out.println("1. Register Doctor");
      System.out.println("2. Hospitalize Patient");
      System.out.println("3. Release Patient");
      System.out.println("4. Patient Count Per City");
      System.out.println("5. Show All Doctors");
      System.out.println("6. Show All Patients");
      System.out.println("7. Exit\n");
      System.out.print("Enter your choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          System.out.print("\nEnter Doctor's Registration Number: ");
          String regNo = scanner.nextLine();
          System.out.print("Enter Doctor's Name: ");
          String docName = scanner.nextLine();
          Doctor doctor = new Doctor(regNo, docName);
          try {
            hospital.registerDoctor(doctor);
            System.out.println("\nDoctor registered successfully.");
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
        case 2:
          System.out.print("\nEnter Patient's Name: ");
          String patientName = scanner.nextLine();
          System.out.print("Enter Patient's City: ");
          String city = scanner.nextLine();
          System.out.print("Enter Doctor's Registration Number: ");
          String regNo1 = scanner.nextLine();
          Patient patient = new Patient(patientName, city);
          try {
            hospital.hospitalizePatient(regNo1, patient);
            System.out.println("\nPatient hospitalized successfully.");
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
        case 3:
          System.out.print("\nEnter Patient's ID: ");
          int patientId = scanner.nextInt();
          scanner.nextLine();
          hospital.releasePatient(patientId);
          System.out.println("\nPatient released successfully.");
          break;
        case 4:
          System.out.print("\nEnter City: ");
          String city1 = scanner.nextLine();
          int patientCount = hospital.patientCountPerCity(city1);
          System.out.println("\nNumber of patients from " + city1 + ": " + patientCount);
          break;
        case 5:
          hospital.showAllDoctors();
          break;
        case 6:
          hospital.showAllPatients();
          break;
        case 7:
          System.out.println("Exiting the program...");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

}