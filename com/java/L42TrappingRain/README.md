### Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
* idea: water would be trapped between two bars between which no other bars taller than them.
* The amount of water decided by the lower bar of the two
* maintain a stack to track columns
* 1. if current column taller than or equal to the top of the stack, begin process
    2. pop the top of the stack, peek the top the stack. 
       Keep popping if current peek is less or equal to
       the top until reach one (st.peek() > current popped)
       Then we have the left bound(st.peek()) and right 
       bound(st.top()), calculate the distance between their index, 
       multiply it with the min(left, right).
   3. add the result to the total and push current
    value into stack.(We actually got rid of all the left values
      in the stack that is shorter than the top, and we use the top
      as the left bound of another poll)
  4. if current column smaller than top, then simply push it
    5. In this way, we calcaulated the height of each poll as we move on
