<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String num_ = (String)request.getAttribute("num");
		int num = Integer.parseInt(num_);
		out.write("<h2>추천 라인수  : " + num_ + "</h2>");
	%>
     
    <h1>로또 번호 추천</h1>


    <h2>추천 로또 번호:</h2>
    <p>
        <%
        	for(int i=0; i<num; i++){
        		
                java.util.Random random = new java.util.Random();
                java.util.Set<Integer> lottoNumbers = new java.util.HashSet<>();
        		
                while (lottoNumbers.size() < 6) {
                    int number = random.nextInt(45) + 1;
                    lottoNumbers.add(number);
                }
        		
	            for (int number : lottoNumbers) {
	                out.print(number + " ");
	            }
	            out.println("<br>");
        	}
        %>
    </p>

    <a href="/app10/lotto">다시 추천하기</a>
    <a href="/app10/home">홈페이지로 복귀</a>
    
</body>
</html>
