package com.csc;

public class Node<T> {
  public Node<T> next;
  public Node<T> prev;
  public T data;

  public Node(T patootie)
  {
    this.data = patootie;
    this.next = null;
    this.prev = null;
  }
}
