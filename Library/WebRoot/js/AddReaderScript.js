    var xmlHttp=false;
    function createXMLHttpRequest()
    {
        if (window.ActiveXObject)  //在IE浏览器中创建XMLHttpRequest对象
        {
            try{
                xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
            }
            catch(e){
                try{
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                catch(ee){
                    xmlHttp=false;
                }
            }
        }
        else if (window.XMLHttpRequest) //在非IE浏览器中创建XMLHttpRequest对象
        {
            try{
                xmlHttp = new XMLHttpRequest();
            }
            catch(e){
                xmlHttp=false;
            }
        }
    }
	
    
	function regCheck(){
		var stuID = document.getElementById("stuID").value; //得到输入框里的学号
		createXMLHttpRequest();   //调用创建XMLHttpRequest对象的方法
		
		xmlHttp.onreadystatechange = regCheckResult;   //设置回调函数等待response
		
		var url = "ReaderAction?action=QueryReaderById&next=existcheck&stuID=" + stuID;
		document.getElementById("stuidcheck").innerHTML = "";//初始化监测显示
		
		xmlHttp.open("POST",url,true);      //向服务器端发送请求
        xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf8");
        xmlHttp.send(null);
	}
	
	
	function regCheckResult(){
		if (xmlHttp.readyState==4 && xmlHttp.status==200){
			var data= xmlHttp.responseText;
			if(data == "未办")//证件状态(0未办 1在 2挂失)
				document.getElementById("stuidcheck").innerHTML = "可以办证喔";
			else if(data == "在")
				document.getElementById("stuidcheck").innerHTML = "已有借书证了";
			else if(data == "挂失")
				document.getElementById("stuidcheck").innerHTML = "借书证挂失了";
			else if(data == "null")
				document.getElementById("stuidcheck").innerHTML = "无效学号";
			else document.getElementById("stuidcheck").innerHTML = data.toString();
		}
	}