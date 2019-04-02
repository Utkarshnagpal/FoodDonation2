package com.mvc.daointerface;

import java.util.ArrayList;

import com.mvc.bean.MyBean1;

public interface MyInterface1 {
	int autoGenerateSid();
String insert1(MyBean1 s);
boolean update1(MyBean1 name);
ArrayList<MyBean1> displayAll();
}