// 페이지가 로드되면 리스트를 불러옵니다.
document.addEventListener('DOMContentLoaded', function() {
  loadCartList();
});

function loadCartList() {


  var table = document.querySelector('#cartList');


  var xhr = new XMLHttpRequest();
  xhr.open('GET', 'showCartList', true);
  xhr.onreadystatechange = function() {
	  
	if (xhr.readyState === 4 && xhr.status === 200) {
      var cartList = JSON.parse(xhr.responseText);

      var tbody = table.querySelector('#cartListBody');
    
      tbody.innerHTML = '';
    
      cartList.forEach(function(cart) {

        var row = document.createElement('tr');
       ;
        // ID 열
        var idCell = document.createElement('td');
        idCell.textContent = cart.cart_id;
        console.log(cart.cart_id);
        row.appendChild(idCell);

        // 이름 열
        var nameCell = document.createElement('td');
        nameCell.textContent = cart.member_id;
        console.log(cart.member_id);
        row.appendChild(nameCell);

        // 연락처 열
        var contactCell = document.createElement('td');
        contactCell.textContent = cart.member_tel;
        console.log(cart.member_tel);
        row.appendChild(contactCell);

		var batteryDiv = document.createElement('div');
		batteryDiv.classList.add('d-flex', 'align-items-center');
		var batterySpan = document.createElement('span');
		batterySpan.classList.add('mr-2');
		batterySpan.textContent = '60%';
		var batteryProgressDiv = document.createElement('div');
		batteryProgressDiv.classList.add('progress');
		var batteryProgressBarDiv = document.createElement('div');
		batteryProgressBarDiv.classList.add('progress-bar', 'bg-gradient-danger');
		batteryProgressBarDiv.setAttribute('role', 'progressbar');
		batteryProgressBarDiv.setAttribute('aria-valuenow', '60');
		batteryProgressBarDiv.setAttribute('aria-valuemin', '0');
		batteryProgressBarDiv.setAttribute('aria-valuemax', '100');
		batteryProgressBarDiv.style.width = '60%';
		
		batteryDiv.appendChild(batterySpan); // 배터리 바가 나오기 전에 숫자를 먼저 추가
		batteryDiv.appendChild(batteryProgressDiv); // 배터리 바를 추가
		batteryProgressDiv.appendChild(batteryProgressBarDiv); // 배터리 바 내부에 진행 바 추가
		
		row.appendChild(batteryDiv);
		row.appendChild(batteryProgressDiv);




        tbody.appendChild(row);
      });
    }
  };
  xhr.send();
}

