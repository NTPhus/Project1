<%@page import="Model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Đổi mật khẩu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<%
		Object obj = session.getAttribute("khachHang");
	  	KhachHang kh = null;
	  	if(obj != null)
	  		kh = (KhachHang)obj;
	  	if(kh == null){
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống vui lòng quay lại trang chủ!</h1>
	<%
	  	}else{
		
	
		String baoLoi = request.getAttribute("baoLoi")+"";
		if(baoLoi.equals("null")){
			baoLoi = "";
		}
	%>
<div class="container">
	<h1>Đổi mật khẩu</h1>
	<span style="color:red"><%=baoLoi%></span>
	 <%
	 String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
	 %>
	<form action="<%=url1 %>/khachHangController" method="post">
	<input type="hidden" name="hanhDong" value="doi-mat-khau">
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Mật khẩu hiện tại</label>
	    <input type="password" class="form-control" id="matKhauHienTai" name="matKhauHienTai">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Mật khẩu mới</label>
	    <input type="password" class="form-control" id="matKhauMoi" name="matKhauMoi">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Mật khẩu mới </label>
	    <input type="password" class="form-control" id="matKhauMoiNhapLai" name="matKhauMoiNhapLai">
	  </div>
	  <button type="submit" class="btn btn-primary">Lưu mật khẩu</button>
	</form>
</div>
	<%} %>
	<jsp:include page="../footer.jsp" />
</body>
</html>