package encapsulate;

import java.util.Collections;
import java.util.List;

/**
 * Encapsulate Collection
 *
 * 컬렉션 캡슐화하기
 */
public class EncapsulateCollection {

    static class Old {
        public void addCourses(Person person, Course course) {
            person.setCourses(Collections.singletonList(course));
        }

        static class Person {
            private String name;
            private List<Course> courses;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<Course> getCourses() {
                return courses;
            }

            public void setCourses(List<Course> courses) {
                this.courses = courses;
            }
        }

        static class Course {
            private String name;

            public Course(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }
    }

    static class New {
        public void addCourse(Person person, Course course) {
            person.addCourse(course);
        }

        static class Person {
            private String name;
            private List<Course> courses;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<Course> getCourses() {
                return courses;
            }

            public void addCourse(Course course) {
                this.courses.add(course);
            }
        }

        static class Course {
            private String name;

            public Course(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }
    }
}
