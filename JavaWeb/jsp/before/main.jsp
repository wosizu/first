<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>一锋网</title>
	<link href="http://localhost:8080/JavaWeb/css/before/main.css" rel="stylesheet" />
	<link href="http://localhost:8080/JavaWeb/css/before/bootstrap.css"  rel="stylesheet"/>
	<link href="http://localhost:8080/JavaWeb/font/iconfont.css" rel="stylesheet"/>
	
	
	<script src="http://localhost:8080/JavaWeb/js/before/jquery.min.js"></script>
	<script src="http://localhost:8080/JavaWeb/js/before/bootstrap.min.js"></script>
</head>
<body>
	
	<div class="nav-top row">
			<a href="#" class="col-md-1">登陆</a>
			<a href="#" class="col-md-1">注册</a>
		</div>
		
		
		<div class="row my-lg-5">
			<div class="col-md-4"></div>
			<form class="form-inline col-md-4">
				<input class="form-control" type="search" name="search"/>
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
		
		<div class="container my-lg-4">
			<div class="row">
				<div class="col-md-2">
					<ul class="list-group">
						<li class="list-group-item"><a href="http://localhost:8080/JavaWeb/before/type?typeid=1">女鞋</a>  <a href="http://localhost:8080/JavaWeb/before/type?typeid=2">男装</a>  <a href="http://localhost:8080/JavaWeb/before/type?typeid=10">手表</a></li>
						<li class="list-group-item"><a href="#">家电</a>  <a href="#">箱包</a>  <a href="#">配件</a></li>
						<li class="list-group-item"><a href="#">玩具</a>  <a href="#">孕产</a>  <a href="#">永平</a></li>
						<li class="list-group-item"><a href="#">稀奇</a>  <a href="#">数码</a>  <a href="#">手机</a></li>
						<li class="list-group-item"><a href="#">美妆</a>  <a href="#">洗护</a>  <a href="#">保健</a></li>
						<li class="list-group-item"><a href="#">珠宝</a>  <a href="#">眼睛</a>  <a href="#">内衣</a></li>
						<li class="list-group-item"><a href="#">运动</a>  <a href="#">户外</a>  <a href="#">乐器</a></li>
						<li class="list-group-item"><a href="#">游戏</a>  <a href="#">动漫</a>  <a href="#">影视</a></li>
					
					</ul>
				</div>
				
				<div class="col-md-5">
					<div id="deam" class="carousel slide" data-ride="carousel">
						<div class="carousel-inner">
							
							<div class="carousel-item active">
								<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/图片2.jpg" />
							</div>	
							
							<div class="carousel-item">
								<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/图片1.jpg" />
							</div>
							
							
							<a class="carousel-control-prev" href="#deam" data-slide="prev">
							    <span class="carousel-control-prev-icon"></span>
							</a>
							
							<a class="carousel-control-next" href="#deam" data-slide="next">
							    <span class="carousel-control-next-icon"></span>
							</a>
						</div>
					</div>
					
					<div class="row">	
						<div id="deam1" class="carousel slide col-md-6" data-ride="carousel">
							<div id="deam1" class="carousel-inner">
								<div class="carousel-item active">
									<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/图片下1.jpg" />
								</div>		
								<div class="carousel-item">
									<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/图片下4.jpg" />
								</div>
							</div>
						</div>
						
						
						<div id="deam2" class="carousel slide col-md-6" data-ride="carousel" >
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/图片下1.jpg" />
								</div>
								<div class="carousel-item">
									<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/图片下2.jpg"/>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				
				
				<div class="col-md-2">
					<img class="img-fluid img-thumbnail " src="http://localhost:8080/JavaWeb/img/goods/图片下5.jpg"/>
					<img class="img-fluid img-thumbnail my-md-3" src="http://localhost:8080/JavaWeb/img/goods/图片下6.jpg"/>
					<img class="img-fluid img-thumbnail my-md-3" src="http://localhost:8080/JavaWeb/img/goods/图片下5.jpg"/>
				</div>
				
				
				<div class="col-md-3">
					<div class="member">
						<div class="row">
							<div class="col-md-4"></div>
							<img class="col-md-3 my-md-4 img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/头像.jpg" />
						</div>
						<div class="row">
							<div class="col-md-2"></div>
							<button class="btn btn-danger btn-sm ">登陆</button>
							<button class="btn btn-danger btn-sm ml-md-2">注册</button>
							<button class="btn btn-danger btn-sm ml-md-2">开店</button>
								
						</div>
					</div>	
					<div class="row my-md-4">
						<div class="col-md-4">
							<span class="iconfont icon-chonghuafei" style="font-size: 40px; color: coral;"></span>
							<span class="iconfont icon-water" style="font-size: 35px; color: #0077AA;"></span>
							<span class="iconfont icon-lvhang" style="font-size: 30px; color: skyblue;"></span>
							<span class="iconfont icon-chexian1" style="font-size: 35px; color: orange;"></span>
						</div>
						
						<div class="col-md-4">
							<span class="iconfont icon-fuwu" style="font-size: 43px; color: orange;"></span>
							<span class="iconfont icon-huoche1" style="font-size: 35px;color: #004085;"></span>
							<span class="iconfont icon-youxi" style="font-size: 30px;color: greenyellow;"></span>
							<span class="iconfont icon-jiudian" style="font-size: 38px;color: crimson;"></span>
						</div>
						
						<div class="col-md-4">
							<span class="iconfont icon-yanchu" style="font-size: 40px; color: coral"></span>
							<span class="iconfont icon-licai" style="font-size: 33px;color: red;"></span>
							<span class="iconfont icon-caipiao" style="font-size: 36px;color: red;"></span>
							<span class="iconfont icon-huoche" style="font-size: 36px; color: coral;"></span>
						</div>
						
					</div>
					
				</div>
				
				
				
			</div>
		</div>
		
		
		<div class="container " >
			<div class="row">
				<div class="col-md-2 row">
					<div class="col-md-8">
						<img class="img-fluid " src="http://localhost:8080/JavaWeb/img/goods/有好货.png" />
					</div>
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-2 ">
					<div class="col-md-8">
						<img class="img-fluid " src="http://localhost:8080/JavaWeb/img/goods/爱逛街.png" />
					</div>
					
				</div>
				
			</div>
			
			
			<div class="row goods_top my-md-3" >
				<div class="col-md-6 row" >
					<div class="col-md-4">
						<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/商品1.webp" />
						<h6>max破产要买的口红</h6>
						<p>《破产姐妹》max最爱</p>
					</div>
					<div class="col-md-4">
						<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/商品2.webp" />
						<h6>Gogan 冰种玉镯</h6>
						<p>极品冰种质地，视觉效果通</p>
					</div>
					<div class="col-md-4">
						<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/商品3.webp" />
						<h6>碎脂机，超快瘦身</h6>
						<p>这个精美的碎脂机，不仅采</p>
					</div>
				</div>
				
				<div class="col-md-6 row " >
					<div class="col-md-4">
						<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/裙.webp" />
						<p><span class="iconfont icon-shuangyinhao"></span>&nbsp;&nbsp;裙</p>
					</div>
					<div class="col-md-4">
						<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/地毯.webp" />
						<p><span class="iconfont icon-shuangyinhao"></span>&nbsp;&nbsp;ins网红的家靠地毯就能撑起来</p>
					</div>
					<div class="col-md-4">
						<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/梨花杯.webp" />
						<p><span class="iconfont icon-shuangyinhao"></span>&nbsp;&nbsp;韩国潮牌梨花杯</p>
					</div>
				</div>
				
			</div>
			
			<div class="row goods_top" >
				<div class="col-md-6 row">
					<div class="col-md-4">
						<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/商品7.webp" />
						<h6>为小户型省空间</h6>
						<p>北欧简约设计，为小户型</p>
					</div>
					<div class="col-md-4">
						<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/商品8.webp" />
						<h6>ZIIIRO手表</h6>
						<p>采用现代设计，让时间显示</p>
					</div>
					<div class="col-md-4">
						<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/商品9.webp" />
						<h6>老铁，这是电吸门</h6>
						<p>电吸门可以避免车门未关紧</p>
					</div>
				</div>
				
				<div class="col-md-6 row" >
					
					<div class="col-md-4">
						<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/粉地毯.webp" />
						<p><span class="iconfont icon-shuangyinhao"></span>&nbsp;&nbsp;粉格小地毯 满足你的少女心</p>
					</div>
					<div class="col-md-4">
						<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/椅子.webp" />
						<p><span class="iconfont icon-shuangyinhao"></span>&nbsp;&nbsp;休闲角应该有把这样的椅子</p>
					</div>
					<div class="col-md-4">
						<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/首饰盒.webp" />
						<p><span class="iconfont icon-shuangyinhao"></span>&nbsp;&nbsp;有了它 帮你解决首饰收纳难题</p>
					</div>
				</div>
				
			</div>
		</div>
		<div>&nbsp;</div>
		
		
		<div class="container goods_middle my-lg-5" >
			<div class="row">
				<div class="col-md-2 row">
					<div class="col-md-8">
						<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/抢购.png"/>
					</div>
					
				</div>
			</div>
			<div class=" row my-md-3">
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-6">
							<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/抢购图片1.webp" />
						</div>
						<div class="col-md-6">
							<div class="row">
								<p>一次充电跑三十万公里</p>
								<p>直降三百送手镯</p>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="progress ">
										 <div class="progress-bar progress-bar-warning"  style="width: 60%;">
											60%
										 </div>
									</div>
								</div>
							</div>	
							<div>&nbsp;</div>
							<div class="row my-md-6">
								<span class="iconfont icon-renminbifuhao"></span><span>1999</span>
								<del><span class="iconfont icon-renminbifuhao"></span><span>3999</span></del>
							</div>
							
						</div>	
					</div>
				</div>
				
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-6">
							<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/抢购图片2.webp" />
						</div>
						<div class="col-md-6">
							<div class="row">
								<p>实惠不粘锅铝锅</p>
								<p>五天包换</p>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="progress">
									  <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
									    60%
									  </div>
									</div>
								</div>
							</div>	
							<div>&nbsp;</div>
							<div class="row my-md-6">
								<span class="iconfont icon-renminbifuhao"></span><span>99</span>
								<del><span class="iconfont icon-renminbifuhao"></span><span>199</span></del>
							</div>
						</div>	
					</div>
					
				</div>
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-6">
							<img class="img-fluid img-thumbnail" src="http://localhost:8080/JavaWeb/img/goods/抢购图片3.webp" />
						</div>
						<div class="col-md-6">
							<div class="row">
								<p>德国进口原装金表</p>
								<p>保证真品</p>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="progress">
									  <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
									    60%
									  </div>
									</div>
								</div>
							</div>	
							<div>&nbsp;</div>
							<div class="row my-md-6">
								<span class="iconfont icon-renminbifuhao"></span><span>4000</span>
								<del><span class="iconfont icon-renminbifuhao"></span><span>5300</span></del>
							</div>
						</div>	
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="container goods_bottom my-lg-5">
			<div class="row">
				<div class="col-md-3">
					<p>时尚爆料王</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-12">
							<p>腔调</p>
						</div>
						
					</div>
					<div class="row">
						<div class="col-md-6">
							<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/腔调1.webp" />
						</div>
						<div class="col-md-6">
							<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/腔调2.webp" />
						</div>
					</div>
				</div>
				
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-12">
							<p>全球购</p>
						</div>
						
					</div>
					<div class="row">
						<div class="col-md-6">
							<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/全球购1.webp" />
						</div>
						<div class="col-md-6">
							<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/全球购2.webp" />
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-12">
							<p>魅力惠</p>
						</div>
						
					</div>
					<div class="row">
						<div class="col-md-6">
							<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/魅力惠1.webp" />
						</div>
						<div class="col-md-6">
							<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/魅力惠2.webp" />
						</div>
					</div>
					
				</div>
			</div>
		</div>
		
		<div class="container goods_realbottom my-lg-5">
			<div class="row">
				<div class="col-md-3">
					<p>品质生活家</p>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-6">
					<div class="row">
						<div class="col-md-6">
							<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/家具城.png" />
						</div>
						<div class="col-md-6 my-md-3">
							<div class="row">亲宝贝</div>
							<div class="row">
								<img class="img-fluid col-md-6" src="http://localhost:8080/JavaWeb/img/goods/请宝贝.webp" />
								<img class="img-fluid col-md-6" src="http://localhost:8080/JavaWeb/img/goods/袜子.webp" />
							</div>
							
							<div class="row my-md-3">淘宝教育</div>
							<div class="row">
								<img class="img-fluid col-md-6" src="http://localhost:8080/JavaWeb/img/goods/淘宝教育1.webp" />
								<img class="img-fluid col-md-6" src="http://localhost:8080/JavaWeb/img/goods/淘宝教育2.webp" />
							</div>
							
						</div>
					</div>
				</div>
				
				<div class="col-md-6">
					
					<div class="row">
						<div class="col-md-6">
							<img class="img-fluid" src="http://localhost:8080/JavaWeb/img/goods/拍卖.jpg" />
						</div>
						<div class="col-md-6 my-md-3">
							<div class="row">淘宝动漫</div>
							<div class="row">
								<img class="img-fluid col-md-6" src="http://localhost:8080/JavaWeb/img/goods/淘宝动漫1.webp" />
								<img class="img-fluid col-md-6" src="http://localhost:8080/JavaWeb/img/goods/淘宝动漫2.webp" />
							</div>
							
							<div class="row my-md-3">淘宝文创</div>
							<div class="row">
								<img class="img-fluid col-md-6" src="http://localhost:8080/JavaWeb/img/goods/淘宝文创1.webp" />
								<img class="img-fluid col-md-6" src="http://localhost:8080/JavaWeb/img/goods/淘宝文创2.webp" />
							</div>
							
						</div>
					</div>
					
				</div>
				
				
			</div>
		</div>
	
</body>
</html>