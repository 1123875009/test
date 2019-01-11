<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<style type="text/css">  
    #searchresult  
    {  
        width: 140px;  
        position: absolute;  
        z-index: 1;  
        overflow: hidden;  
        left: 140px;  
        top: 71px;  
        background: #E0E0E0;  
        border-top: none;  
        
    } 
    #textfield
    {
       font-size:15px;
       height:20px;
    }
    .line  
    {  
        font-size: 15px;  
        background: #E0E0E0;  
        width: 140px;  
        padding:0px;  
    }  
    .hover  
    {  
        background: #007ab8;  
        width: 140px;  
        color: #fff;  
    }  
    .std  
    {  
        width: 150px;  
    }
    </style>
<script type="text/javascript">
/**
 * my_click和my_blur均是用于前台页面搜索框的函数
 */
//鼠标点击搜索框时执行
function my_click(obj, myid){
	//点击时，如果取得的值和搜索框默认value值相同，则将搜索框清空
	if (document.getElementById(myid).value == document.getElementById(myid).defaultValue){
	  document.getElementById(myid).value = '';
	  obj.style.color='#000';
	}
}
//鼠标不聚焦在搜索框时执行
function my_blur(obj, myid){
	//鼠标失焦时，如果搜索框没有输入值，则用搜索框的默认value值填充
	if (document.getElementById(myid).value == ''){
	 document.getElementById(myid).value = document.getElementById(myid).defaultValue;
	 obj.style.color='#999';
 }
}

/**
 * 点击搜索按钮执行的函数
 */
function search(){
	document.getElementById("searchform").submit();
}
<%--textfield.getDocument().addDocumentListener(new DocumentListener()

)--%>



$(function () {  
    $("#textfield").keyup(function (evt) {  
        ChangeCoords(); //控制查询结果div坐标  
        var k = window.event ? evt.keyCode : evt.which;  
        //输入框的id为textfield，这里监听输入框的keyup事件  
        //不为空 && 不为上箭头或下箭头或回车  
        if ($("#textfield").val() != "" && k != 38 && k != 40 && k != 13) { 

            $.ajax({  
                type: 'post',  
                async: true, //同步执行，不然会有问题  
                dataType: "json",  
                url: "${pageContext.request.contextPath}/Test",   //提交的页面/方法名  
                data: "{\"bookname\":\"" + $("#textfield").val() + "\"}",             //参数（如果没有参数：null）  
                success: function (data) { //请求成功后处理函数。  
                	console.log(data);
                   /*  var objData = eval("(" + data.userName + ")");   */
                    //var data=JSON.parse(data);
                    if (data.length > 0) {  
                        var layer = "";  
                        layer = "<table id='aa'>";  
                        $.each(data, function (idx, item) { 
                        	console.log(item.name);
                         layer += "<tr class='line'><td class='std'>" + item.name + "</td></tr>";  
                        });  
                        layer += "</table>";  

                        //将结果添加到div中      
                        $("#searchresult").empty();  
                        $("#searchresult").append(layer);  
                        $(".line:first").addClass("hover");  
                        $("#searchresult").css("display", "");  
                        //鼠标移动事件  

                        $(".line").hover(function () {  
                            $(".line").removeClass("hover");  
                            $(this).addClass("hover");  
                        }, function () {  
                            $(this).removeClass("hover");  
                            //$("#searchresult").css("display", "none");  
                        });  
                        //鼠标点击事件  
                        $(".line").click(function () {  
                            $("#textfield").val($(this).text());  
                            $("#searchresult").css("display", "none");  
                        });  
                    } else {  
                        $("#searchresult").empty();  
                        $("#searchresult").css("display", "none");  
                    }  
                },  
                error: function (req, textStatus, errorThrown) {//请求失败处理函数  
                  	 alert("数据加载失败"+textStatus); 
                  }, 
               
            });  
        }  
        else if (k == 38) {//上箭头  
            $('#aa tr.hover').prev().addClass("hover");  
            $('#aa tr.hover').next().removeClass("hover");  
            $('#textfield').val($('#aa tr.hover').text());  
        } else if (k == 40) {//下箭头  
            $('#aa tr.hover').next().addClass("hover");  
            $('#aa tr.hover').prev().removeClass("hover");  
            $('#textfield').val($('#aa tr.hover').text());  
        }  
        else if (k == 13) {//回车  
            $('#textfield').val($('#aa tr.hover').text());  
            $("#searchresult").empty();  
            $("#searchresult").css("display", "none");  
        }  
        else {  
            $("#searchresult").empty();  
            $("#searchresult").css("display", "none");  
        }  
    });  
    $("#searchresult").bind("mouseleave", function () {  
        $("#searchresult").empty();  
        $("#searchresult").css("display", "none");  
    });  
});  
//设置查询结果div坐标  

function ChangeCoords() {  
    //    var left = $("#textfield")[0].offsetLeft; //获取距离最左端的距离，像素，整型  
    //    var top = $("#textfield")[0].offsetTop + 26; //获取距离最顶端的距离，像素，整型（20为搜索输入框的高度）  
    var left = $("#textfield").position().left; //获取距离最左端的距离，像素，整型  
    var top = $("#textfield").position().top + 20; ; //获取距离最顶端的距离，像素，整型（20为搜索输入框的高度）  
    $("#searchresult").css("left", left + "px"); //重新定义CSS属性  
    $("#searchresult").css("top", top + "px"); //同上  
}  



</script>
<div id="divmenu">
		<a href="${pageContext.request.contextPath}/showProductByPage?category=文学">文学</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage?category=生活">生活</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage?category=计算机">计算机</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage?category=外语">外语</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage?category=经营">经管</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=励志">励志</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage?category=社科">社科</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage?category=学术">学术</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage?category=少儿">少儿</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=艺术">艺术</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage?category=原版">原版</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage?category=科技">科技</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage?category=考试">考试</a>
		<a href="${pageContext.request.contextPath}/showProductByPage?category=生活百科">生活百科</a> 
		<a href="${pageContext.request.contextPath}/showProductByPage" style="color:#b4d76d">全部商品目录</a>		
</div>
<!-- 编辑框输入搜索商品 -->
<div id="divsearch">
<form action="${pageContext.request.contextPath }/MenuSearchServlet" id="searchform">
	<table width="100%" border="0" cellspacing="0">
		<tr>
			<td style="text-align:right; padding-right:220px">
				Search 
				<div> 
				<input type="text" name="textfield" class="inputtable" id="textfield" value="请输入书名"
				onmouseover="this.focus();"
				onclick="my_click(this, 'textfield');"
				onBlur="my_blur(this, 'textfield');"/>
				<div id="searchresult" style="display: none;">  
        </div> 
        </div>
				<a href="#">
					<img src="${pageContext.request.contextPath}/client/images/serchbutton.gif" border="0" style="margin-bottom:-4px" onclick="search()"/> 
				</a>
			</td>
		</tr>
	</table>
</form>
</div>