package Search;

public class BinarySearch {

    public static int find(int[] array,int key){
        int max_index=array.length-1;
        int min_index=0;
        return Search(array,key,min_index,max_index);

    }
    public static int Search(int[] array, int key, int min_index, int max_index){
        if(array[max_index]>key&&array[min_index]<key){
            int newIndex = (max_index - min_index)/2;
            if(array[max_index-newIndex]>key){
                return Search(array,key,min_index,max_index-newIndex);
            } else{
                return Search(array,key,min_index+newIndex,max_index);
            }
        }else {
            if(array[max_index]==key){
                return max_index;
            } else if ( array[min_index]==key){
                return min_index;
            } else {
                System.out.println("Value not found");
                return -1;
            }
        }
    }


}
