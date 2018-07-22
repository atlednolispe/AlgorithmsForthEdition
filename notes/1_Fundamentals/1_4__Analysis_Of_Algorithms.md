chapter1.4-Analysis of algorithms
=================================

### 1.4.1 科学方法

观察、假设、预测、核实、反复

实验需要可重现、可证伪

### 1.4.2 观察

```bash
// 执行某个jar包中的指定类
java -cp algs4/algs4.jar edu.princeton.cs.algs4.ThreeSum ~/Downloads/4Kints.txt
```

### 1.4.3 数学模型

程序运行总时间:

1. 执行每条语句的耗时
2. 执行每条语句的频率

### 1.4.6 倍率实验

估计运行时间的增长数量级

### 1.4.7 注意事项

### 1.4.8 处理对于输入的依赖

### 1.4.9 内存

```
int     : 32 bit
char    : 16 bit
double  : 64 bit
boolean :  8 bit
```

对象:
1. 对象本身开销 16byte
2. 实例变量的内存
3. 填充字节补充为8的倍数
4. 引用开销 8byte 64bit地址
5. 非静态内部类需要指向外部类的引用 8bit

String:
char[] value
int offset
int count
int hash

substring共用value修改offset


### 1.4.10 展望

时间大概率被决定于内循环

## coursera

string: s + t -> c * N

## Interview Questions

TODO

```java
/**
 * 3-SUM in quadratic time
 *
 * Design an algorithm for the 3-SUM problem that takes time
 * proportional to n^2 in the worst case. You may assume that you can sort the nn integers in
 * time proportional to n^2 or better.
 */
```

```java
/**
 * Search in a bitonic array
 *
 * An array is bitonic if it is comprised of an increasing sequence
 * of integers followed immediately by a decreasing sequence of integers. Write a program
 * that, given a bitonic array of nn distinct integer values, determines whether a given integer
 * is in the array.
 *
 * Standard version: Use ∼3lgn compares in the worst case.
 * Signing bonus: Use ∼2lgn compares in the worst case (and prove that no algorithm can
 * guarantee to perform fewer than ∼2lgn compares in the worst case).
 */
```

```java
/**
 * Egg drop
 *
 * Suppose that you have an nn-story building (with floors 1 through nn) and plenty
 * of eggs. An egg breaks if it is dropped from floor TT or higher and does not break
 * otherwise. Your goal is to devise a strategy to determine the value of TT given the
 * following limitations on the number of eggs and tosses:
 *
 * Version 0: 1 egg, ≤T tosses.
 * Version 1: ∼1lgn eggs and ∼1lgn tosses.
 * Version 2: ∼lgT eggs and ∼2lgT tosses.
 * Version 3: 2 eggs and ∼2*sqrt(n) tosses.
 * Version 4: 2 eggs and ≤c*sqrt(T) tosses for some fixed constant c.
 */
```