public class Main {
  public static void main(String[] args) {

    Student s1 = new Student.StudentBuilder().name("Nahir").lastName("Palacios").age(45).grades(new int[] {10, 8, 8}).build();
    Student s2 = new Student.StudentBuilder().name("Nazareth").lastName("Portillo").age(27).grades(new int[]{5, 9, 8}).build();
    Student s3 = new Student.StudentBuilder().name("Enrico").lastName("Campos").age(21).grades(new int[]{9, 8, 9}).build();
    Student s4 = new Student.StudentBuilder().name("Mauricio").lastName("Ruiz").age(30).grades(new int[]{7, 6, 8}).build();
    Student s5 = new Student.StudentBuilder().name("Thiago").lastName("Martinez").age(25).grades(new int[]{6, 2, 4}).build();
    Student s6 = new Student.StudentBuilder().name("Tamara").lastName("Martinez").age(25).grades(new int[]{6, 2, 4}).build();

    Course c1 = new Course.CourseBuilder().name("Backend Java").hoursQty(5).students(new Student[] {s1, s4, s5, s6}).build();
    Course c2 = new Course.CourseBuilder().name("Frontend React").hoursQty(5).students(new Student[] {s2, s3}).build();


    System.out.println(c1.courseData().toString(2));
    System.out.println(c2.courseData().toString(2));
    System.out.println(c2.passedStudents().toString(2));
    System.out.println(c1.passedStudents().toString(2));
    System.out.println(c1.alphabeticSortedStudents().toString(2));
  }
}
