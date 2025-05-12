package ut.ex;

public class SimpleList<E> {

    private Object[] simpleList;
    private int size; 

    public SimpleList() {
        simpleList = new Object[10];
        size = 0;
    }

    public void add(E element){
        if (size == simpleList.length){
            resize();
        }
        simpleList[size++] = element;
        //BUG: forget to store the element
        //size++;
    }

    public E get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) simpleList[index];
    }

    public void remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++){
            simpleList[i] = simpleList[i + 1];
        }
        simpleList[--size] = null; 
    }

    public int size(){
        return size;
    }
    
    public void clear(){
        size = 0;
        simpleList = new Object[simpleList.length];
    }

    private void resize(){
        int newSize = simpleList.length * 2;
        Object[] newList = new Object[newSize];
        System.arraycopy(simpleList, 0, newList, 0, size);
        simpleList = newList;
    }
}
