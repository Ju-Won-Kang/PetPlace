package com.petplace.adopt.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import com.petplace.adopt.model.service.AdoptServiceImpl;
import com.petplace.adopt.model.vo.Adopt;
import com.petplace.adopt.model.vo.AdoptAttachment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AdoptInsertController
 */
@WebServlet(name = "adoptInsert.do", urlPatterns = { "/adoptInsert.do" })
public class AdoptInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(JakartaServletFileUpload.isMultipartContent(request)) {
			//1.파일용량제한
			int fileMaxSize = 1024 * 1024 * 10; //10mb
			int requestMaxSize = 1024 * 1024 * 20; //20
			
			//2. 전달파일 저장경로
			String savePath = request.getServletContext().getRealPath("/images/adopt_upfile/");
			
			//3.DiskFileItemFactory(파일을 임시로 저장) 객체 생성
			DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
			
			//JakartaServletFileUpload http요청으로 들어온 파일데이터를 파싱 -> 개별FileItem 객체로 변환
			JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
			
			upload.setFileSizeMax(fileMaxSize);
			upload.setSizeMax(requestMaxSize);
			
			//요청으로부터 파일 아이템 파싱
			List<FileItem> formItems = upload.parseRequest(request);
			
			//추가할 데이터
			Adopt a = new Adopt();
			//ArrayList<AdoptAttachment> list = new ArrayList<>();
			AdoptAttachment aAt = new AdoptAttachment();
			
			for(FileItem item : formItems) { //일반파라미터
				System.out.println(item);
				if(item.isFormField()) {
					switch(item.getFieldName()) {
					case "memberId":
						a.setMemberId(item.getString(Charset.forName("utf-8")));
						break;
					case "category":
						a.setAdoptCategory(item.getString(Charset.forName("utf-8")));
						break;
					case "title":
						a.setBoardTitle(item.getString(Charset.forName("utf-8")));
						break;
					case "detail":
						a.setBoardDetail(item.getString(Charset.forName("utf-8")));
						break;
					case "place":
						a.setPlace(item.getString(Charset.forName("utf-8")));
						break;
					case "findDate":
						a.setFindDate(item.getString(Charset.forName("utf-8")));
						break;
					case "boardType":
						a.setBoardType(item.getString(Charset.forName("utf-8")));
						aAt.setBoardType(item.getString(Charset.forName("utf-8")));
						break;
					}
				} else {
					String originName = item.getName();
					if(originName.length() > 0) { //파일 업로드시
						//고유한 파일명 생성
						String tmpName = "AdoptFile_" + System.currentTimeMillis();
						String type = originName.substring(originName.lastIndexOf("."));
						String changeName = tmpName + type; //서버에 저장할 파일명
						
						File f = new File(savePath, changeName);
                        item.write(f.toPath());
                        
						//AdoptAttachment aAt = new AdoptAttachment();
						aAt.setOriginName(originName);
						aAt.setChangeName(changeName);
						aAt.setFilePath("/images/adopt_upfile/");
						
						//list.add(aAt);
					}
				}
			}
			
			int result = new AdoptServiceImpl().insertAdopt(a, aAt);
			HttpSession session = request.getSession();
			if(result > 0) {//성공
				session.setAttribute("alertMsg", "입양 게시글 등록에 성공했습니다.");
				response.sendRedirect(request.getContextPath() + "/adoptList.do?cpage=1&boardType=A");
			} else { //실패 -> 업로드된 파일 삭제해주고 에러페이지
				 
				 //for(CommunityAttachment at : list) {
					 new File(savePath + aAt.getChangeName()).delete();
				 //}
				 session.setAttribute("alertMsg", "입양 게시글 등록에 실패하였습니다.");
				 response.sendRedirect(request.getContextPath() + "/adoptList.do?cpage=1&boardType=A");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
