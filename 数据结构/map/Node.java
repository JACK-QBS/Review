package DataStructure.map;

import java.util.Objects;

public class Node {
    Integer key;
    Node next;
    public Node(Integer key) {
        key = this.key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(key, node.key) &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, next);
    }
}
