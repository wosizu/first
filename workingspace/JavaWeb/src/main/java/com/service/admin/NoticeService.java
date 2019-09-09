package com.service.admin;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.admin.GoodsDao;
import com.dao.admin.NoticeDao;
import com.entity.Goods;
import com.entity.Notice;
import com.exception.LossInfoException;
import com.service.ServiceUtil;
import com.util.MyUtil;


@Service
public class NoticeService {
	@Autowired
	NoticeDao dao;
	
	Notice notice;
	HttpServletRequest request;
	
	//ͨ�������������������������ɾ�Ĳ�ķ������������Լ���Contorller��Ĵ��룬���жϷ������߼�Ҳ��������
	public String baseMethod(HttpServletRequest request) throws Exception {
		this.request = request;
		//ͨ��������������зǿ��жϣ�Ȼ��ֱ�ӵ��ô��goods�ķ���
		this.ensureNotEmpty(request);
		//ͨ�����������÷���������������if else
		String jsp = (String)this.getClass().getMethod(request.getParameter("method")+"Notice", Notice.class).invoke(this, this.notice);
		return jsp;
	}
	
	public String addNotice(Notice notice) {
		try {
			if(notice.getId() == 0 || notice.getTime() == null || notice.getTitle() == null || notice.getContent() == null) {
				throw new LossInfoException();
			}
			int changed = dao.addNotice(notice);
			this.request.setAttribute("changed", changed);
			System.out.println("����ִ�����");
			return ServiceUtil.PATH_RESULT;
		}catch(Exception e) {
			return ServiceUtil.PATH_ERROR;
		}
		
	}
	
	public String deleteNotice(Notice notice) {
		try{
			
			if(notice.getId() == 0) {
				throw new LossInfoException();
			}
			int changed = dao.deleteNotice(notice.getId());
			this.request.setAttribute("changed", changed);
			System.out.println("����ִ�����");
			return ServiceUtil.PATH_RESULT;
		}catch(Exception e){
			return ServiceUtil.PATH_ERROR;
		}
		
	}
//	
	public String updateNotice(Notice notice) {
		try {
			if(notice.getId() == 0) {
				throw new LossInfoException();
			}
			int changed = dao.updateNotice(notice);
			this.request.setAttribute("changed", changed);
			System.out.println("ִ�����");
			return ServiceUtil.PATH_RESULT;
		}catch(Exception e) {
			return ServiceUtil.PATH_ERROR;
		}
	}
//	
	public String queryNotice(Notice Notice) {
		try {
			if(notice.getId() == 0) {
				throw new LossInfoException();
			}
			notice = dao.queryNotice(notice.getId());
			this.request.setAttribute("type", notice);
			System.out.println("����ִ�����");
			return ServiceUtil.PATH_RESULT;
		}catch(Exception e) {
			e.printStackTrace();
			return ServiceUtil.PATH_ERROR;
		}
	}
//	
	//�����ǹ��߷���
	public void packingNotice(int id,String title,String content) {
		
		
		Notice notice = new Notice();
		notice.setId(id);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setTime(MyUtil.getTime());
		this.notice = notice;
	}
	
	public void ensureNotEmpty(HttpServletRequest request) throws Exception {
		//�Ȼ�ȡ���еĲ���
		String title=null;
		String content = null;
		int id = 0;
		
		if(!request.getParameter("id").equals("")) {
			id = Integer.valueOf(request.getParameter("id"));
		}
		if(!request.getParameter("title").equals("")) {
			title = MyUtil.changeCoded(request.getParameter("title"));
		}
		if(!request.getParameter("content").equals("")) {
			content = MyUtil.changeCoded(request.getParameter("content"));
		}
		
		
		System.out.println("id:"+id);
		System.out.println("title:"+title);
		System.out.println("content:"+content);
		
		packingNotice(id,title,content);
		
	}
	
	
	
}
