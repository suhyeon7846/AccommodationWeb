window.addEventListener("load", function(){
    var qna = document.querySelector(".qna-sec");
    var changeTab = qna.querySelector(".change-list");
	var qnaCreat = qna.querySelector(".qna-creat");
	var qnaList = qna.querySelector(".qna-list");
	
	changeTab.addEventListener("click",function(e){
		e.preventDefault();
		
		if(e.target.innerHTML=="내 문의"){
			var li =e.target.parentElement;
			//현재 li class에 current-tab 추가
			li.classList.add("current-tab");
			//qna-creat의 display none
			qnaCreat.style.display = "none";
			//qna-list의 display block
		    qnaList.style.display = "block";
			//다음 li class에 current-tab 삭제
			li.nextElementSibling.classList.remove("current-tab");
			return;
		}
		if(e.target.innerHTML=="문의하기"){
			var li =e.target.parentElement;
			li.classList.add("current-tab");
			qnaList.style.display = "none";
			qnaCreat.style.display = "block";
			li.previousElementSibling.classList.remove("current-tab");
			return;
		}
		
	});
});