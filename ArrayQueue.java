public class ArrayQueue<T> implements Queue<T> {

    public int head;
    public int tail;
    public T[] arr;
    public int items; //how many items are in the array


    public ArrayQueue(){
        head = tail = 0;
        arr = (T[])(new Object[10]);
        items = 0;

    }

    public T dequeue(){ //taking elements out
        if(empty()){
            throw new IndexOutOfBoundsException("Array is Empty"); //out of bound
        }
        T temp = arr[head];
        head = (head+1) % arr.length;
        items--;
        return temp;

    }
    public void enqueue(T item){ //pushing elements in
        if((tail+1)% arr.length == head){
            grow_array();
        }
        arr[tail] = item;
        tail = (tail+1) % arr.length;
        items++;


    }
    public boolean empty(){ //checks if the array is empty
        /*if(head == tail){
            return true;
        }
        return false;*/

        return head == tail;

    }

    protected void grow_array(){ //doubles the size of the array
        T[] temp = (T[])(new Object[arr.length*2]);
        for(int i = head; i < items ; i++){
            temp[i] = arr[(head+i)%arr.length];
            //temp[i++] = arr[i];
        }
        head= 0; //head will be the first element of the new array
        arr = temp;
        tail = items; //tail will be the last element of the new array

    }


}
