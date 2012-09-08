//开始拉取数据
//拉取第一类产品
$(function(){
	var categoryMarkup = '<div class="category_item"><a href="product?id=${id}"><img class="item_img" alt="${productName}" src="${productImg}"><span class="item_title">${productName}</span></a></div>';
	ProductService.getProductByCatIdWithPage(1,6,1,{
		callback:function(data){
			$.tmpl(categoryMarkup,data.list).appendTo("#category1");
		}
	});
	ProductService.getProductByCatIdWithPage(2,6,1,{
		callback:function(data){
			$.tmpl(categoryMarkup,data.list).appendTo("#category2");
		}
	});
	ProductService.getProductByCatIdWithPage(3,3,1,{
		callback:function(data){
			//将获取到的数据绑定到页面上
			var markup = '<div class="feature_product"><a href="product?id=${id}"><img class="feature_img" src="${productImg}" alt="${productName}"/><div class="feature_text">{{html productFeature}}</div><div class="feature_title">${productName}</div></a></div>';
			$.tmpl(markup,data.list).appendTo("#features");
		}
	});
	var imgs = [
	            {img:"http://pysaeimg-file.stor.sinaapp.com/static/321haole/2012/09/slide1.jpg",url:"###"},
	            {img:"http://pysaeimg-file.stor.sinaapp.com/static/321haole/2012/09/slide2.jpg",url:"###"}
	            ];
	$.tmpl('<div><a href="${url}"><img src="${img}"/></a></div>',imgs).appendTo("#slides_container");
});