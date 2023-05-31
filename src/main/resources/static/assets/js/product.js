//상품 삽입
function uploadProduct(){
  // 버튼 비활성화
  var submitButton = document.getElementById("product_button");
  submitButton.disabled = true;

  var fileInput = document.getElementById("input-imageUpload");
  var imageFile = fileInput.files[0];
  var productName = document.getElementById("input-productname").value;
  var productPrice = document.getElementById("input-price").value;
  var productWeight= document.getElementById("input-weight").value;
  var productLocation= document.getElementById("input-location").value;
  var productCode= document.getElementById("input-product-code").value;
 

var formData = new FormData();
formData.append("p_code", productCode);
formData.append("p_name", productName);
formData.append("p_price", productPrice);
formData.append("p_loc", productLocation);
formData.append("p_img", "1");
formData.append("imageFile", imageFile);



  var xhr = new XMLHttpRequest();
  xhr.open("POST", "insertProduct", true);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      // 요청이 완료되었을 때
      submitButton.disabled = false; // 버튼 다시 활성화

      if (xhr.status === 200) {
        // 업로드 성공 시 처리할 로직
        
        console.log("이미지 업로드 성공");
      } else {
        // 업로드 실패 시 처리할 로직
        console.error("이미지 업로드 실패");
      }
    }
  };

  xhr.send(formData);
}