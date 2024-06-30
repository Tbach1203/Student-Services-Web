package Controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import Util.JDBCUtil;

@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	  
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        Part filePart = request.getPart("excelFile");
	        String fileName = getSubmittedFileName(filePart);
	        InputStream fileContent = filePart.getInputStream();
	        File file= new File(fileName);
	        try (FileOutputStream out = new FileOutputStream(file)) {
	            int read;
	            final byte[] bytes = new byte[1024];
	            while ((read = fileContent.read(bytes)) != -1) {
	                out.write(bytes, 0, read);
	            } 
	        }
	        FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
	        List <String> ArrayD = new ArrayList<>();
	        if (fileInputStream != null) {
	        	HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(fileInputStream));
	            Sheet sheet = wb.getSheetAt(0);
	            Connection conn = JDBCUtil.getConnection(); 
	            for (Row row : sheet) {
	            	  if (row == null || row.getCell(0) == null || row.getCell(0).getStringCellValue().isEmpty()) {
	            	    break;
	            	  }
	            	  for (Cell cell : row) {
		                    ArrayD.add(cell.toString());
		                }
			                String sql = "UPDATE ThamGiaLopHoc SET DiemQuaTrinh = ?, DiemCuoiKy = ? WHERE ID_LopHoc = ? AND ID_SinhVien = ? AND TrangThai = 1";
			                try (PreparedStatement statement = conn.prepareStatement(sql)) {
			                    statement.setInt(3, Integer.parseInt(ArrayD.get(0)));
			                    statement.setString(4, ArrayD.get(1));
			                    statement.setFloat(1, Float.parseFloat(ArrayD.get(2)));
			                    statement.setFloat(2, Float.parseFloat(ArrayD.get(3)));
			                    System.out.println(statement);
			                    statement.executeUpdate();
			                }
			                	catch (SQLException e) {
			                		e.printStackTrace();
			                }
			               ArrayD.clear();
	            	}
		        
		        wb.close();  } 
	        int ctsvId = 0;
	        if(request.getParameter("ctsvId") != null) {
	        	ctsvId = Integer.parseInt(request.getParameter("ctsvId"));			
	        }
	        request.setAttribute("ctsvId", ctsvId);
	        response.sendRedirect("/DichVuSinhVien/ThemDiem?ctsvId=" + ctsvId);
	    
	    }
	    private String getSubmittedFileName(Part part) {
	        for (String content : part.getHeader("content-disposition").split(";")) {
	            if (content.trim().startsWith("filename")) {
	                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	            }
	        }
	        return null;
	    }
}