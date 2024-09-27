package com.petplace.admin.controller;/**
 * packageName    : com.petplace.admin.controller
 * fileName       : AdminModifyProduct
 * author         : jun
 * date           : 2024. 9. 27.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 27.        jun       최초 생성
 */

import com.petplace.product.model.vo.AttachmentProduct;
import com.petplace.product.model.vo.Product;
import com.petplace.product.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "modifyProduct.pd", value = "/modifyProduct.pd")
public class AdminUpdateProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (JakartaServletFileUpload.isMultipartContent(request)) {
            int fileMaxSize = 1024 * 1024 * 300; // 300MB
            int requestMaxSize = 1024 * 1024 * 350; // 350MB

            String savePath = request.getServletContext().getRealPath("/images/product_upfile/");
            System.out.println("저장 경로 : " + savePath);

            DiskFileItemFactory factory = new DiskFileItemFactory.Builder().get();

            JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
            upload.setFileSizeMax(fileMaxSize);
            upload.setSizeMax(requestMaxSize);

            List<FileItem> formItems = upload.parseRequest(request);
            Product p = new Product();
            ArrayList<AttachmentProduct> list = new ArrayList<>();

            for (FileItem item : formItems) {
                System.out.println(item);
                if (item.isFormField()) {
                    switch (item.getFieldName()) {
                        case "productNo":
                            p.setProductNo(item.getString(Charset.forName("UTF-8")));
                            break;
                        case "productCategory":
                            p.setProductCategory(item.getString(Charset.forName("UTF-8")));
                            break;
                        case "productName":
                            p.setProductName(item.getString(Charset.forName("UTF-8")));
                            break;
                        case "company":
                            p.setCompany(item.getString(Charset.forName("UTF-8")));
                            break;
                        case "price":
                            p.setPrice(Integer.parseInt(item.getString(Charset.forName("UTF-8"))));
                            break;
                        case "inventory":
                            p.setInventory(Integer.parseInt(item.getString(Charset.forName("UTF-8"))));
                            break;
                        case "ingredient":
                            p.setIngredient(item.getString(Charset.forName("UTF-8")));
                            break;
                        case "origin":
                            p.setOrigin(item.getString(Charset.forName("UTF-8")));
                            break;
                        case "productWeight":
                            p.setProductWeight(Integer.parseInt(item.getString(Charset.forName("UTF-8"))));
                            break;
                        case "kcal":
                            p.setKcal(Integer.parseInt(item.getString(Charset.forName("UTF-8"))));
                            break;
                    }
                } else { // file
                    String originName = item.getName();
                    if (originName.length() > 0) {
                        String tmpName = "productFile_" + System.currentTimeMillis();
                        String type = originName.substring(originName.lastIndexOf("."));
                        String changeName = tmpName + type;

                        File f = new File(savePath, changeName);
                        item.write(f.toPath());

                        AttachmentProduct atP = new AttachmentProduct();
                        atP.setOriginName(originName);
                        atP.setChangeName(changeName);
                        atP.setFilePath("images/product_upfile/");

                        // 썸네일 사진 지정
                        int fileLevel = item.getFieldName().equals("thumbnail") ? 1 : 2;
                        atP.setFileLevel(fileLevel);
                        list.add(atP);
                    }
                }
            }
            System.out.println("요청 정보 : " + p);
            System.out.println("요청 정보 : " + list);

            // DB에 저장
            int result = new ProductService().updateProduct(p, list);
            HttpSession session = request.getSession();
            if (result > 0) { // 성공
                session.setAttribute("alertMsg", "상품 수정에 성공했습니다.");
                response.sendRedirect(request.getContextPath() + "/adminModifyProduct.pd?cpage=1");
            } else { // 실패
                session.setAttribute("alertMsg", "상품 수정에 실패하였습니다.");
                response.sendRedirect(request.getContextPath() + "/adminModifyProduct.pd?cpage=1");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
