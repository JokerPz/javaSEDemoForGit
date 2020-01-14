package com.joker.logger;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author joker
 * @ClassName CommonLoggerTest
 * @
 * 这个是Jdk自带的log功能，可以输入日志到console，定位到方法，是平时做项目的时候常用的工具，不过
 * 大多数用的是Log4j或者其他，这里只是熟悉一下log功能，这里发现了一个问题，就是等级设置到info以下
 * 时，还是打印不出info以下的日志，待解决
 */
public class JDKLoggerTest {
	public static void main(String[] args) {
		Logger LOGGER = Logger.getLogger(JDKLoggerTest.class.toString());
		//已经过时的获取logger对象方法。
//		Logger LOGGER = Logger.getGlobal();
		LOGGER.info(LOGGER.getParent().getLevel().toString());
		LOGGER.setLevel(Level.CONFIG);
		LOGGER.finest("finest等级");
		LOGGER.finer("finer等级");
		LOGGER.fine("fine等级");
		LOGGER.config("cofig等级");
		LOGGER.info("info等级");
		LOGGER.warning("warning等级");
		LOGGER.severe("server等级");
//		test();
	}
	public static void test() {
		Logger LOGGER = Logger.getLogger(JDKLoggerTest.class.toString());
		LOGGER.finest("test的finest等级");
		LOGGER.finer("test的fine等级");
		LOGGER.fine("test的fine等级");
		LOGGER.config("test的cofig等级");
		LOGGER.info("test的info等级");
		LOGGER.warning("test的warning等级");
		LOGGER.severe("test的server等级");
	}
}
