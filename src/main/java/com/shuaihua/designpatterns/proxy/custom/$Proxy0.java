package com.shuaihua.designpatterns.proxy.custom;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class $Proxy0 implements com.shuaihua.designpatterns.proxy.custom.Person{
private InvocationHandler h;
public $Proxy0(InvocationHandler h){this.h = h;
}
public void buyHouse() {
try{
Method m = com.shuaihua.designpatterns.proxy.custom.Person.class.getMethod("buyHouse",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){
e.printStackTrace();
}
}
public void findLove() {
try{
Method m = com.shuaihua.designpatterns.proxy.custom.Person.class.getMethod("findLove",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){
e.printStackTrace();
}
}
public void findJob() {
try{
Method m = com.shuaihua.designpatterns.proxy.custom.Person.class.getMethod("findJob",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){
e.printStackTrace();
}
}
}
