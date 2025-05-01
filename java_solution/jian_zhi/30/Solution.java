// 请你设计一个 最小栈 。它提供 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

 

// 实现 MinStack 类:

// MinStack() 初始化堆栈对象。
// void push(int val) 将元素val推入堆栈。
// void pop() 删除堆栈顶部的元素。
// int top() 获取堆栈顶部的元素。
// int getMin() 获取堆栈中的最小元素。
 

// 示例 1：

// 输入：
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// 输出：
// [null,null,null,null,-3,null,0,-2]

// 解释：
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(2);
// minStack.push(-3);
// minStack.getMin();   --> 返回 -3.
// minStack.pop();
// minStack.top();      --> 返回 0.
// minStack.getMin();   --> 返回 -2.

/**
 * 辅助堆栈
 */
class MinStack {

    List<Integer> stack;
    List<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    
    public void push(int x) {
        stack.add(x);
        if(minStack.isEmpty()||minStack.get(minStack.size()-1)>=x){
            minStack.add(x);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        Integer x = stack.remove(stack.size()-1);
        if(x.equals(minStack.get(minStack.size()-1))){
            minStack.remove(minStack.size()-1);
        }
    }
    
    public int top() {
        return stack.get(stack.size()-1);

    }
    
    public int getMin() {
        return minStack.get(minStack.size()-1);
    }

    
}