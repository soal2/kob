# 一个伟大的项目

## 后端开发：

- **基本流程**

  1. 建立数据表。

  2. 在`pojo`文件夹下新建类`XXX`，映射数据表中的条目。

  3. `pojo`写完后写`mapper`文件夹下的`XXXMapper`，实现接口。

     ```java
     @Mapper
     public interface XXXMapper extends BaseMapper<XXX> {
     }
     ```

  4. 在`service`文件夹下创建该数据表对应的文件夹定义相关操作的接口文件`XXXService`。

  5. 在`service/impl`文件夹下创建该数据表对应的文件夹定义接口的具体实现。

  6. 在`controller`文件夹下创建该数据表对应的文件夹实现`XXXController`。

- 哇撒

---

## 前端开发：











---

## Java语法：

- `final`：
  1. 其修饰的**变量**被初始化后值就不变了
  2. 其修饰的**方法**被定义后就不能被重写
  3. 其修饰的**类**被定义后就不能被继承
- 

