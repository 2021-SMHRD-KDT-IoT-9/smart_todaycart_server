 //이미지를 서버단에 저장하기 위해 controller단과 연결 
 function uploadData() {
    var adsName = document.getElementById('input-price').value;
    var imageFile = document.getElementById('input-imageUpload').files[0];
    
    var formData = new FormData();
    formData.append('adsName', adsName);
    formData.append('imageFile', imageFile);

    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'imageUpload', true); // 컨트롤러의 엔드포인트 경로로 변경해야 합니다
    xhr.onreadystatechange = function () {
      if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
        // 성공적으로 요청을 처리한 후 수행할 작업
        console.log(xhr.responseText);
      }
    };

    xhr.send(formData);
  }
  
  
var registerButton = document.querySelector('.btn-warning');
registerButton.addEventListener('click', insertTimeAds);