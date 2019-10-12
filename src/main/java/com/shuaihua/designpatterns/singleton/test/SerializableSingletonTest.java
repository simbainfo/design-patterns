package com.shuaihua.designpatterns.singleton.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.shuaihua.designpatterns.singleton.serializable.SerializableSingleton;

/**
 * 
 * @author shuaihua
 *
 */

/**
 * 
test result: 
com.shuaihua.designpatterns.singleton.serializable.SerializableSingleton@33909752
com.shuaihua.designpatterns.singleton.serializable.SerializableSingleton@33909752
true
 */
public class SerializableSingletonTest {

	public static void main(String[] args) throws Exception {
		
		SerializableSingleton s1 = null;
		SerializableSingleton s2 = SerializableSingleton.getInstance();
		
		FileOutputStream fos = new FileOutputStream("SerializableSingletonTest.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s2);
		
		fos.close();
		oos.flush();
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SerializableSingletonTest.txt"));
		s1 = (SerializableSingleton)ois.readObject();
		ois.close();
		
		System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
	}
}
