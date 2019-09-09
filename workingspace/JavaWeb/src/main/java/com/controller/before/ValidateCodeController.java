package com.controller.before;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidateCodeController {
	
	private static final int WIDTH=50;
	private static final int HEIGHT=24;
	private static final int LENGTH=4;
	
	@RequestMapping("/validateCode")
	public void ValidateCode(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//����ͷ������
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		//����MIME��Ӧ����
		response.setContentType("image/jpeg");
		
		//����һ��ͼ�����
		BufferedImage img = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		
		//����һ���������
		Font font = new Font("Arial",Font.TRUETYPE_FONT,18);
		//�õ���ͼ����
		Graphics g = img.getGraphics();
		//�½����������
		Random rand = new Random();
		//ͨ����ͼ������Ʊ���ɫ
		g.setColor(new Color(rand.nextInt(55)+200,rand.nextInt(55)+200,rand.nextInt(55)+200));
		//����һ������
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//������������
		g.setFont(font);
		//���Ʊ߿�
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
		//�����������֤��
		String validate="";
		int randInt = 0;
		int[] validateSession = new int[4];
		for(int i=0;i<=3;i++) {
			while(true) {
				randInt = rand.nextInt(8);
				if(randInt >=0 && randInt <=9) {
					break;
				}
			}
			validateSession[i] = randInt;
			validate += String.valueOf(randInt);
		}
		//����֤����뵽session��
		HttpSession session = request.getSession();
		session.setAttribute("validate", validateSession);
		//������֤��
		g.drawString(validate, 6, 19);
		OutputStream out = response.getOutputStream();
		ImageIO.write(img, "JPEG", out);
	}
}
