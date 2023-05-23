
function loadMemberList() {

  var table = document.querySelector('#memberTable');


  var xhr = new XMLHttpRequest();
  xhr.open('GET', 'memberList', true);
  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {

      var memberList = JSON.parse(xhr.responseText);

      var tbody = table.querySelector('#memberTableBody');
    
      tbody.innerHTML = '';
    
      memberList.forEach(function(member) {
        var row = document.createElement('tr');

        // ID 열
        var idCell = document.createElement('td');
        idCell.textContent = member.member_ID;
        row.appendChild(idCell);

        // 이름 열
        var nameCell = document.createElement('td');
        nameCell.textContent = member.member_NAME;
        row.appendChild(nameCell);

        // 연락처 열
        var contactCell = document.createElement('td');
        contactCell.textContent = member.member_TEL;
        row.appendChild(contactCell);

        // 주소 열
        var addressCell = document.createElement('td');
        addressCell.textContent = member.member_ADD;
        row.appendChild(addressCell);

        // 삭제 버튼 열
        var deleteCell = document.createElement('td');
        var deleteButton = document.createElement('button');
        deleteButton.className = 'btn btn-danger btn-sm';
        deleteButton.textContent = '삭제';
        
        // 삭제 버튼을 클릭했을 때 deleteMember 함수 호출
		deleteButton.addEventListener('click', function() {
  		var memberId = member.member_ID; // 해당 회원의 아이디
  		deleteMember(memberId); // deleteMember 함수 호출
		});
        
        
        deleteCell.appendChild(deleteButton);
        row.appendChild(deleteCell);

 
        tbody.appendChild(row);
      });
    }
  };
  xhr.send();
}

// 페이지가 로드되면 멤버 리스트를 불러옵니다.
document.addEventListener('DOMContentLoaded', function() {
  loadMemberList();
});

//해당 member_id삭제 
function deleteMember(memberId) {
  // AJAX를 사용하여 POST 요청을 보냅니다.
  var xhr = new XMLHttpRequest();
  xhr.open('POST', 'deleteMember', true);
  xhr.setRequestHeader('Content-Type', 'application/json');

  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        // 회원 삭제 성공 
        console.log('회원이 성공적으로 삭제되었습니다.');
         window.location.href = "users";
      } else {
        // 회원 삭제 실패
        console.log('회원 삭제에 실패하였습니다.');
       window.location.href = "users";
      }
    }
  };

  // 요청 본문에 삭제할 회원의 ID를 포함하여 전송합니다.
  var data = JSON.stringify({ member_ID: memberId });
  xhr.send(data);
}


