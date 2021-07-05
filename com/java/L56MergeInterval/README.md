### Merge Intervals

* algorithm:
1. put all elements of original array into priority queue(heap sort)
2. heap sorted by (a,b)->(a[0]-b[0]) start time non decending order
3. pop the earliest one and compare with the top of the queue
4. if the popped one's end time greater than the top's start time-> overlap
5. offer queue new element popped[0], max(popped[1], top[1])
6. if popped one no overlap with top, insert into result list
7. if heap only has one element, then insert into result list
8. turn result list into 2d array
