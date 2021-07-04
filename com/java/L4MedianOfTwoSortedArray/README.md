### find median of two sorted array
* Drop half of the partition every round until find the point where leftHalf of nums1 is less than rightHalf of nums2 and rightHalf of nums1 is greater than leftHalf of nums2

swap the shorter array as the first argument

```java
helper(nums1, nums2){
    int m = nums1.length;
    int n = nums2.length;
    if(m < n){
        return helper(nums2, nums1);
    }
}
```
calculate the median of each array
```java
int partX = (0 + m)/2;
int partY = (m + n + 1) / 2 - partX;
```

find the largest element before the partition in both array
```java
int leftX = partX == 0 ? Integer.MIN_VALUE: nums1[partX -1];
int leftY = partX == 0 ? Integer.MIN_VALUE: nums2[partY -1];

int rightX = partX == nums1.length ? Integer.MAX_VALUE: nums1[partX -1];
int rightY = partY == nums2.length ? Integer.MAX_VALUE: nums2[partY -1];
```

compare the lefts and rights
```java
if(leftX <= rightY && rightX >= leftY){
    if ((m + n) % 2 == 0){
        return (Math.max(leftX, leftY) + Math.min(rightX, rightY))/2.0;
    }
    else{
        return Math.max(leftX, leftY);
    }
       
}
```
fine ajust the partX based on the leftX and rightY ; rightX, leftY
```java
if(leftX > rightY){
    hi = partX -1;
}
else if(rightX < leftY){
    lo = partX + 1;    
}
```
finally continue the loop
```java
while(lo <= hi){
    //do above logics    
}
```
if no result returned within loop
return -1.0;
