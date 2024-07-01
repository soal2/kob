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


---

## 前端开发：

- `js`中 `==` 比较值（自动把变量变为字符串比较），`===` 会比较类型。
- 实现按钮交互：

```javascript
<button @click="script中的函数名称" type="button" class="btn btn-warning btn-lg">再来一次</button>
```

- `js`中常用的全局变量`useStore`：以`store` 对象实例，调用专门写出的 `.js` 文件中的`state`变量中的全局变量以实现前后端共同变量的统一。
- `return { restart, }; `和` return restart`的区别：
  - 前者返回对象，其中包含restart属性。
  - 后者返回restart变量。









---

## Java语法：

- `final`：
  1. 其修饰的**变量**被初始化后值就不变了
  2. 其修饰的**方法**被定义后就不能被重写
  3. 其修饰的**类**被定义后就不能被继承
- `try-catch-finaly`：
  - 不管有没有出现异常，`finally`代码块都会执行；
  - `try`中出现异常则执行`catch`，否则跳过；
  - 不管`try`和`catch`的代码块中有`return`时，`finally`仍会执行，且如果`finally`代码块也有`return`，则此代码肯定会返回`finally`执行的`return`值。





## 注意要点：

- `pojo`层定义数据表对应的类时，变量的顺序要与数据表中的列一致。

