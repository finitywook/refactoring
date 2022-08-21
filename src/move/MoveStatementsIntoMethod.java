package move;

import java.util.StringJoiner;

/**
 * Move Statements Into Method
 *
 * 문장을 메서드로 옮기기
 */
public class MoveStatementsIntoMethod {

    static class Old {
        public String renderPerson(Person person) {
            StringJoiner joiner = new StringJoiner("\n");

            joiner.add("<p>" + person.getName() + "<p>");
            joiner.add(renderPhoto(person.getPhoto()));
            joiner.add("<p> 제목 : " + person.getPhoto().getTitle() + "<p>");
            joiner.add(emitPhotoData(person.getPhoto()));

            return joiner.toString();
        }

        public String renderPhoto(Photo photo) {
            StringJoiner joiner = new StringJoiner("\n");

            joiner.add("<div>");
            joiner.add("<p> 제목 : " + photo.getTitle() + "<p>");
            joiner.add(emitPhotoData(photo));
            joiner.add("</div>");

            return joiner.toString();
        }

        public String emitPhotoData(Photo photo) {
            StringJoiner joiner = new StringJoiner("\n");

            joiner.add("<p>위치 : " + photo.getLocation() + "</p>");
            joiner.add("<p>날짜 : " + photo.getDate() + "</p>");

            return joiner.toString();
        }
    }

    static class New {
        public String renderPerson(Person person) {
            StringJoiner joiner = new StringJoiner("\n");

            joiner.add("<p>" + person.getName() + "<p>");
            joiner.add(renderPhoto(person.getPhoto()));
            joiner.add(emitPhotoData(person.getPhoto()));

            return joiner.toString();
        }

        public String renderPhoto(Photo photo) {
            StringJoiner joiner = new StringJoiner("\n");

            joiner.add("<div>");
            joiner.add(emitPhotoData(photo));
            joiner.add("</div>");

            return joiner.toString();
        }

        public String emitPhotoData(Photo photo) {
            StringJoiner joiner = new StringJoiner("\n");

            joiner.add("<p> 제목 : " + photo.getTitle() + "<p>");
            joiner.add("<p>위치 : " + photo.getLocation() + "</p>");
            joiner.add("<p>날짜 : " + photo.getDate() + "</p>");

            return joiner.toString();
        }
    }

    static class Person {
        private String name;
        private Photo photo;

        public Person(String name, Photo photo) {
            this.name = name;
            this.photo = photo;
        }

        public String getName() {
            return name;
        }

        public Photo getPhoto() {
            return photo;
        }
    }

    static class Photo {
        private String title;
        private String location;
        private String date;

        public Photo(String title, String location, String date) {
            this.title = title;
            this.location = location;
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public String getLocation() {
            return location;
        }

        public String getDate() {
            return date;
        }
    }
}
