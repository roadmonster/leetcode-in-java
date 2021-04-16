### Leetcode 1122 Relative Sort Array

* The second solution is a failed attempt. It attempts to turn arr1 into a dict and use a loop based on arr2 to find the
  frequency of arr2's object and render that amount of arr2's object in result array.

* There is a problem in how to deal with the leftover objects in the arr1's dict, algorithm has to remove keys and get
the key set in order to get all the keys, and also get the counter of each key, which is real trouble.

```java
for(int q: myList){
     if(q == arr2[i])
     myList.remove(new Integer(arr2[i]));
     }
```

* The original solution uses arr2's objects as keys in map.
Then it steps through arr1 and check if current object exists or not
  at arr2, if so then update the frequency. Otherwise, add it to the leftover arrayList.
  
```java
int i = 0, index = 0;
        while(i < result.length && index < arr2.length){
            int count = map.get(arr2[index]);
            while(count > 0){
                result[i++] = arr2[index];
                count--;
            }
            index++;
        };
```
* Finally solution 1 step through arr2 and update the result array by the map's frequency value.
The leftover if not empty shall be sorted and appended at the end of the result array.
  