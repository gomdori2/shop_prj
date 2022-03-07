<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div id="show"></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	// jquery > $.ajax(); => XMLHttpRequest, fetch(url); url, responseText(받아와서처리.), send(id=35&name=Hong)
	// document가 되고 난후에 실행하세요.
	$(document).ready(function(){
		$.ajax({
			url: '../ajax/faqList.do', // 요청 페이지.
			type: 'GET', //요청방식 GET으로 먼저 설정.
			data: {id:30, name:'hong'},// parameter로 넘길 값.
			dataType: 'json', // 요청결과값을 json 형식을 javascript object 타입으로 변환해서 가지고 오겠습니다.
			success: function(result){//성공
				console.log(result)	
				/* $('#show').html(result); */
				let ul = $('<ul>')
				result.forEach(function(item){
					ul.append( $('<li>').html(item.id + ' ' + item.title) //<li>id</li>
				)});
			$('#show').append(ul);
			},
		error: function(reject){//실패
			console.log(reject)
			$('#show').html('<h3>status:'+reject.status+", error Message:"+ reject.statusText+"</h3>")
		}
		});
	})
	</script>
</head>
<body>

</body>
</html>