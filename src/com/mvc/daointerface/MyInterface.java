package com.mvc.daointerface;

import java.util.ArrayList;

import com.mvc.bean.MyBean3;

public interface MyInterface {
	int autoGenerateSid();
String insert(MyBean3 s);
boolean update(MyBean3 name);
ArrayList<MyBean3> displayAll();
}