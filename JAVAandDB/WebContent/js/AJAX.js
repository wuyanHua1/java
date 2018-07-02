/**
 * 
 */
function getXMLHttpRequest(){
        var xmlhttp;
         if (window.XMLHttpRequest)
           {// code for IE7+, Firefox, Chrome, Opera, Safari
           xmlhttp=new XMLHttpRequest();
           }
         else
           {// code for IE6, IE5
           xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
           }
        return xmlhttp;
    }
function SearchBookOnclick()
{
	var name=document.getElementById("Search").value;//this等价于nameElement
	if(name=="")
	{
		alert("name is null!");
		return;
	}
    //创建XMLHttpRequest对象
	var xhr = getXMLHttpRequest();
	//处理结果
	xhr.onreadystatechange = function()
	{
	    if(xhr.readyState==4&&xhr.status==200)
	    {//请求一切正常
	            var msg = document.getElementById("SearchTable");
	            if(xhr.responseText!=null)
	            {
	                msg.innerHTML =xhr.responseText;
	            }
	    }
	}
//创建连接
	xhr.open("get","Search?name="+name,true);
//发送请求
	xhr.send(null);
}
function DeleteByIDOnclick()
{
	if(!confirm("delete?"))
	{
		return ;
	}
	var id=document.getElementById("deleteBookIDValues").value;
	if(id=="")
	{
		alert("id is null");
		return ;
	}
	var xhr = getXMLHttpRequest();
	//处理结果
	xhr.onreadystatechange = function()
	{
	    if(xhr.readyState==4&&xhr.status==200)
	    {//请求一切正常
	          if(xhr.responseText!=null)
	          {
	              if(xhr.responseText=="TRUE")
	              {
	            	  alert("delete success");
	              }
	              else
	              {
	            	  alert("Deletion failed,Maybe the book did not exist");
	              }
	          }
	    }
	}
//创建连接
	xhr.open("get","Delete?id="+id,true);
//发送请求
	xhr.send(null);
}
function InsertBookOnclick()
{
	var name=document.getElementById("InsertBookNameValues").value;
	var publisher=document.getElementById("InsertBookPublisherValues").value;
	var type=document.getElementById("InsertBookTypeValues").value;
	if(name=="")
	{
		alert("name is null");
		return ;
	}
	if(publisher=="")
	{
		alert("publisher is null");
		return ;
	}
	if(type=="")
	{
		alert("type is null");
		return ;
	}
	var xhr = getXMLHttpRequest();
	//处理结果
	xhr.onreadystatechange = function()
	{
	    if(xhr.readyState==4&&xhr.status==200)
	    {//请求一切正常
	          if(xhr.responseText!=null)
	          {
	              if(xhr.responseText=="TRUE")
	              {
	            	  alert("insert success!");
	              }
	              else
	              {
	            	  alert("insert failed");
	              }
	          }
	    }
	    if(xhr.status==404)
	    {
	    	alert(添加失败);
	    }
	}
	var path="Insert?name="+name+"&publisher="+publisher+"&type="+type;
//创建连接
	xhr.open("get",path,true);
//发送请求
	xhr.send(null);
}
function UpdateFindByID()
{
	var id=document.getElementById("UpdateBookIDValues").value;
	if(id=="")
	{
		return;
	}
    //创建XMLHttpRequest对象
	var xhr = getXMLHttpRequest();
	//处理结果
	xhr.onreadystatechange = function()
	{
	    if(xhr.readyState==4&&xhr.status==200)
	    {//请求一切正常
	            if(xhr.responseText!=null)
	            {
	                if(xhr.responseText=="FALSE")
	                {
	                	alert("the bookid did not exist");
	                }
	                else
	                {
	                	var strArray=xhr.responseText.split(";");
	                	document.getElementById("UpdateBookNameValues").value=strArray[0];
	                	document.getElementById("UpdateBookPublisherValues").value=strArray[1];
	                	document.getElementById("UpdateBookTypeValues").value=strArray[2];
	                }
	            }
	    }
	}
//创建连接
	xhr.open("get","FindByID?id="+id,true);
//发送请求
	xhr.send(null);
}
function UpdateManagerPassword()
{
	if(!confirm("Update？"))
	{
		alert("12")
		return ;
	}
	var id=document.getElementById("ManagerIDValues").value;
	var olderPassword=document.getElementById("OlderPasswordValues").value;
	var NewPassword=document.getElementById("NewPasswordValues").value;
	var AgainPassword=document.getElementById("AgainNewPasswordValues").value;
	if(olderPassword=="")
	{
		alert("Enter old password");
		return ;
	}
	if(NewPassword=="")
	{
		alert("Enter new password");
		return ;
	}
	if(AgainPassword=="")
	{
		alert("Reenter the new password");
		return ;
	}
	if(NewPassword!=AgainPassword)
	{
		alert("The two passwords do not match");
		return ;
	}
    //创建XMLHttpRequest对象
	var xhr = getXMLHttpRequest();
	//处理结果
	xhr.onreadystatechange = function()
	{
	    if(xhr.readyState==4&&xhr.status==200)
	    {//请求一切正常
	            if(xhr.responseText!=null)
	            {
	            	if(xhr.responseText=="TRUE")
	            	{
	            		alert("modification success!");
	            	}
	            	else
	            	{
	            		alert("Password error, modification failed");
	            	}
	            }
	    }
	}
//创建连接
	var path="UpdatePassword?id="+id+"&OlderPassword="+olderPassword+"&NewPassword="+NewPassword;
	xhr.open("get",path,true);
//发送请求
	xhr.send(null);
}

function UpdateBook()
{
	if(!confirm("modification？"))
	{
		alert("12")
		return ;
	}
	var id=document.getElementById("UpdateBookIDValues").value;
	var name=document.getElementById("UpdateBookNameValues").value;
	var publisher=document.getElementById("UpdateBookPublisherValues").value;
	var type=document.getElementById("UpdateBookTypeValues").value;
	if(id=="")
	{
		alert("enter bookid");
		return ;
	}
	if(name==""||publisher==""||type=="")
	{
		alert("not null")
	}
	
    //创建XMLHttpRequest对象
	var xhr = getXMLHttpRequest();
	//处理结果
	xhr.onreadystatechange = function()
	{
	    if(xhr.readyState==4&&xhr.status==200)
	    {//请求一切正常
	            if(xhr.responseText!=null)
	            {
	            	if(xhr.responseText=="TRUE")
	            	{
	            		alert("修改成功");
	            	}
	            	else
	            	{
	            		alert("书本ID错误,修改失败");
	            	}
	            }
	    }
	}
//创建连接
	var path="UpdateBook?id="+id+"&publisher="+publisher+"&type="+type+"&name="+name;
	xhr.open("get",path,true);
//发送请求
	xhr.send(null);
}

function LendBook()
{
	var bookid=document.getElementById("LendBookIDValues").value;
	var ReaderId=document.getElementById("LendReaderIDValues").value;
	if(bookid=="")
	{
		alert("enter bookid");
		return ;
	}
	if(ReaderId=="")
	{
		alert("enter readerid！")
	}
	
    //创建XMLHttpRequest对象
	var xhr = getXMLHttpRequest();
	//处理结果
	xhr.onreadystatechange = function()
	{
	    if(xhr.readyState==4&&xhr.status==200)
	    {//请求一切正常
	            if(xhr.responseText!=null)
	            {
	            	if(xhr.responseText=="TRUE")
	            	{
	            		alert("success");
	            	}
	            	else
	            	{
	            		alert("failed");
	            	}
	            }
	    }
	}
//创建连接
	var path="LendBook?bookId="+bookid+"&readerId="+ReaderId;
	xhr.open("get",path,true);
//发送请求
	xhr.send(null);
}

function ReturnBook()
{
	var bookid=document.getElementById("ReturnBookIDValues").value;
	if(bookid=="")
	{
		alert("enter bookid");
		return ;
	}
    //创建XMLHttpRequest对象
	var xhr = getXMLHttpRequest();
	//处理结果
	xhr.onreadystatechange = function()
	{
	    if(xhr.readyState==4&&xhr.status==200)
	    {//请求一切正常
	            if(xhr.responseText!=null)
	            {
	            	if(xhr.responseText=="TRUE")
	            	{
	            		alert("success");
	            	}
	            	else
	            	{
	            		alert("failed");
	            	}
	            }
	    }
	}
//创建连接
	var path="ReturnBook?bookid="+bookid;
	xhr.open("get",path,true);
//发送请求
	xhr.send(null);
}

function DownloadTable()
{
	var name=document.getElementById("Search").value;
	window.location.href="DownloadTable?name="+name;
}

window.onload=function(){
    document.getElementById("SearchButton").onclick=SearchBookOnclick;
    document.getElementById("deleteBookButton").onclick=DeleteByIDOnclick;
    document.getElementById("InsertBookButton").onclick=InsertBookOnclick;
    document.getElementById("UpdateBookIDValues").onblur=UpdateFindByID;
    document.getElementById("ResetPasswordButton").onclick=UpdateManagerPassword;
    document.getElementById("UpdateBookButton").onclick=UpdateBook;
    document.getElementById("LendBookButton").onclick=LendBook;
    document.getElementById("ReturnBookButton").onclick=ReturnBook;
    document.getElementById("BookSearchFileDownload").onclick=DownloadTable;
}