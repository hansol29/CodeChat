package com.codeChat.controller.action;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.UserDAO;


public class FindPwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "ProjectServlet?command=emailSent";
		
		String userId = request.getParameter("id"); 
		String userEmail = request.getParameter("email");

		UserDAO userDAO = UserDAO.getInstance();
		String tmpPwd = userDAO.getRandomPwd(8);
		
		System.out.println("tmpPwd : " + tmpPwd);
		
		Cookie cookie = new Cookie(userId, tmpPwd);
		cookie.setMaxAge(60 * 5);
		response.addCookie(cookie);
		
		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta charset=\"UTF-8\">");
		sb.append("<title>고객센터</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<div style='width:700px;height:150px;background-image:url(../upload/humanLogo.jpg) no-repeat scroll left top;'>\r\n"
				+ "</div>");
		sb.append("<h1 style='font:bold;'>비밀번호 임시코드 발송 안내입니다.</h1>");
		sb.append("<h4>" + userId + "님! 안녕하세요.</h4><br>");
		sb.append("<h4>CodeChat을 이용해 주셔서 진심으로 감사드립니다.</h4><br>");
		sb.append("<h4>아래 '임시 비밀번호'를 사용해서 로그인을 해주세요.</h4><br><br>");
		sb.append("<h2>");
		sb.append(tmpPwd);
		sb.append("</h2>");
		sb.append("<hr>");
		sb.append("<h3>임시 비밀번호는 '5분간' 유지됩니다.</h3>");
		sb.append("</body>");
		sb.append("</html>");
		
		
		Properties p = new Properties(); // 정보를 담을 객체
		p.put("mail.smtp.host","gmail-smtp.l.google.com"); // 네이버 SMTP
		
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		// SMTP 서버에 접속하기 위한 정보들
		
		//사용자가 관리자에게 문의를 하는 구조 - 결국 나에게 내가 이메일을 보낸다
		try{
		    Authenticator auth = new SMTPAuthenticator();
		    Session ses = Session.getInstance(p, auth);
		    
		    ses.setDebug(true);
		    
		    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
		    msg.setSubject("휴먼스호텔"); // 제목
		    
		    Address fromAddr = new InternetAddress("jamesseo4707@gmail.com");
		    msg.setFrom(fromAddr); // 보내는 사람
		    
		    Address toAddr = new InternetAddress(userEmail);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
		    
		    msg.setContent(sb.toString(), "text/html;charset=UTF-8"); // 내용과 인코딩
		    
		    Transport.send(msg); 
		} catch(Exception e){
		    e.printStackTrace();
		    System.out.println("error");
		}
		
		
		request.getRequestDispatcher(url).forward(request, response);
	}
 
	
	

}
