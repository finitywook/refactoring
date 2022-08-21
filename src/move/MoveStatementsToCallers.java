package move;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Move Statements To Callers
 *
 * 문장을 호출한 곳으로 옮기기
 */
public class MoveStatementsToCallers {

    static class Old {
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

    static class New {
        public String renderPerson(Person person) {
            StringJoiner joiner = new StringJoiner("\n");

            joiner.add("<p>" + person.getName() + "<p>");
            joiner.add(renderPhoto(person.getPhoto()));
            joiner.add(emitPhotoData(person.getPhoto()));
            joiner.add("<p>위치 : " + person.getPhoto().getLocation() + "</p>");

            return joiner.toString();
        }

        public String renderPhoto(Photo photo) {
            StringJoiner joiner = new StringJoiner("\n");

            joiner.add("<div>");
            joiner.add(emitPhotoData(photo));
            joiner.add("<p>위치 : " + photo.getLocation() + "</p>");
            joiner.add("</div>");

            return joiner.toString();
        }

        public String listRecentPhotos(List<Photo> photos) {
            return photos.stream()
                    .filter(p -> p.date.isEmpty())
                    .map(this::emitPhotoData)
                    .collect(Collectors.joining("\n"));
        }

        public String emitPhotoData(Photo photo) {
            StringJoiner joiner = new StringJoiner("\n");

            joiner.add("<p>제목 : " + photo.getTitle() + "<p>");
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
