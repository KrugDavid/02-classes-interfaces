package de.thro.inf.prg3.a02;


import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object> {


    int size = 0;
    Element head;

    @Override
    public void add(Object o) {
        if (head == null) {
            setHead(new Element(o, null));
        } else {
            Element element = head;
            while (element.getNext() != null) {
                element = element.getNext();
            }
            element.setNext(new Element(0, null));
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleList result = new SimpleListImpl();
        for (Object o : this) {
            if (filter.include(o)) {
                result.add(o);
            }
        }
        return result;
    }

    public Element getHead() {
        return head;
    }


    // TODO: Implement the required methods.

    public void setHead(Element head) {
        this.head = head;
    }

    @Override
    public Iterator<Object> iterator() {
        return new SimpleIterator();
    }


    private static class Element {
        Object item;
        Element next;

        public Element(Object item, Element next) {
            this.item = item;
            this.next = next;
        }

        public Object getItem() {
            return item;
        }

        public void setItem(Object item) {
            this.item = item;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    private class SimpleIterator implements Iterator<Object> {

        private Element current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Object temp = current.getItem();
            current = current.getNext();
            return temp;
        }
    }
}
