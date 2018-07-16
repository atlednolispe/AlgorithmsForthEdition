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