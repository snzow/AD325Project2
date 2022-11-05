package hasheddictionary;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class HashTableTest {


    @Test
    public void testCreation(){
        HashTable test = new HashTable();
        assert(test.getCapacity() == 17);
    }

    @Test
    public void testCreation2(){
        HashTable test = new HashTable(4000);
        assert(test.getCapacity() == 4000);
    }

    @Test
    public void testPut1(){
        HashTable test = new HashTable();
        for (int i = 0; i < 8; i++){
            test.put(i,i);
        }
        for(int i = 0; i < 8; i++){
            assert((int)test.get(i) == i);
        }
    }

    @Test
    public void testGrowIfNeeded(){
        HashTable test = new HashTable();
        for (int i = 0; i < 15; i++){
            test.put(i,i);
        }
        for(int i = 0; i < 15; i++){
            assert((int)test.get(i) == i);
        }
    }

    @Test
    public void testRemove1(){
        HashTable test = new HashTable();
        for (int i = 0; i < 15; i++){
            test.put(i,i);
        }
        int tmp = (int)test.remove(14);
        assert(tmp == 14);
    }
    @Test
    public void testRemove2(){
        HashTable test = new HashTable();
        for (int i = 0; i < 15; i++){
            test.put(i,i);
        }
        test.put(-5,30);
        int tmp = (int)test.remove(-5);
        assert(tmp == 30);
    }

    @Test
    public void testRemove3(){
        HashTable test = new HashTable();
        for (int i = 0; i < 15; i++){
            test.put(i,i);
        }
        test.put(100000,30);
        int tmp = (int)test.remove(100000);
        assert(tmp == 30);
    }

   @Test
    public void testContains1(){
       HashTable test = new HashTable();
       for (int i = 0; i < 15; i++){
           test.put(i,i);
       }
       assert(test.containsKey(11));
   }

    @Test
    public void testContains2(){
        HashTable test = new HashTable();
        for (int i = 0; i < 15; i++){
            test.put(i,i);
        }
        assert(test.containsKey(300) == false);
    }

    @Test
    public void testContains3(){
        HashTable test = new HashTable();
        for (int i = 0; i < 15; i++){
            test.put(i,i);
        }
        assert(test.containsKey(-11) == false);
    }


}
