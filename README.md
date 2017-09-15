# MVP
该demo展示了mvp设计模式在安卓中的应用

- M-->Model层负责业务逻辑以及网络数据的请求处理以及数据的封装
- V-->View层则是以我们的Activity或者Fragment来作为展示
- P-->Presenter层作为连接Viwe层与Model层的一个桥梁（中间者）

分析：
1. 我们的View层需要的是数据，那我们创建IView接口来指定具体的方法参数为我们需要的最终数据，让Activity或Fragment实现该接口
2. Model层是用来处理逻辑，我们创建IModel接口来指明每个业务方法，创建实现类来具体处理。
3. 如何关联？创建Presenter中间人进行关联，让Presenter中t同时持有IView实例以及IModel实例即可关联。
4. 如何触发？在View层创建P层对象调用即可。

伪代码：

View层
```
//View层接口
public interface IView{
  void showData(List<User> users);
  ...
}
//View层
public class MainActivity extends AppCompatActivity implements IView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ...
        //实例化P并触发调用
        new UserPresenter(this).fetch();
    }
    
    @Override
    public void showData(List<User> users){
      //数据展示
    }
}
```
Model层
```
//业务接口
public interface IModel{
  //业务方法
  void loadUsers(CallBack callBack);
}

//数据回掉接口
public interface CallBack<T>{
  void onComplete(T t)
}

//业务实现类
public class UserModelImpl implements IModel{
  
    @Override
    public void loadUsers(CallBack<T> callBack);
      //业务处理，通过网络加载数据
      ...
      if(callBack != null){
        callBack.onComplete(users);
      }
    }
}
```
Presenter层
```
public class UserPresenter{

  //持有View层实例
  private IView mView;
  //持有Model层实例
  private IModel mModel = new UserModelImpl();
  
  public UserPresenter(IView mView){
    this.mView = mView;
  }
  
  //触发调用
  public void fetch(){
    mModel.loadUsers(new CallBack<List<User>>(){
    
      @Override
      public void onComplete(List<User> users){
        //将数据传递给View层显示
        mViwe.showData(users);
      }
    });
  }
}
```

以上就基本实现了MVP设计模式在安卓中的应用，代码虽看起来多，但是它将层次分的很清楚，扩展性强，解除了View层与Model层的依赖，解耦。

但是这样写会发现P层持有View层的强引用，而我们的View层随时都可能会关闭，这就导致了内存泄漏问题。

如何解决？我们可以在P层对View层的实例进行弱引用来解决，同时利用Activity的生命周期进行一个绑定与解绑，具体实现代码中详见。
