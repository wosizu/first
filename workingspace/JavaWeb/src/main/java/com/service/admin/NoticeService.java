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

	//通过这个方法来调用其他几个增删改查的方法，这样可以减少Contorller类的代码，把判断方法的逻辑也放在这里
	public String baseMethod(HttpServletRequest request) throws Exception {
		this.request = request;
		//通过这个方法来进行非空判断，然后直接调用打包goods的方法
		this.ensureNotEmpty(request);
		//通过反射来调用方法，这样来减少if else
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
			System.out.println("方法执行完毕");
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
			System.out.println("方法执行完毕");
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
			System.out.println("执行完毕");
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
			System.out.println("方法执行完毕");
			return ServiceUtil.PATH_RESULT;
		}catch(Exception e) {
			e.printStackTrace();
			return ServiceUtil.PATH_ERROR;
		}
	}
	//
	//下面是工具方法
	public void packingNotice(int id,String title,String content) {


		Notice notice = new Notice();
		notice.setId(id);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setTime(MyUtil.getTime());
		this.notice = notice;
	}

	public void ensureNotEmpty(HttpServletRequest request) throws Exception {
		//先获取所有的参数
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
