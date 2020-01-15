package com.demo.index;

import com.demo.commen.LoginInterceptor;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * IndexController
 */
@Clear(LoginInterceptor.class)
public class IndexController extends Controller {

	public void index() {
		render("index.html");
	}
}



