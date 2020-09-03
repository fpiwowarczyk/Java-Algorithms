package Queue;
/*
* My first try with generic type data struct
*
* GenericQueue works as normal queue
* but holds elements of types to-be-specified at runtime
* The elements are added fist are the first to be removed
* New Elements are added to the back of queue
 */


import java.util.ArrayList;

public class GenericQueue<T> {
    ArrayList<T> queueArr = new ArrayList<T>();

    private Boolean hasElements(){
        return !queueArr.isEmpty();
    }

    public T peek(){
        T result = null;
        if(this.hasElements()){result = queueArr.get(0);}
        return result;
    }
    public Boolean add(T element) {
        return queueArr.add(element);
    }

    public T poll(){
        T result = null;
        if(this.hasElements()){result = queueArr.remove(0);}
        return result;
    }

}
