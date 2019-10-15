package coding.ctci.structures.mutable;

//TODO: Convert to scalatest
public class CustomArrayListSpec {
//    private class Item {
//        int id;
//        String name;
//
//        Item(int id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//    }
//
//    private class CustomArrayListFixture<T> extends CustomArrayList<T> {
//        CustomArrayListFixture() {
//            super();
//        }
//
//        @SafeVarargs
//        CustomArrayListFixture(T... items) {
//            super(items);
//        }
//
//        Object [] getUnderlyingArray() {
//            return super.underlyingArray;
//        }
//    }
//
//    @Test
//    public void testEmptyCustomArrayList() {
//        CustomArrayListFixture cal = new CustomArrayListFixture();
//        Assert.assertEquals(0, cal.size());
//        Assert.assertTrue(cal.isEmpty());
//    }
//
//    @Test
//    public void testNonEmptyCustomArrayList() {
//        CustomArrayListFixture<Integer> cal = new CustomArrayListFixture<>(1);
//        Assert.assertEquals(1, cal.size());
//        Assert.assertTrue(cal.isNonEmpty());
//    }
//
//    @Test
//    public void testCustomArrayListInsert() {
//        CustomArrayListFixture<Character> cal = new CustomArrayListFixture<>('a');
//        Assert.assertEquals(1, cal.size());
//        cal.insert('b');
//        cal.insert('c');
//        cal.insert('d');
//        Assert.assertEquals(4, cal.size());
//        Assert.assertEquals(8, cal.getUnderlyingArray().length);
//    }
//
//    @Test
//    public void testCustomArrayListInsertPos1() {
//        CustomArrayListFixture<Character> cal = new CustomArrayListFixture<>('T', 'h', 'e', ' ', 'q', 'u', 'i', 'c', 'k', ' ', 'f', 'o', 'x');
//        Assert.assertEquals(13, cal.size());
//        cal.insert(9, ' ', 'b', 'r', 'o', 'w', 'n');
//        Assert.assertEquals("The quick brown fox", cal.toString());
//        Assert.assertEquals(19, cal.size());
//        Assert.assertEquals(26, cal.getUnderlyingArray().length);
//    }
//
//    @Test
//    public void testCustomArrayListRemove() {
//        CustomArrayListFixture<Integer> cal = new CustomArrayListFixture<>(1, 2, 3, 4);
//        Assert.assertEquals(4, cal.size());
//        Assert.assertEquals(2, (int) cal.remove(1).get());
//        Assert.assertEquals(4, (int) cal.remove(2).get());
//        Assert.assertEquals(2, cal.size());
//        Assert.assertEquals(8, cal.getUnderlyingArray().length);
//    }
//
//    @Test
//    public void testCustomArrayListGet() {
//        CustomArrayListFixture<Integer> cal = new CustomArrayListFixture<>(1, 2);
//        Assert.assertEquals(2, cal.size());
//        Assert.assertEquals(1, (int) cal.get(0).get());
//        Assert.assertEquals(2, (int) cal.get(1).get());
//        Assert.assertEquals(4, cal.getUnderlyingArray().length);
//    }
//
//    @Test
//    public void testCustomArrayListFindFirsts() {
//        CustomArrayListFixture<Item> cal = new CustomArrayListFixture<>(new Item(1, "Cat"), new Item(2, "Dog"), new Item(3, "Bird"), new Item(4, "Fish"));
//        Assert.assertEquals(4, cal.size());
//        Assert.assertEquals("Bird", cal.findFirst(item -> item.id == 3).get().name);
//        Assert.assertEquals(8, cal.getUnderlyingArray().length);
//    }
//
//    @Test
//    public void testCustomArrayListResize() {
//        CustomArrayListFixture cal = new CustomArrayListFixture();
//        Assert.assertEquals(1, cal.getUnderlyingArray().length);
//        cal.resize();
//        Assert.assertEquals(2, cal.getUnderlyingArray().length);
//        cal.resize();
//        Assert.assertEquals(4, cal.getUnderlyingArray().length);
//    }
}
