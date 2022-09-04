package organizing;

/**
 * Rename Field
 *
 * 필드 이름 바꾸기
 */
public class RenameField {

    static class Old {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class New {
        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
