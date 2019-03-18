public class ArrayStack<T> implements Stack<T>{
    protected Object[] temp_arr;
    protected T[] arr;
    protected int top;

    public ArrayStack(){
        top = -1;
        temp_arr = new Object[10];
        arr = (T[])temp_arr;
    }

    public void push(T item){
        if(top == arr.length-1){
            grow_array();
        }
        arr[++top] = item;

    }
    public T pop(){
        if(empty()){
            throw new IndexOutOfBoundsException("Array is Empty"); //out of bound
        }
        return arr[top--];

    }
    public T peek(){
        if(empty()){
            throw new IndexOutOfBoundsException("Array is Empty"); //out of bound
        }
        return arr[top];
    }
    public boolean empty(){ //checks if the array is empty
        if(top == -1){
            return true;
        }
        return false;

    }
    protected void grow_array(){ //doubles the size of the array
        T[] temp = (T[])(new Object[arr.length*2]);
        for(int i = 0; i < arr.length ; i++){
            temp[i] = arr[i];
        }
        arr = temp;

        /*T[] temp = (T[])(new Object[arr.length*2]);
        System.arraycopy(arr,0,temp,0,arr.length);
        arr = temp;*/
    }

}
