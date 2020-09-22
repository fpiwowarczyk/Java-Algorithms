package test;

import static Search.BinarySearch.find;

public class TestSearch {

    public void testBinarySearch(){
        int array[]  = new int[100];
        for(int i=0;i<array.length;++i){
            array[i]=i;
        }

        System.out.println("Value 32 is on index: "+find(array,32));
        assert array[find(array,32)] == 32;

        for(int i=0;i<array.length;++i){
            array[i]=i*2;
        }

        System.out.println("Value 32 is on index: "+find(array,32));
        assert array[find(array,32)] == 32;
        int size = 10000;
        int array2[] = new int[size];
        for(int i=0;i<array2.length;++i){
            array2[i]=i*2;
        }
        int valueToFind = 432;
        System.out.println("Value "+valueToFind+" is on index: "+find(array2,valueToFind));
        assert array2[find(array2,valueToFind)] == 432;
    }
}
