package br.com.javastruct.list;

public interface List<E> {

     abstract public void add(E value);

     abstract public void add(E value, int index);

     abstract public E get(int index);

     abstract public E remove(int index);

     abstract public boolean isEmpty();

     abstract public int size();
}
