function deleteProduct(productName,productNo) {
    let modal = document.getElementById("modifyProductModal");

    // 모달이 완전히 열린 후에 텍스트를 변경
    modal.addEventListener('shown.bs.modal', function () {
        let modalHeadEL = document.querySelector(".modal-title");
        let modalBodyEL = document.querySelector(".modal-body");
        modalBodyEL.innerHTML = `<input type="text" name="productNo" value="${productNo}" hidden="hidden"/>` + "상품을 삭제하신 이후에는 다시 되돌릴 수 없습니다.";
        modalHeadEL.innerText = productName + "상품을 정말 삭제하시겠습니까?";
    });
}