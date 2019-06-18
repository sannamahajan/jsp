package com.lti.training.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/captcha.jpg")
public class CaptchaServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("image.jpeg");
		ServletOutputStream out = response.getOutputStream();
		
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String captcha="";
		Random r = new Random();
		StringBuilder sb = new StringBuilder(); 
		while (sb.length() < 6) { // length of the random string.
            int index = (int) (r.nextFloat() *str.length());
            sb.append(str.charAt(index));
        }
        captcha = sb.toString();
        
        /*
         * for(int i = 0; i<5; i++) {
         * 		int rno=(int) ((Math.random() * str.length());
         * 		captcha+=str,charAt(rno);
         * }	
         */
		
        // now the code to generate an image
        
        BufferedImage img = new BufferedImage(150, 50, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.RED);
        g.fillRect(0, 0, 150, 50);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Harrington", Font.BOLD,32));
        g.drawString(captcha, 30, 30);
        
        ImageIO.write(img, "jpeg", out);
	}

	
	
}
