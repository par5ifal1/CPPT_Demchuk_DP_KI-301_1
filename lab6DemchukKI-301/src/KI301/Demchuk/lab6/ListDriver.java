package KI301.Demchuk.lab6;

public class ListDriver {public static void main(String[] args) {
    DoublyLinkedList<MyClass1> linkedList = new DoublyLinkedList<>();

    MyClass1 obj1 = new MyClass1("Object 1", 42);
    MyClass1 obj2 = new MyClass1("Object 2", 99);

    linkedList.add(obj1);
    linkedList.add(obj2);

    System.out.println(linkedList.getAll().toString() + "\n");

    System.out.println(linkedList.findMaxElement() + "\n");

    System.out.println(linkedList.remove(3) + "\n");

    System.out.println(linkedList.getAll().toString() + "\n");

    System.out.println(linkedList.get(4) + "\n");

    DoublyLinkedList<MyClass2> linkedList2 = new DoublyLinkedList<>();
    MyClass2 obj3 = new MyClass2("Object 1", "Description 1234");
    MyClass2 obj4 = new MyClass2("Object 2", "Description 2");

    linkedList2.add(obj3);
    linkedList2.add(obj4);

    System.out.println(linkedList2.getAll().toString() + "\n");

    System.out.println(linkedList2.findMaxElement() + "\n");

    System.out.println(linkedList2.remove(0) + "\n");

    System.out.println(linkedList2.getAll() + "\n");
}
}

class MyClass1 implements Comparable<MyClass1> {
    private String name;
    private int value;

    public MyClass1(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public int compareTo(MyClass1 other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return "MyClass1 { " +
                "name = " + name + '\'' +
                ", value = " + value +
                '}';
    }
}

class MyClass2 implements Comparable<MyClass2> {
    private String name;
    private String description;

    public MyClass2(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "MyClass2 { " +
                "name = " + name + '\'' +
                ", description = '" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(MyClass2 other) {
        return CharSequence.compare(this.description, other.description);    }
}
