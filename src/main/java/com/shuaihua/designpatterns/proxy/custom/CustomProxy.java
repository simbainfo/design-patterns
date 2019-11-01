package com.shuaihua.designpatterns.proxy.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * 
 * @author shuaihua
 *
 */
public class CustomProxy extends ClassLoader{
	
	private final static String LN = "\r\n";

	public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//1. 动态生成java源代码文件 
		String generateJavaSource = generateJavaSource(interfaces);
		//2.将java文件输出到磁盘
		String path = CustomProxy.class.getResource("").getPath();
		File file = new File(path + "$Proxy0.java");
		System.out.println(path);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(generateJavaSource);
		fileWriter.flush();
		fileWriter.close();
		
		//3.把生成的java文件编译成.class文件
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
        Iterable iterable = manage.getJavaFileObjects(file);

        JavaCompiler.CompilationTask task = compiler.getTask(null,manage,null,null,null,iterable);
        task.call();
        manage.close();
		
		//4.把编译生成的.class文件加载的jvm中
//        Class<?> proxyClass = len.loadClass("$Proxy0");
        FileInputStream in = new FileInputStream(path + "$Proxy0.class");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        byte[] buff = new byte[1024];
        int len;
        
        while ((len=in.read(buff)) != -1) {
			out.write(buff,0,len);
		}
        
        
        defineClass
        
        
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        
		
		//5.返回字节码重组以后的新的代理对象
        Object proxyObject = constructor.newInstance(h);
		
		return proxyObject;
	}
	
	private static String generateJavaSource(Class<?>[] interfaces) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("package com.shuaihua.designpatterns.proxy.custom;" + LN);
		sb.append("import java.lang.reflect.InvocationHandler;" + LN);
		sb.append("import java.lang.reflect.Method;" + LN);
		sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + LN);
		
		sb.append("private InvocationHandler h;" + LN);
		sb.append("public $Proxy0(InvocationHandler h){");
			sb.append("this.h = h;" + LN);
		sb.append("}"+LN);
		
		for (Method m : interfaces[0].getMethods()) {
			sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "() {" +LN);
				sb.append("try{" + LN);
					sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\""+ m.getName() +"\",new Class[]{});" +LN);
					sb.append("this.h.invoke(this,m,null);" + LN);
				sb.append("}catch(Throwable e){" + LN);
				sb.append("e.printStackTrace();" + LN);
                sb.append("}" + LN);
		
			sb.append("}" + LN);
		}
		
		sb.append("}" + LN);
		
		
		return sb.toString();
	}
	
	@Override
	private Class<?> defineClass(String name,byte[] b,int off,int len){
		
	}
}
