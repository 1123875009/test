<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</head>
<body>
    <form id="form1" runat="server">  
    <div>  
        智能模糊查询提示  
        <input id="textfield" type="text" style="width:140px;" />  
        <div id="searchresult" style="display: none;">  
        </div>  
     </div>       
     </form>      
     
       <script type="text/javascript">  
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
</body>

</html>