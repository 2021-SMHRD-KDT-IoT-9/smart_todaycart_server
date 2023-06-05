//맞춤 광고
function insertFitAds() {
  // 버튼 비활성화
  var submitButton = document.getElementById("submit-button1");
  submitButton.disabled = true;

  var fileInput = document.getElementById("input-imageUpload1");
  var imageFile = fileInput.files[0];
  var imageName = document.getElementById("input-price1").value;
  var imageType = document.getElementById("input-type1").value;
  var adsType = "2";

  var formData = new FormData();
  formData.append("imageFile", imageFile);
  formData.append("imageName", imageName);
  formData.append("imageType", imageType);
  formData.append("adsType", adsType); // ADS_TYPE 추가

  var xhr = new XMLHttpRequest();
  xhr.open("POST", "upload", true);

  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      // 요청이 완료되었을 때
      submitButton.disabled = false; // 버튼 다시 활성화

      if (xhr.status === 200) {
        // 업로드 성공 시 처리할 로직
        console.log("이미지 업로드 성공");
        alert("소비자 맞춤광고 업로드");
         location.reload(); 
      } else {
        // 업로드 실패 시 처리할 로직
        console.error("이미지 업로드 실패");
        alert("업로드 실패");
      }
    }
  };

  xhr.send(formData);
}

function insertTimeAds() {
  // 버튼 비활성화
  var submitButton = document.getElementById("submit-button");
  submitButton.disabled = true;

  var fileInput = document.getElementById("input-imageUpload");
  var imageFile = fileInput.files[0];
  var imageName = document.getElementById("input-price").value;
  var adsType = "1";

  var formData = new FormData();
  formData.append("imageFile", imageFile);
  formData.append("imageName", imageName);
  formData.append("adsType", adsType); // ADS_TYPE 추가

  var xhr = new XMLHttpRequest();
  xhr.open("POST", "upload", true);

  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      // 요청이 완료되었을 때
      submitButton.disabled = false; // 버튼 다시 활성화

      if (xhr.status === 200) {
        // 업로드 성공 시 처리할 로직
        console.log("이미지 업로드 성공");
        alert("주간광고 업로드");
         location.reload(); 
      } else {
        // 업로드 실패 시 처리할 로직
        console.error("이미지 업로드 실패");
        alert("업로드 실패");
      }
    }
  };

  xhr.send(formData);
}



//맞춤 광고
function insertRecomAds() {
  // 버튼 비활성화
  var submitButton = document.getElementById("submit-button2");
  submitButton.disabled = true;

  var fileInput = document.getElementById("input-imageUpload2");
  var imageFile = fileInput.files[0];
  var imageName = document.getElementById("input-price2").value;
  var imageType = document.getElementById("input-type2").value;
  var adsType = "3";

  var formData = new FormData();
  formData.append("imageFile", imageFile);
  formData.append("imageName", imageName);
  formData.append("imageType", imageType);
  formData.append("adsType", adsType); // ADS_TYPE 추가

  var xhr = new XMLHttpRequest();
  xhr.open("POST", "upload", true);

  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      // 요청이 완료되었을 때
      submitButton.disabled = false; // 버튼 다시 활성화

      if (xhr.status === 200) {
        // 업로드 성공 시 처리할 로직
        console.log("이미지 업로드 성공");
        alert("상품 추천광고 업로드");
         location.reload(); 
      } else {
        // 업로드 실패 시 처리할 로직
        console.error("이미지 업로드 실패");
        alert("업로드 실패");
      }
    }
  };

  xhr.send(formData);
}

  // 클릭 이벤트 처리 코드
  $('a.dropdown-item').click(function(e) {
    e.preventDefault(); // 기본 동작을 막습니다.

    logout(); // logout() 함수 실행
  });


function logout() {
	console.log("시도");
  $.ajax({
    url: 'logout',
    type: 'POST',
    success: function(response) {
      console.log('로그아웃 성공');
      window.location.href = 'login';
    },
    error: function(xhr, status, error) {
      console.error('로그아웃 실패:', error);
 
    }
  });


}

