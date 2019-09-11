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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidateCodeController {
	
	private static final int WIDTH=50;
	private static final int HEIGHT=24;
	private static final int LENGTH=4;
	
	@RequestMapping("/validateCode")
	public void ValidateCode(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//设置头不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		//设置MIME响应类型
		response.setContentType("image/jpeg");
		
		//构建一个图像对象
		BufferedImage img = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		
		//构建一个字体对象
		Font font = new Font("Arial",Font.TRUETYPE_FONT,18);
		//得到绘图对象
		Graphics g = img.getGraphics();
		//获取一个随机数对象
		Random rand = new Random();
		//ͨ通过绘对象绘制背景色
		g.setColor(new Color(rand.nextInt(55)+200,rand.nextInt(55)+200,rand.nextInt(55)+200));
		//绘制一个矩形
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//设置字体
		g.setFont(font);
		//绘制边框
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
		//产生随机的验证码
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
		//把验证码放入到session中
		HttpSession session = request.getSession();
		session.setAttribute("validate", validateSession);
		//绘制验证码
		g.drawString(validate, 6, 19);
		OutputStream out = response.getOutputStream();
		ImageIO.write(img, "JPEG", out);
	}
}
