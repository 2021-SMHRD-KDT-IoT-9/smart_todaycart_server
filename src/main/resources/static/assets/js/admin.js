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
      alert("Login successful!");
      window.location.href = "users"; // Redirect to call.html
    },
    error: function(xhr, status, error) {
      // Login failed
      alert("Login failed!");
    }
  });
}




