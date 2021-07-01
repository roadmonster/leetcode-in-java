### Two Sum
1. Brute force using selection sort(nested for loop) efficiency O(n^2)
2. Using map to remember the index of visited elements. Iterates through the array
and check if map has value indexed by target - curr-value, if there is return current
   index and map[target-currIndex]
   ```java
    if(map.containsKey(target -nums[i])
        return new int[]{i, map.get(target - nums[i])}
   
```
                