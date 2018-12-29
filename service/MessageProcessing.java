package com.anweitech.teacher.service;

public interface MessageProcessing {
	
	//用于对学生端发送来的请求进行处理
	void message(String text);
}
