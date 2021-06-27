package DataStructure.map;

public class hashMap {
    private Node[] array = new Node[11];
    private int size;
    //添加元素：
    public boolean add(Integer key) {
        int hashValue = key.hashCode();
        int index = hashValue % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (key.equals(cur)) {
                //链表中已经存在要添加的元素，无法插入
                return false;
            }
            cur = cur.next;
        }
        //说明数组中并没有要插入的元素，则进行头插（jdk1.8后改为尾插）
        Node newNode = new Node(key);
        newNode.next = array[index];
        array[index] = newNode;
        //尾插：
        //cur.next = newNode;
        size++;
        return true;
    }

    //删除元素：
    public boolean remove(Integer key) {
        int hashValue = key.hashCode();
        int index = hashValue % array.length;
        Node cur = array[index];
        //删除第一个结点
        if (key.equals(cur)) {
            cur.next = null;
            return true;
        }
        Node prev = null;//要删除结点的前一个结点
        while (cur != null) {
            if (key.equals(cur)) {
                //如果是中间结点：
                if (cur.next != null) {
                    prev.next = cur.next;
                } else {
                    //是最后一个结点
                    prev.next = null;
                }
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        //没找到要删除的元素
        return false;
    }

    //查找元素：
    public boolean contains(Integer key) {
        int hashValue = key.hashCode();
        int index = hashValue % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (key.equals(cur)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}
