package extend;

/**
 * Collapse Hierarchy
 *
 * 계층 합치기
 */
public class CollapseHierarchy {

    static class Old {
        static class Employee {
        }

        static class SalesPerson extends Employee {
        }
    }

    static class New {
        static class Employee {
        }
    }
}
