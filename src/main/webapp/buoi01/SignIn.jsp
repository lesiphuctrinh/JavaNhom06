<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="SignInStyle.css">

</head>
<body>
	<div
		style="background-color: rgb(255, 255, 255); border: 1px solid rgb(204, 204, 204); box-shadow: rgba(0, 0, 0, 0.2) 2px 2px 3px; position: absolute; transition: visibility linear 0.3s, opacity 0.3s linear; opacity: 0; visibility: hidden; z-index: 2000000000; left: 0px; top: -10000px;">
		<div class="fancybox-margin"
			style="width: 100%; height: 100%; position: fixed; top: 0px; left: 0px; z-index: 2000000000; background-color: rgb(255, 255, 255); opacity: 0.05;"></div>
		<div class="g-recaptcha-bubble-arrow"
			style="border: 11px solid transparent; width: 0px; height: 0px; position: absolute; pointer-events: none; margin-top: -11px; z-index: 2000000000;"></div>
		<div class="g-recaptcha-bubble-arrow"
			style="border: 10px solid transparent; width: 0px; height: 0px; position: absolute; pointer-events: none; margin-top: -10px; z-index: 2000000000;"></div>
		<div style="z-index: 2000000000; position: relative;">
			<iframe title="hình ảnh xác thực reCAPTCHA sẽ hết hạn sau 2 phút nữa"
				name="c-diwuprir51yq" frameborder="0" scrolling="no"
				sandbox="allow-forms allow-popups allow-same-origin allow-scripts allow-top-navigation allow-modals allow-popups-to-escape-sandbox allow-storage-access-by-user-activation"
				src="https://www.google.com/recaptcha/api2/bframe?hl=vi&amp;v=EGbODne6buzpTnWrrBprcfAY&amp;k=6Ld9OA4UAAAAAPW0KC8pzSeqr5oXG54yHSpkqwV3"
				style="width: 100%; height: 100%;"></iframe>
		</div>
	</div>
	<div class="fancybox-overlay fancybox-overlay-fixed"
		style="width: auto; height: auto; display: block;">
		<div
			class="fancybox-wrap fancybox-desktop fancybox-type-ajax fancybox-opened"
			tabindex="-1"
			style="width: 782px; height: auto; position: absolute; top: 82px; left: 91px; opacity: 1; overflow: visible;">
			<div class="fancybox-skin"
				style="padding: 0px; width: auto; height: auto;">
				<div class="fancybox-outer">
					<div class="fancybox-inner"
						style="overflow: hidden; width: 782px; height: auto;">
						<!-- box dang ky -->
						<div id="dboxregister" name="dboxregister" class="fancybox">
							<div class="lblogin">
								<div class="lbtitle">
									<span>ĐĂNG KÝ</span> <img class="lbclose"
										src="images/closefanbox.gif"
										onclick="jQuery.fancybox.close();">
								</div>
								<div class="lbbody">
									<p class="fbold">
										<span class="iconlogin">&nbsp;</span>Đăng ký nhanh qua
										Facebook
									</p>
									<div class="logfb">
										<img class="imgfb" src="images/btnfb277x45.jpg"
											onclick="loginFB();"> <span class="arrowtip">&nbsp;</span>
										<div class="tipmark">
											<ul>
												<li>Thưởng ngay <span class="cred">50</span> ePoints
													khi đăng ký mới &amp; <span class="cred">5</span> ePoints
													cho mỗi lượt chia sẻ Facebook
												</li>
												<li>Tích lũy nhiều ePoints khi Upload tài liệu <a
													rel="nofollow"
													href="https://tailieu.vn/gioi-thieu-diem-epoints.html">&gt;&gt;</a></li>
											</ul>
										</div>
									</div>
									<p id="pregister6" name="pregister6"
										onclick="slidedownLogin(6);" class="logfb fbold arropen"
										style="font-weight: 700; color: #0080AF; cursor: pointer;">Đăng
										ký mới bằng tài khoản TaiLieu.VN</p>
									<div id="dregister6" name="dregister6" style="display: block;">
										<p>Bạn cần kích hoạt tài khoản qua Email sau khi đăng ký
											để nhận ngay 50 ePoints thưởng từ TaiLieu.VN</p>
										<div class="spacing margintop10">
											<input placeholder="Nhập Username" type="text"
												name="txtUsername_Regis" id="txtUsername_Regis"
												maxlength="50" class="txt295 marginright10 inputtext"
												value=""> <input placeholder="Nhập Họ và Tên"
												type="text" id="txtFullname_Regis" name="txtFullname_Regis"
												maxlength="100" class="txt295 inputtext" value="">
											<div id="txtErrorUser_Regis" name="txtErrorUser_Regis"
												class="errormsg1"></div>
											<div id="txtErrorFullname_Regis"
												name="txtErrorFullname_Regis" class="errormsg2"></div>
										</div>
										<div class="spacing">
											<input placeholder="Nhập mật khẩu" type="password"
												id="txtPassword_Regis" name="txtPassword_Regis"
												maxlength="30" class="txt295 marginright10 fleft inputtext"
												value=""> <select name="txtGender_Regis"
												id="txtGender_Regis" class="select75 fleft inputtext">
												<option value="">Giới Tính</option>
												<option value="1">Nam</option>
												<option value="0">Nữ</option>
											</select>
											<div id="txtErrorPass_Regis" name="txtErrorPass_Regis"
												class="errormsg1"></div>
											<div id="txtErrorGender_Regis" name="txtErrorGender_Regis"
												class="errormsg2"></div>
										</div>
										<div class="spacing">
											<input placeholder="Nhập lại mật khẩu" type="password"
												id="txtCPassword_Regis" name="txtCPassword_Regis"
												maxlength="30" class="txt295 marginright10 fleft inputtext"
												value=""> <select name="txtDay_Regis"
												id="txtDay_Regis" class="select75 fleft inputtext">
												<option value="">Ngày sinh</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
												<option value="13">13</option>
												<option value="14">14</option>
												<option value="15">15</option>
												<option value="16">16</option>
												<option value="17">17</option>
												<option value="18">18</option>
												<option value="19">19</option>
												<option value="20">20</option>
												<option value="21">21</option>
												<option value="22">22</option>
												<option value="23">23</option>
												<option value="24">24</option>
												<option value="25">25</option>
												<option value="26">26</option>
												<option value="27">27</option>
												<option value="28">28</option>
												<option value="29">29</option>
												<option value="30">30</option>
												<option value="31">31</option>
											</select> <select name="txtMonth_Regis" id="txtMonth_Regis"
												class="select75 fleft inputtext">
												<option value="">Tháng</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
												<option value="6">6</option>
												<option value="7">7</option>
												<option value="8">8</option>
												<option value="9">9</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
											</select> <select name="txtYear_Regis" id="txtYear_Regis"
												class="select75 fleft inputtext">
												<option value="">Năm</option>
												<option value="1960">1960</option>
												<option value="1961">1961</option>
												<option value="1962">1962</option>
												<option value="1963">1963</option>
												<option value="1964">1964</option>
												<option value="1965">1965</option>
												<option value="1966">1966</option>
												<option value="1967">1967</option>
												<option value="1968">1968</option>
												<option value="1969">1969</option>
												<option value="1970">1970</option>
												<option value="1971">1971</option>
												<option value="1972">1972</option>
												<option value="1973">1973</option>
												<option value="1974">1974</option>
												<option value="1975">1975</option>
												<option value="1976">1976</option>
												<option value="1977">1977</option>
												<option value="1978">1978</option>
												<option value="1979">1979</option>
												<option value="1980">1980</option>
												<option value="1981">1981</option>
												<option value="1982">1982</option>
												<option value="1983">1983</option>
												<option value="1984">1984</option>
												<option value="1985">1985</option>
												<option value="1986">1986</option>
												<option value="1987">1987</option>
												<option value="1988">1988</option>
												<option value="1989">1989</option>
												<option value="1990">1990</option>
												<option value="1991">1991</option>
												<option value="1992">1992</option>
												<option value="1993">1993</option>
												<option value="1994">1994</option>
												<option value="1995">1995</option>
												<option value="1996">1996</option>
												<option value="1997">1997</option>
												<option value="1998">1998</option>
												<option value="1999">1999</option>
											</select>
											<div id="txtErrorPass2_Regis" name="txtErrorPass2_Regis"
												class="errormsg1"></div>
											<div id="txtErrorBirthday_Regis"
												name="txtErrorBirthday_Regis" class="errormsg2"></div>
										</div>
										<div class="spacing">
											<input placeholder="Nhập địa chỉ Email" type="text"
												id="txtEmail_Regis" name="txtEmail_Regis" maxlength="100"
												class="txt295 marginright10 fleft inputtext" value="">
											<select name="txtCity_Regis" id="txtCity_Regis"
												class="select75 fleft inputtext">
												<option value="">Tỉnh/TP</option>
												<option value="76">An Giang</option>
												<option value="64">Bà Rịa Vũng Tàu</option>
												<option value="281">Bắc Cạn</option>
												<option value="240">Bắc Giang</option>
												<option value="781">Bạc Liêu</option>
												<option value="241">Bắc Ninh</option>
												<option value="75">Bến Tre</option>
												<option value="650">Bình Dương</option>
												<option value="651">Bình Phước</option>
												<option value="62">Bình Thuận</option>
												<option value="56">Bình Định</option>
												<option value="78">Cà Mau</option>
												<option value="71">Cần Thơ</option>
												<option value="26">Cao Bằng</option>
												<option value="59">Gia Lai</option>
												<option value="19">Hà Giang</option>
												<option value="351">Hà Nam</option>
												<option value="4">Hà Nội</option>
												<option value="34">Hà Tây</option>
												<option value="39">Hà Tỉnh</option>
												<option value="320">Hải Dương</option>
												<option value="31">Hải Phòng</option>
												<option value="18">Hòa Bình</option>
												<option value="321">Hưng Yên</option>
												<option value="58">Khánh Hòa</option>
												<option value="77">Kiên Giang</option>
												<option value="60">Kon Tum</option>
												<option value="23">Lai Châu</option>
												<option value="63">Lâm Đồng</option>
												<option value="25">Lạng Sơn</option>
												<option value="20">Lào Cai</option>
												<option value="72">Long An</option>
												<option value="350">Nam Định</option>
												<option value="38">Nghệ An</option>
												<option value="30">Ninh Bình</option>
												<option value="68">Ninh Thuận</option>
												<option value="901">Nơi khác</option>
												<option value="210">Phú Thọ</option>
												<option value="57">Phú Yên</option>
												<option value="52">Quảng Bình</option>
												<option value="510">Quảng Nam</option>
												<option value="55">Quảng Ngãi</option>
												<option value="33">Quảng Ninh</option>
												<option value="53">Quảng Trị</option>
												<option value="79">Sóc Trăng</option>
												<option value="22">Sơn La</option>
												<option value="66">Tây Ninh</option>
												<option value="36">Thái Bình</option>
												<option value="280">Thái Nguyên</option>
												<option value="37">Thanh Hóa</option>
												<option value="54">Thừa Thiên Huế</option>
												<option value="73">Tiền Giang</option>
												<option value="8">TP.HCM</option>
												<option value="74">Trà Vinh</option>
												<option value="27">Tuyên Quang</option>
												<option value="70">Vĩnh Long</option>
												<option value="211">Vĩnh Phúc</option>
												<option value="29">Yên Bái</option>
												<option value="511">Đà Nẵng</option>
												<option value="50">Đắc Lắc</option>
												<option value="1042">Đắc Nông</option>
												<option value="900">Điện Biên</option>
												<option value="61">Đồng Nai</option>
												<option value="67">Đồng Tháp</option>
											</select>
											<div id="txtErrorLoginEmail_Regis"
												name="txtErrorLoginEmail_Regis" class="errormsg1"></div>
											<div id="txtErrorCity_Regis" name="txtErrorCity_Regis"
												class="errormsg2"></div>
										</div>
										<div class="spacing">
											<input placeholder="Nhập lại địa chỉ Email" type="text"
												id="txtCEmail_Regis" name="txtCEmail_Regis" maxlength="100"
												class="txt295 marginright10 fleft inputtext" value="">
											<input placeholder="Nhập mã xác nhận" type="text"
												id="txtCaptcha_Regis" name="txtCaptcha_Regis" maxlength="30"
												class="txt295 marginright10 fleft inputtext"
												style="width: 120px;" value=""> <span
												id="spmImgCaptcha_Regis" name="spmImgCaptcha_Regis"
												class="fleft"><img
												src="https://tailieu.vn/image/captcha/1c1feb7ee39985dc7ecac37701f5d8f2.png"></span>
											<input type="hidden" value="ece2a2ffa4b7cccbc92a58cc99663f51"
												name="captcha_id_Regis" id="captcha_id_Regis"> <a
												onclick="changeCaptchaLogin_Regis();"
												href="javascript:void(0);" class="newcap fleft">Chọn mã
												xác nhận khác.</a>
											<div id="txtErrorLoginEmail2_Regis"
												name="txtErrorLoginEmail2" class="errormsg1"></div>
											<div id="txtErrorDKCode_Regis" name="txtErrorDKCode"
												class="errormsg2"></div>
										</div>
										<div id="clear"></div>
										<div class="margintop5 fleft">
											<div class="fleft">
												<div style="width: 80px;" class="btncenterblue"
													onclick="registerMember_Regis();">
													<div class="btnleftblue"></div>
													<span class="btntext">Đăng ký</span>
													<div class="btnrightblue"></div>
												</div>
											</div>
											<div class="fleft marginleft6 paddingtop10">
												<input checked="checked" type="checkbox"
													name="chkRight_Regis" id="chkRight_Regis" value="1">&nbsp;Tôi
												đồng ý với các Chính Sách và Thỏa Thuận Sử Dụng của
												TaiLieu.VN
											</div>
										</div>
									</div>
									<div id="clear"></div>
									<span
										style="border-bottom: 1px dashed #cecece; width: 750px; float: left;"></span>
									<p id="plogin5" name="plogin5" onclick="slidedownLogin(5);"
										class="arrclose logfb fbold"
										style="font-weight: 700; color: #0080AF; cursor: pointer;">Bạn
										đã có tài khoản TaiLieu.VN? Đăng nhập</p>
									<div id="dlogin5" name="dlogin5" style="display: none;">
										<input placeholder="Nhập Username hoặc Email" type="text"
											name="txtLoginUsername_Regis" id="txtLoginUsername_Regis"
											maxlength="50" class="txt295 marginright10 inputtext"
											value=""> &nbsp;&nbsp;&nbsp; <input
											placeholder="Nhập mật khẩu" type="password"
											onkeydown="if(event.keyCode==13){ loginfancybox_Regis(); }"
											id="txtLoginPassword_Regis" name="txtLoginPassword_Regis"
											maxlength="30" class="txt295 inputtext" value="">
										<div id="txtErrorLoginUsername_Regis"
											name="txtErrorLoginUsername_Regis" class="errormsg1"></div>
										<div id="clear"></div>
										<div class="margintop5 fleft">
											<div class="fleft">
												<div style="width: 100px;" class="btncenterblue"
													onclick="loginfancybox_Regis();">
													<div class="btnleftblue"></div>
													<span class="btntext">Đăng nhập</span>
													<div class="btnrightblue"></div>
												</div>
											</div>
											<div class="fleft marginleft6 paddingtop10">
												<input type="checkbox" name="remem_pass" id="remem_pass">
												<label for="chksave">&nbsp;Nhớ mật khẩu</label> <span
													class="plr_5">|</span> <a id="achangepass"
													name="achangepass" title="Login" href="#dboxchangepass">Quên
													mật khẩu</a>
											</div>
										</div>
									</div>
									<div class="lbbottom">
										<ul>
											<li>
												<p>
													Thưởng <span class="fxanh1 fbold">50</span> ePoints khi
													đăng ký mới
												</p>
												<p>
													Tặng <span class="fxanh1 fbold">5</span> ePoints cho mỗi
													lượt chia sẻ Facebook
												</p>
											</li>
											<li>
												<p>
													Xem và Tải trên <span class="fxanh1 fbold">1 Triệu</span>
													Tài Liệu miễn phí
												</p>
												<p>
													Kết nối <span class="fxanh1 fbold">5 Triệu</span> Thành
													Viên <a href="https://tailieu.vn/">TaiLieu.VN</a>
												</p>
											</li>
											<li class="btlast">
												<div style="width: 210px;">
													<div class="left" style="margin-bottom: 5px;">
														Kết bạn với <b><a target="_blank"
															href="https://www.facebook.com/tailieu.vn">TaiLieu.VN</a></b>
														trên <b><a target="_blank"
															href="https://www.facebook.com/tailieu.vn">Facebook</a></b>
														để nhận link download miễn phí <span class="cred">100</span>
														tài liệu <span class="cred">HOT</span> mỗi ngày
													</div>
												</div>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>