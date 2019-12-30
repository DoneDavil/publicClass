package com.xiaomi.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UploadUtils {
	// �ϴ��ķ���
	public static String upload(String errorPath,Part part, HttpServletRequest request, HttpServletResponse response) {

		// ��ȡ�ļ���
		String photo = part.getSubmittedFileName();
		photo = UUID.randomUUID() + photo;//���ͬ���ļ�������
		// ��ȡ���ļ��ĺ�׺����,���������ж�
		String type = photo.substring(photo.lastIndexOf(".") + 1);
		// System.out.println(type);
		if (!("png".equalsIgnoreCase(type) || "jpg".equalsIgnoreCase(type) || "jpeg".equalsIgnoreCase(type))) {
			request.setAttribute("msg", "ͷ�����ͱ�����png,jpg,jpeg��ʽ��ͼƬ");
			try {
				request.getRequestDispatcher(errorPath).forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			photo = "";
		}
		// Ϊ�˱�֤ͼƬ������ȡ,���ǽ�ͼƬ�ϴ���tomcat�������ڲ�
		String path = "F:/xmpic";
		// System.out.println(path);
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		try {
			part.write(path + "/" + photo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return photo;
	}

}
