package tech.igrant.daily.no707;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTest {

    @Test
    public void get() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(1);
        linkedList.addAtTail(2);
        System.out.println(linkedList);
        Assert.assertEquals(
                2,
                linkedList.get(1)
        );
        Assert.assertEquals(
                -1,
                linkedList.get(2)
        );
        Assert.assertEquals(
                -1,
                linkedList.get(10000)
        );
        Assert.assertEquals(
                -1,
                linkedList.get(-1)
        );
    }

    @Test
    public void addAtHead() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtHead(2);
        linkedList.addAtHead(3);
        linkedList.addAtHead(4);
        Assert.assertEquals(
                "[4]: 4->3->2->1->null",
                linkedList.toString()
        );
    }

    @Test
    public void addAtTail() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        Assert.assertEquals(
                "[3]: 1->2->3->null",
                linkedList.toString()
        );
    }

    @Test
    public void addAtIndex() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        Assert.assertEquals(
                "[3]: 1->2->3->null",
                linkedList.toString()
        );
    }

    @Test
    public void addAtIndex2() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(2);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(-1, 1);
        Assert.assertEquals(
                "[3]: 1->2->3->null",
                linkedList.toString()
        );
    }

    @Test
    public void addAtIndex3() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(2);
        linkedList.addAtIndex(3, 3);
        Assert.assertEquals(
                "[2]: 1->2->null",
                linkedList.toString()
        );
    }

    @Test
    public void deleteAtIndex() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(2);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(-1, 1);
        linkedList.deleteAtIndex(0);
        Assert.assertEquals(
                "[2]: 2->3->null",
                linkedList.toString()
        );
    }

    @Test
    public void deleteAtIndex2() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(3);
        linkedList.deleteAtIndex(2);
        Assert.assertEquals(
                "[2]: 1->2->null",
                linkedList.toString()
        );
    }

    @Test
    public void deleteAtIndex3() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(3);
        linkedList.deleteAtIndex(1);
        Assert.assertEquals(
                "[2]: 1->3->null",
                linkedList.toString()
        );
    }

    @Test
    public void all() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(2);
        linkedList.deleteAtIndex(1);
        linkedList.addAtHead(2);
        linkedList.addAtHead(7);
        linkedList.addAtHead(3);
        linkedList.addAtHead(2);
        linkedList.addAtHead(5);
        linkedList.addAtTail(5);
        Assert.assertEquals(
                2,
                linkedList.get(5)
        );
        linkedList.deleteAtIndex(6);
        linkedList.deleteAtIndex(4);
    }

    @Test
    public void case20() {
        String[] fns = new String[]{
                "addAtHead", "addAtTail", "addAtTail", "get", "get", "addAtTail", "addAtIndex", "addAtHead", "addAtHead", "addAtTail", "addAtTail", "addAtTail", "addAtTail", "get", "addAtHead", "addAtHead", "addAtIndex", "addAtIndex", "addAtHead", "addAtTail", "deleteAtIndex", "addAtHead", "addAtHead", "addAtIndex", "addAtTail", "get", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "get", "deleteAtIndex", "addAtTail", "addAtTail", "addAtHead", "addAtTail", "get", "deleteAtIndex", "addAtTail", "addAtHead", "addAtTail", "deleteAtIndex", "addAtTail", "deleteAtIndex", "addAtIndex", "deleteAtIndex", "addAtTail", "addAtHead", "addAtIndex", "addAtHead", "addAtHead", "get", "addAtHead", "get", "addAtHead", "deleteAtIndex", "get", "addAtHead", "addAtTail", "get", "addAtHead", "get", "addAtTail", "get", "addAtTail", "addAtHead", "addAtIndex", "addAtIndex", "addAtHead", "addAtHead", "deleteAtIndex", "get", "addAtHead", "addAtIndex", "addAtTail", "get", "addAtIndex", "get", "addAtIndex", "get", "addAtIndex", "addAtIndex", "addAtHead", "addAtHead", "addAtTail", "addAtIndex", "get", "addAtHead", "addAtTail", "addAtTail", "addAtHead", "get", "addAtTail", "addAtHead", "addAtTail", "get", "addAtIndex"
        };
        Integer[][] params = new Integer[][]{
                new Integer[]{84}, new Integer[]{2}, new Integer[]{39}, new Integer[]{3}, new Integer[]{1}, new Integer[]{42}, new Integer[]{1, 80}, new Integer[]{14}, new Integer[]{1}, new Integer[]{53}, new Integer[]{98}, new Integer[]{19}, new Integer[]{12}, new Integer[]{2}, new Integer[]{16}, new Integer[]{33}, new Integer[]{4, 17}, new Integer[]{6, 8}, new Integer[]{37}, new Integer[]{43}, new Integer[]{11}, new Integer[]{80}, new Integer[]{31}, new Integer[]{13, 23}, new Integer[]{17}, new Integer[]{4}, new Integer[]{10, 0}, new Integer[]{21}, new Integer[]{73}, new Integer[]{22}, new Integer[]{24, 37}, new Integer[]{14}, new Integer[]{97}, new Integer[]{8}, new Integer[]{6}, new Integer[]{17}, new Integer[]{50}, new Integer[]{28}, new Integer[]{76}, new Integer[]{79}, new Integer[]{18}, new Integer[]{30}, new Integer[]{5}, new Integer[]{9}, new Integer[]{83}, new Integer[]{3}, new Integer[]{40}, new Integer[]{26}, new Integer[]{20, 90}, new Integer[]{30}, new Integer[]{40}, new Integer[]{56}, new Integer[]{15, 23}, new Integer[]{51}, new Integer[]{21}, new Integer[]{26}, new Integer[]{83}, new Integer[]{30}, new Integer[]{12}, new Integer[]{8}, new Integer[]{4}, new Integer[]{20}, new Integer[]{45}, new Integer[]{10}, new Integer[]{56}, new Integer[]{18}, new Integer[]{33}, new Integer[]{2}, new Integer[]{70}, new Integer[]{57}, new Integer[]{31, 24}, new Integer[]{16, 92}, new Integer[]{40}, new Integer[]{23}, new Integer[]{26}, new Integer[]{1}, new Integer[]{92}, new Integer[]{3, 78}, new Integer[]{42}, new Integer[]{18}, new Integer[]{39, 9}, new Integer[]{13}, new Integer[]{33, 17}, new Integer[]{51}, new Integer[]{18, 95}, new Integer[]{18, 33}, new Integer[]{80}, new Integer[]{21}, new Integer[]{7}, new Integer[]{17, 46}, new Integer[]{33}, new Integer[]{60}, new Integer[]{26}, new Integer[]{4}, new Integer[]{9}, new Integer[]{45}, new Integer[]{38}, new Integer[]{95}, new Integer[]{78}, new Integer[]{54}, new Integer[]{42, 86}
        };
        Integer[] exp = new Integer[]{
                null, null, null, -1, 2, null, null, null, null, null, null, null, null, 84, null, null, null, null, null, null, null, null, null, null, null, 16, null, null, null, null, null, null, null, null, 37, null, null, null, null, null, 23, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 19, null, 17, null, null, 56, null, null, 31, null, 17, null, 12, null, null, null, null, null, null, null, 40, null, null, null, 37, null, 76, null, 42, null, null, null, null, null, null, 80, null, null, null, null, 43, null, null, null, 40, null
        };
        dynamicRun(fns, params, exp);
    }

    @Test
    public void t59() {
        // []
        //[[],[1],[3],[1,2],[1],[1],[1],[3],[3],[0],[0],[0],[0]]
        String[] fns = new String[]{
                "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get", "get", "deleteAtIndex", "deleteAtIndex", "get", "deleteAtIndex", "get"
        };
        Integer[][] params = new Integer[][]{
                new Integer[]{1}, new Integer[]{3}, new Integer[]{1, 2}, new Integer[]{1}, new Integer[]{1}, new Integer[]{1}, new Integer[]{3}, new Integer[]{3}, new Integer[]{0}, new Integer[]{0}, new Integer[]{0}, new Integer[]{0}
        };
        Integer[] exp = new Integer[]{
                null, null, null, 2, null, 3, -1, null, null, 3, null, -1
        };
        dynamicRun(fns, params, exp);
    }

    private static void dynamicRun(String[] fns, Integer[][] params, Integer[] exp) {
        MyLinkedList linkedList = new MyLinkedList();
        for (int i = 0; i < params.length; i++) {
            String fn = fns[i];
            Integer[] p = params[i];
            switch (fn) {
                case "addAtHead" -> linkedList.addAtHead(p[0]);
                case "addAtTail" -> linkedList.addAtTail(p[0]);
                case "deleteAtIndex" -> linkedList.deleteAtIndex(p[0]);
                case "addAtIndex" -> linkedList.addAtIndex(p[0], p[1]);
                case "get" -> {
                    int actual = linkedList.get(p[0]);
                    Integer expValue = exp[i];
                    Assert.assertEquals("i is %d and l is %s".formatted(i, linkedList.toString()), (int) expValue, actual);
                }
                default -> {
                }
            }
            Assert.assertTrue(linkedList.ok());
        }
    }

}