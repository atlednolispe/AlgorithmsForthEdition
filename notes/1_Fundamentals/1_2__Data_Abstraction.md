chapter1.2-Data Abstraction
===========================

### 1.2.1 使用抽象数据类型

```java
// 1. 分配内存 2. 构造函数初始化对象 3.返回对象的引用
Counter heads = new Counter("heads");

// 所有非原始数据类型的值都是对象,数组也是对象
```

### 1.2.2 抽象数据类型举例

```
// 实例变量声明需要一个可见性修饰符
```

## Exercises

### 判断数组中是否存在某个值

[test if an array contains a certain value](https://stackoverflow.com/questions/1128723/how-can-i-test-if-an-array-contains-a-certain-value)

```java
// for arrays of primitives, it's useless
import java.util.Arrays;
Arrays.asList(yourArray).contains(yourValue);

// since java8
import java.util.stream.IntStream;
int[] a = {1,2,3,4};
boolean contains = IntStream.of(a).anyMatch(x -> x == 4);
```