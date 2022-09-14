package extend;

/**
 * Replace Subclass With Delegate
 *
 * 서브클래스를 위임으로 바꾸기
 */
public class ReplaceSubclassWithDelegate {

    static class Old {
        static class Order {
            private int daysToShip;

            public int getDaysToShip() {
                return daysToShip;
            }
        }

        static class PriorityOrder extends Order {
            private PriorityPlan priorityPlan;

            @Override
            public int getDaysToShip() {
                return priorityPlan.getDaysToShip();
            }
        }

        static class PriorityPlan {
            private int daysToShip;

            public int getDaysToShip() {
                return daysToShip;
            }
        }
    }

    static class New {
        static class Order {
            private int daysToShip;
            private PriorityOrderDelegate priorityOrderDelegate;

            public int getDaysToShip() {
                if(priorityOrderDelegate != null) {
                    return priorityOrderDelegate.getDaysToShip();
                }

                return daysToShip;
            }
        }

        static class PriorityOrderDelegate {
            private PriorityPlan priorityPlan;

            public int getDaysToShip() {
                return priorityPlan.getDaysToShip();
            }
        }

        static class PriorityPlan {
            private int daysToShip;

            public int getDaysToShip() {
                return daysToShip;
            }
        }
    }
}
