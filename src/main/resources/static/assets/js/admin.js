// login.js
//로그인 체크하는 기능
function loginCheck() {
  var manager_id = document.getElementById('manager_id').value;
  var manager_pw = document.getElementById('manager_pw').value;

  // Create the manager object
  var manager = {
    manager_id: manager_id,
    manager_pw: manager_pw
  };

  
  // Send a POST request to the loginCheck endpoint
  $.ajax({
    url: "loginCheck", // Replace with your loginCheck endpoint URL
    type: "POST",
    data: JSON.stringify(manager),
    contentType: "application/json",
    success: function(response) {
      // Login successful
      alert("로그인 성공");
      window.location.href = "users"; // Redirect to call.html
    },
    error: function(xhr, status, error) {
      // Login failed
      alert("로그인 실패");
    }
  });
}

//회원가입
function register(){
	console.log("콘솔확인")
	  var manager_id = document.getElementById('manager_id').value;
	  var manager_name = document.getElementById('manager_name').value;
	  var manager_num = document.getElementById('manager_num').value;
      var manager_pw = document.getElementById('manager_pw').value;
      var pw_check = document.getElementById('pw_check').value;
  
  var manager = {
    manager_id: manager_id,
    manager_name: manager_name,
    manager_num: manager_num,
    manager_pw: manager_pw,
    pw_check: pw_check
  };
	
	  $.ajax({
    url: "registerCheck", 
    type: "POST",
    data: JSON.stringify(manager),
    contentType: "application/json",
    success: function(response) {
      // Login successful
      alert("회원가입 성공");
      window.location.href = "login"; // 
    },
    error: function(xhr, status, error) {
      // Login failed
      alert("회원가입 실패");
    }
  });
}



