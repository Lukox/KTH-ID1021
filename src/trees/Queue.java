package trees;

import java.util.LinkedList;

public class Queue<T> {
  private LinkedList<T> list = new LinkedList<T>();

  public void add(T item) {
    list.addLast(item);
  }

  public T remove() {
    return list.poll();
  }

  public boolean hasItems() {
    return !list.isEmpty();
  }

  public int size() {
    return list.size();
  }

  public void addItems(Queue<? extends T> q) {
    while (q.hasItems())
      list.addLast(q.remove());
  }
}