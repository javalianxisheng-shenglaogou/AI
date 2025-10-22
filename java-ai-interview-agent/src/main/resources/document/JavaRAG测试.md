**1. Java是什么？⭐⭐⭐**

**题目详细答案**

Java 是一种面向对象的编程语言和计算平台，最早由 Sun Microsystems 于 1995 年发布，后来被 Oracle 公司收购。Java 被广泛用于开发各种应用程序，从桌面应用到企业级服务器和移动应用。

java 具有以下特点：

**1、平台无关性**

Java 的口号是“编写一次，运行到处”（Write Once, Run Anywhere）。这主要是通过 Java 虚拟机（JVM）实现的，JVM 是一个可以在任何支持 Java 的平台上运行 Java 字节码的虚拟机。Java 源代码编译成字节码后，可以在任何安装了 JVM 的平台上运行，无需重新编译。

**2、面向对象**

Java 是一种面向对象的编程语言，支持封装、继承和多态等面向对象的基本概念。面向对象编程使代码更具模块化、可重用性和可维护性。

**3、简单**

Java 的语法与 C++ 类似，但去掉了 C++ 中一些复杂和容易出错的特性（如指针算术和多重继承），使其更简单易学。

**4、内存管理**

Java 使用自动垃圾回收机制（Garbage Collection）来管理内存。这意味着程序员不需要手动释放内存，减少了内存泄漏和其他内存管理错误的可能性。

**5、 多线程**

Java 内置了对多线程编程的支持，使得开发并发应用程序更加容易。Java 提供了丰富的线程 API 和高级并发工具类（如java.util.concurrent包）。

**6、 广泛的应用领域**

Java 被广泛应用于各个领域，包括：

• **企业级应用**：Java EE（Enterprise Edition）提供了开发企业级应用的标准平台。

• **移动应用**：Android 应用程序主要使用 Java 编写。

• **Web 应用**：Java 提供了多种框架和工具（如 Spring、Hibernate）来开发 Web 应用。

• **嵌入式系统**：Java 也可以用于开发嵌入式系统和物联网设备。

**7、社区和生态系统**

Java 拥有一个庞大而活跃的开发者社区和丰富的生态系统，提供了大量的开源库、框架和工具，帮助开发者快速构建高质量的应用程序。

**2. 介绍一下常见的list实现类⭐⭐⭐⭐⭐**

**ArrayList**

ArrayList 是最常用的 List 实现类，线程不安全，内部是通过数组实现的，继承了AbstractList，实现了List。它允许对元素进行快速随机访问。数组的缺点是每个元素之间不能有间隔，当数组大小不满足时需要增加存储能力，就要将已经有数组的数据复制到新的存储空间中。当从 ArrayList 的中间位置插入或者删除元素时，需要对数组进行复制、移动、代价比较高。因此，它适合随机查找和遍历，不适合插入和删除。排列有序，可重复，容量不够的时候，新容量的计算公式为：

newCapacity = oldCapacity + (oldCapacity >> 1)，这实际上是将原容量增加50%（即乘以1.5）。

ArrayList实现了RandomAccess接口，即提供了随机访问功能。RandomAccess是java中用来被List实现，为List提供快速访问功能的。在ArrayList中，我们即可以通过元素的序号快速获取元素对象，这就是快速随机访问。

ArrayList实现java.io.Serializable接口，这意味着ArrayList支持序列化，能通过序列化去传输。

**LinkedList（链表）**

LinkedList 是用链表结构存储数据的，线程不安全。很适合数据的动态插入和删除，随机访问和遍历速度比较慢，增删快。另外，他还提供了 List 接口中没有定义的方法，专门用于操作表头和表尾元素，可以当作堆栈、队列和双向队列使用。底层使用双向链表数据结构。

LinkedList是一个继承于AbstractSequentialList的双向链表。它也可以被当作堆栈、队列或双端队列进行操作。

**Vector（数组实现、线程同步）**

Vector 与 ArrayList 一样，也是通过数组实现的，Vector和ArrayList用法上几乎相同，但Vector比较古老，一般不用。Vector是线程同步的，效率低。即某一时刻只有一个线程能够写 Vector，避免多线程同时写而引起的不一致性，但实现同步需要很高的花费，因此，访问它比访问 ArrayList 慢。默认扩展一倍容量。

**3. ArrayList初始容量是多少？⭐⭐⭐⭐⭐**

**题目详细答案**

ArrayList 是 Java 中用于动态数组的一个类。它可以在添加或删除元素时自动调整其大小。然而，ArrayList 有一个默认的初始容量，这个容量是在你创建 ArrayList 实例时如果没有明确指定容量参数时所使用的。

在 Java 的 ArrayList 实现中，默认的初始容量是 10。这意味着当你创建一个新的 ArrayList 而不指定其容量时，它会以一个内部数组长度为 10 的数组来开始。当添加的元素数量超过这个初始容量时，ArrayList 的内部数组会进行扩容，通常是增长为原来的 1.5 倍。

Java ArrayList<String> list = new ArrayList<>(); // 默认的初始容量是 10

但是，如果你知道你将要在 ArrayList 中存储多少元素，或者预计会存储多少元素，那么最好在创建时指定一个初始容量，这样可以减少由于扩容而导致的重新分配数组和复制元素的操作，从而提高性能。

Java ArrayList<String> list = new ArrayList<>(50); // 初始容量设置为 50

自从1.7之后，arraylist初始化的时候为一个空数组。但是当你去放入第一个元素的时候，会触发他的懒加载机制，使得数量变为10。

Java private static int calculateCapacity(Object[] elementData, int minCapacity) { if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) { return Math.max(DEFAULT_CAPACITY, minCapacity);      }      return minCapacity;    }

所以我们的arraylist初始容量的确是10。只不过jdk8变为懒加载来节省内存。进行了一点优化。



 

 

 

 