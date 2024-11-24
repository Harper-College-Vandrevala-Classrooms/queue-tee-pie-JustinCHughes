package com.csc;

public class QueueTees<T> {

  public static void main(String[] args) {
    Godzilla bigIguana = new Godzilla();
    Pennywise funnyClown = new Pennywise();
    Shrek swampGuy = new Shrek();

    QueueTees<Cutie> patooties = new QueueTees<>();

    patooties.enqueue(bigIguana);
    patooties.enqueue(funnyClown);
    patooties.enqueue(swampGuy);

    // should be 3
    System.out.println(patooties.size());

    // Should give godzilla description
    System.out.println(patooties.dequeue().description());

    // Clear list
    patooties.clear();

    // Should be 0
    System.out.println(patooties.size());
  }

  private Node<T> head;
  private Node<T> tail;
  private int size;

  public QueueTees()
  {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  // Enqueues items into the doubly linked list
  public void enqueue(T patootie)
  {
    Node<T> newNode = new Node<>(patootie);
    if(this.head == null)
    {
      this.head = newNode;
      this.tail = newNode;
      this.size++;
    }
    else
    {
      newNode.next = this.head;
      this.head.prev = newNode;
      this.head = newNode;
      this.size++;
    }
  }

  // Dequeues items
  public T dequeue()
  {
    if(this.size == 0)
    {
      throw new IllegalArgumentException("No more items in the queue");
    }
    Node<T> tempNode = this.tail;
    if(tempNode.prev != null)
    {
      tempNode.prev.next = null;
      this.tail = tempNode.prev;
    }
    else
    {
      this.head = null;
      this.tail = null;
    }
    tempNode.prev = null;
    this.size--;

    return tempNode.data;
  }

  // Retrieves size of the queue
  public int size()
  {
    return this.size;
  }

  // Clears the queue
  public void clear()
  {
    while(this.size > 0)
    {
      dequeue();
    }
  }
}
