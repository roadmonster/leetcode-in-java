### 3 sum
#### need to avoid repeatation

* sort the array in place
* loop through each element
* if element greater than 0 break
* if index > 0 and element equals previous element
conitue
* have j pointing to index + 1 to last of nums
* check map.containsKey(-(nums[index] + nums[j]))
* if so we have a triplet {index, j, map.get(-sum)}
    * make sure nums[j] not equals to nums[j-1] since 
    3 sum has index fixed, j equals to previous, then last
      one must be the same, hence repeat the previous result
  * We can increment j if nums[j] == nums[j+1] ##### be sure to have j < nums.length -1###
  
### Careful doing the helper method, need to reinitialize new HashSet everytime
### Reason is you only care about the existence of compliment of within the j to the end