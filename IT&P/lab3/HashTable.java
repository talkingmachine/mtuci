import java.util.LinkedList;

public class HashTable<K, V> {

  private class HashNode<K, V> {

    K key;
    V value;

    public HashNode(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  private LinkedList<HashNode<K, V>>[] chainArray;
  private int numBuckets;
  private int size;

  public HashTable() {
    chainArray = new LinkedList[10];
    numBuckets = 10;
    size = 0;

    for (int i = 0; i < numBuckets; i++) {
      chainArray[i] = new LinkedList<>();
    }
  }

  private int hashCode(K key) {
    return Math.abs(key.hashCode() % numBuckets);
  }

  public void put(K key, V value) {
    int bucketIndex = hashCode(key);
    LinkedList<HashNode<K, V>> chain = chainArray[bucketIndex];

    for (HashNode<K, V> node : chain) {
      if (node.key.equals(key)) {
        node.value = value;
        return;
      }
    }
    HashNode<K, V> newNode = new HashNode<>(key, value);
    chain.add(newNode);
    size++;
  }

  public V get(K key) {
    int bucketIndex = hashCode(key);
    LinkedList<HashNode<K, V>> chain = chainArray[bucketIndex];

    for (HashNode<K, V> node : chain) {
      if (node.key.equals(key)) {
        return node.value;
      }
    }

    return null;
  }

  public V remove(K key) {
    int bucketIndex = hashCode(key);
    LinkedList<HashNode<K, V>> chain = chainArray[bucketIndex];

    for (HashNode<K, V> node : chain) {
      if (node.key.equals(key)) {
        chain.remove(node);
        size--;
        return node.value;
      }
    }

    return null;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }
}
