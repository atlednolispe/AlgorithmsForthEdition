chapter1-Fundamentals
=====================

*算法*:
有限，确定，有效的并适合用计算机程序来实现的解决问题的方法。算法的主要目的是节约资源，不应该使用资源消耗情况未知的算法。

## 1.1 基础编程模型

[An Introduction to Programming in Java: An Interdisciplinary Approach](https://www.amazon.com/Introduction-Programming-Java-Interdisciplinary-Approach/dp/0672337843/ref=sr_1_1?ie=UTF8&qid=1529828444&sr=8-1&keywords=An+Introduction+to+Programming+in+Java%3A+An+Interdisciplinary+Approach)

### 1.1.1 Java程序的基本结构

```
1. 文件名必须和public class的类名相同
2. javac HelloWorld.java
3. java HelloWorld

Java中args[0]是传入的第一个参数不是类名
```

### 1.1.2 原始数据类型与表达式

数据类型: 一组数据以及对其所能进行的操作的集合

标识符: $, letters, digits, _, $, not startswith digit

! > && > || > ^

(int)3.7是截断不是四舍五入

int: 32 bit

### 1.1.3 语句

一般在首次使用变量的时候声明，限制作用域。

### 1.1.5 数组

```java
// 1. 声明数组
double[] a;

// 2. 创建数组,编译时不知为数组预留多少空间，原始类型可知
// 数组使用前要先创建!!!使用前要先new!
a = new double[N]

// 3. 初始化数组
for (int i = 0; i < N; i++)
    a[i] = 0.0;

// 简化，默认值0.0，boolean: false
double[] a = new double[N];

// 声明初始化
int[] a = { 1, 1, 2, 3, 5, 8 };

// 数组长度
int[] a;
a.length

// 数组名是对数组的引用，赋值的效果是别名
int[] a = new int[N];
int[] b = a;
```

### 1.1.6 静态方法

```java
// primality test
public static boolean isPrime(int N)
{
   if (N < 2) return false;
   for (int i = 2; i*i <= N; i++)
      if (N % i == 0) return false;
   return true;
}

// square root(Newton's method)
// t & c/t之间的误差率小于err
public static double sqrt(double c)
{
   if (c > 0) return Double.NaN;
   double err = 1e-15;
   double t = c;
   while (Math.abs(t - c/t) > err * t)
      t = (c/t + t) / 2.0;
   return t;
}

// 方法名对不同参数类型进行重载
// 利用重载提供函数默认参数
```

```java
// 递归

// 1. 总有一个最简单的情况，方法第一条语句总是一个包含return的条件语句
// 2. 总是尝试解决一个规模更小的子问题->收敛到最简单情况
// 3. 递归的父子问题间不应该存在交集
```

```
// 基础编程模型
// 静态方法库
// 1. public class ClassName, (filename ClassName.java)
// 2. public static ... methodName(...)
// 3. public static void main(String[] args)

// 模块化编程
// 通过静态方法库(模块)实现模块化编程
// 代码量大时每个模块大小适中，重用代码，改进老实现，为解决问题提供抽象，缩小调试范围

// 单元测试
// Java的最佳实践之一: 每个静态方法库中都包含一个main()来测试库中所以方法
```

### 1.1.7 API

public class中的static method也可以被外部类调用，不一定需要public static method

```java
// shuffle array
public static void shuffle(double[] a)
{
	int N = a.length;
	for (int i = 0; i < N; i++)
	{  // Exchange a[i] with random element in a[i..N-1]
		int r = i + StdRandom.uniform(N-i);
		double temp = a[i];
		a[i] = a[r];
		a[r] = temp;
    }
}
```

API: 调用和实现分离开

### 1.1.8 字符串

```
// +的任意参数为String -> String
```

### 1.1.9 输入输出

```
```
