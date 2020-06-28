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
    
    function logincheck()
    {
        var usernameinput = document.getElementById("usernameinput").value;
		var passwordinput = document.getElementById("passwordinput").value;
        
		createXMLHttpRequest();   //调用创建XMLHttpRequest对象的方法

        xmlHttp.onreadystatechange=logincheckResult;   //设置回调函数

        var url="LoginAction?action=login&username=" + usernameinput + "&password=" + passwordinput;
        
//        System.println(" ### 第一步：loginScript.js里执行 logincheck。调用到LoginAction action=Login ###");
        
        xmlHttp.open("POST",url,true);      //向服务器端发送请求
        xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf8");
        xmlHttp.send(null);
    }
	
    function stulogincheck() //stuindex 调用的函数
    {    	
    	var certiIDinput = document.getElementById("certiIDinput").value;
		var stupasswordinput = document.getElementById("stupasswordinput").value;
		
        createXMLHttpRequest();   //调用创建XMLHttpRequest对象的方法
       
        xmlHttp.onreadystatechange=stulogincheckResult;   //设置回调函数
        
        // loginaction, stulogin  两变量：certiID, password
        var url="LoginAction?action=stulogin&certiID=" + certiIDinput + "&stupassword=" + stupasswordinput;
        
        xmlHttp.open("POST",url,true);      //向服务器端发送请求
        
        xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf8");
        xmlHttp.send(null);
    }
    
    function logincheckResult()
    {
		var usernameinput = document.getElementById("usernameinput").value;
		var passwordinput = document.getElementById("passwordinput").value;
        if (xmlHttp.readyState==4 && xmlHttp.status==200){
            var data= xmlHttp.responseText;
			document.getElementById("checkinfo").innerHTML = "";
            if(data == "false"){
				document.getElementById("checkinfo").innerHTML = "用户名或密码错误";
            }
			if (usernameinput == ""){
				document.getElementById("checkinfo").innerHTML = "用户名不能为空";
			}
			if (passwordinput == ""){
				document.getElementById("checkinfo").innerHTML = "密码不能为空";
			}
			if (usernameinput == "" && passwordinput == ""){
				document.getElementById("checkinfo").innerHTML = "用户名和密码不能为空";
			}
			if(document.getElementById("checkinfo").innerHTML == ""){
				window.location.href="main.jsp"; 
			}
        }
    }
    
    function rootModule()
    {
    	window.location.href="index.jsp";
    }
    
//    学生登录和管理员登录都用这一个LoginScript.js
    
    function stuModule()
    {
    	window.location.href="stuIndex.jsp";
    }
    
    function stuRegister()
    {
    	window.location.href="register.jsp"; 
    }
    
    
    
    function stulogincheckResult()
    {
		var certiIDinput = document.getElementById("certiIDinput").value;
		var passwordinput = document.getElementById("stupasswordinput").value;
        if (xmlHttp.readyState==4 && xmlHttp.status==200)
        {
            var data= xmlHttp.responseText;
            
			document.getElementById("checkinfo").innerHTML = "";
			
            if(data == "false")
            {
				document.getElementById("checkinfo").innerHTML = "借书账号或密码错误";
            }
            else if(data == "true")
            {
            	window.location.href="stuMain.jsp";
            }
            else{
            	window.location.href="stuMain.jsp"; 
			}
			
			
        }
    }