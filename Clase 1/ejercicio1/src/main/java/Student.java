import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Student {
  private String name;
  private String lastName;
  private int age;
  private int[] grades;

  /**
  * Returns the average grade of the student's ratings rounded to two decimal places
  * @return average ratings rounded to two decimal places
  */
  public double averageGrade () {
    int acc = 0;
    for (int grade: grades) {
      acc += grade;
    }
    double averageGrade = (double) acc / grades.length;
    return Math.round(averageGrade * 100.0) / 100.0;
  }

  /**
   * Returns the student's lastName and name in a String separated with a blank space
   * @return String with lastName and name of a student using a blank space as separator
   * */
  public String fullName(){
    return String.format("%s %s", this.lastName, this.name);
  }
}
