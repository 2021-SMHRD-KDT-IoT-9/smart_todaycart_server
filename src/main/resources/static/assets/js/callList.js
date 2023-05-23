function loadCallList() {


  var table = document.querySelector('#callTable');


  var xhr = new XMLHttpRequest();
  xhr.open('GET', 'showCallList', true);

  xhr.onreadystatechange = function() {
	  
	if (xhr.readyState === 4 && xhr.status === 200) {
      var callList = JSON.parse(xhr.responseText);

      var tbody = table.querySelector('#callTableBody');
    
      tbody.innerHTML = '';
    
      callList.forEach(function(call) {
		console.log(call);
        var row = document.createElement('tr');

        // cart ID 
        var caerIdCell = document.createElement('td');
        caerIdCell .textContent = call.call_cart;
        console.log(call.call_cart);
        row.appendChild(caerIdCell );

        // 이름 열
        var IdCell = document.createElement('td');
        IdCell.textContent = call.call_id;
        console.log(call.call_id);
        row.appendChild(IdCell);

        // 연락처 열
        var contactCell = document.createElement('td');
        contactCell.textContent = call.call_tel;
        console.log(call.call_tel);
        row.appendChild(contactCell);

		  // 위치 열
        var locCell = document.createElement('td');
        locCell.textContent = call.call_loc;
        console.log(call.call_tel);
        row.appendChild(locCell);
	
		  // 삭제 버튼 열
        var deleteCell = document.createElement('td');
        var deleteButton = document.createElement('button');
        deleteButton.className = 'btn btn-danger btn-sm';
        deleteButton.textContent = '삭제';
        
    
		deleteButton.addEventListener('click', function() {
  		var Id =  call.call_id; // 
  		deleteMember(Id); // 
		});
        
        
        deleteCell.appendChild(deleteButton);
        row.appendChild(deleteCell);

 


        tbody.appendChild(row);
      });
    }
  };
  xhr.send();
}

// 페이지가 로드되면 리스트를 불러옵니다.
document.addEventListener('DOMContentLoaded', function() {
  loadCallList();
});

function deleteMember(Id) {
  // AJAX를 사용하여 POST 요청을 보냅니다.
  var xhr = new XMLHttpRequest();
  xhr.open('POST', 'deleteCall', true);
  xhr.setRequestHeader('Content-Type', 'application/json');

  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        // 회원 삭제 성공 
        console.log('호출 하나 삭제');
         window.location.href = "call";
      } else {
        // 회원 삭제 실패
        console.log('호출 하나 삭제 실패');
       window.location.href = "call";
      }
    }
  };

  // 요청 본문에 삭제할 회원의 ID를 포함하여 전송합니다.
  var data = JSON.stringify({ call_id: Id });
  xhr.send(data);
}
