package com.xiaomi.utils;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 
 * @author Administrator
 *	����ר��ΪQueryRunner�ṩ����Դ
 */
public class DruidUtils {
	private static DataSource dataSource = null;
	
	static {
		Properties properties = new Properties();
		try {
			//��������Դ�������������,����Ĭ���Զ�ȥ��ȡsrc�µ��ļ�
			InputStream asStream = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
			properties.load(asStream);
			dataSource = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}
















