package extend;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Replace Superclass With Delegate
 *
 * 슈퍼클래스를 위임으로 바꾸기
 */
public class ReplaceSuperclassWithDelegate {

    static class Old {
        static class CatalogItem {
            private final String id;
            private final String title;
            private final List<String> tags;

            public CatalogItem(String id, String title, List<String> tags) {
                this.id = id;
                this.title = title;
                this.tags = tags;
            }

            public String getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }

            public boolean hasTag(String tag) {
                return tags.contains(tag);
            }
        }

        static class Scroll extends CatalogItem {
            private final LocalDateTime dateLastCleaned;

            public Scroll(String id, String title, List<String> tags, LocalDateTime dateLastCleaned) {
                super(id, title, tags);
                this.dateLastCleaned = dateLastCleaned;
            }

            public boolean needsCleaning(LocalDateTime targetDate) {
                int threshold = this.hasTag("revered") ? 700 : 1500;

                return daysSinceLastCleaning(targetDate) > threshold;
            }

            public long daysSinceLastCleaning(LocalDateTime targetDate) {
                return dateLastCleaned.until(targetDate, ChronoUnit.DAYS);
            }
        }
    }

    static class New {

        static class CatalogItem {
            private final String id;
            private final String title;
            private final List<String> tags;

            public CatalogItem(String id, String title, List<String> tags) {
                this.id = id;
                this.title = title;
                this.tags = tags;
            }

            public String getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }

            public boolean hasTag(String tag) {
                return tags.contains(tag);
            }
        }

        static class Scroll {
            private final CatalogItem catalogItem;
            private final LocalDateTime dateLastCleaned;

            public Scroll(String id, String title, List<String> tags, LocalDateTime dateLastCleaned) {
                this.catalogItem = new CatalogItem(id, title, tags);
                this.dateLastCleaned = dateLastCleaned;
            }

            public boolean needsCleaning(LocalDateTime targetDate) {
                int threshold = catalogItem.hasTag("revered") ? 700 : 1500;

                return daysSinceLastCleaning(targetDate) > threshold;
            }

            public long daysSinceLastCleaning(LocalDateTime targetDate) {
                return dateLastCleaned.until(targetDate, ChronoUnit.DAYS);
            }
        }

    }
}
