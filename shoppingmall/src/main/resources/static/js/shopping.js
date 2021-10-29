

function selectAll(selectAll)  {
  const checkboxes 
       = document.getElementsByName('chkList');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked;
	sendValue();
  })
}

function sendValue(){
   //총 금액 저장
	var total_price = 0;
   
   const query = 'input[name="chkList"]:checked';
   const selectedEls = 
      document.querySelectorAll(query);
  
 
  // 선택된 목록에서 value 찾기
  let result = '';

  for(var i=0;i<selectedEls.length;i++){
	if(i!=selectedEls.length-1)
		result+=selectedEls[i].value+'원+ ';
	else
		result+=selectedEls[i].value+'원= ';
	
	total_price +=Number(selectedEls[i].value);
   }

 /* selectedEls.forEach((el) => {
	total_price += Number(el.value);//String을 int로 변환하여 총 금액 계산(Number함수 사용)
    result += el.value + ' ';
  });*/


  	total_price+='원';

  
 
  // 출력
  document.getElementById('result').innerText
    = result;

  document.getElementById('total_price').innerText
    = total_price;
  	
}

function order(){
	var confirm_val = confirm("주문하시겠습니까?");
	
	 if (confirm_val) {
	 var checkArr = new Array();
	 $("input[name='chkList']:checked").each(function () {
 		checkArr.push($(this).attr("data-product_num"));
    });
 	  

	$.ajax({
		traditional : true,
		async : false,
        url: "/order",
        type: "post",
        data: { chbox: checkArr},
        success: function () {
			 location.href = "order";
        }
        });

	}
}


function searchPost(){
	var dong = formm.zip_num.value.trim();
	console.log(dong.length+'->'+dong);
	if(dong.length == null || dong == '')
		alert("~동을 입력해주세요");
	else{
		window.open('post','pop','width=600,height=500');
	}
}




















