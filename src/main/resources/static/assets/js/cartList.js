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

// 랜덤 숫자 생성 (0부터 100까지)
		var batteryPercentage = Math.floor(Math.random() * 101);
		batterySpan.textContent = batteryPercentage + '%';
		
		var batteryProgressDiv = document.createElement('div');
		batteryProgressDiv.classList.add('progress');
		var batteryProgressBarDiv = document.createElement('div');
		batteryProgressBarDiv.classList.add('progress-bar', 'bg-gradient-danger');
		batteryProgressBarDiv.setAttribute('role', 'progressbar');
		batteryProgressBarDiv.setAttribute('aria-valuenow', batteryPercentage);
		batteryProgressBarDiv.setAttribute('aria-valuemin', '0');
		batteryProgressBarDiv.setAttribute('aria-valuemax', '100');
		batteryProgressBarDiv.style.width = batteryPercentage + '%';
		
		batteryDiv.appendChild(batterySpan);
		batteryDiv.appendChild(batteryProgressDiv);
		batteryProgressDiv.appendChild(batteryProgressBarDiv);
		
		
		row.appendChild(batteryDiv);
		row.appendChild(batteryProgressDiv);
		
	


        tbody.appendChild(row);
      });
    }
  };
  xhr.send();
}

