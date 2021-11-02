import lombok.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Course {
  String name;
  int hoursQty;
  Student[] students;

  /**
   * Returns the course's average ratings rounded to two decimal places
   * @return average ratings rounded to two decimal places
   * */
  public double courseAverageGrade () {
    int acc = 0;
    for (Student student: students) {
      acc += student.averageGrade();
    }
    double average = (double) acc / students.length;
    return Math.round(average * 100.0) / 100.0;
  }

  /**
   * Returns course data in JSON format
   * @return JSON object with course data
   * */
  public JSONObject courseData (){
    return new JSONObject(this).put("courseAverageGrade", courseAverageGrade());
  }

  /**
   * Returns students list with average greater than or equal to 6 in JSON format
   * @return JSON array with students with an average grade greater than or equal to 6
   * */
  public JSONArray passedStudents() {
    JSONArray passedStudents = new JSONArray();
    for (Student student : students) {
      if (student.averageGrade() > 6) {
        passedStudents.put(new JSONObject(student));
      }
    }
    return passedStudents;
  }

  /**
   * Returns alphabetic sorted (lastname, name) students in JSON format
   * @return JSON array with students in alphabetic order
   * */
  public JSONArray alphabeticSortedStudents(){
    Student[] sortedStudents = students.clone();
    Arrays.sort(sortedStudents, (s1, s2) -> s1.fullName().compareTo(s2.fullName()));
    return new JSONArray(sortedStudents);
  }
}
