function deleteReview(reviewNo) {
    let modal = document.getElementById("modifyProductModal");
    // 모달이 완전히 열린 후에 텍스트를 변경
    modal.addEventListener('shown.bs.modal', function () {
        let modalBodyEL = document.querySelector(".modal-body");
        modalBodyEL.innerHTML = `<input type="text" name="reviewNo" value="${reviewNo}" hidden="true"/>` + "리뷰를 삭제하신 이후에는 다시 되돌릴 수 없습니다.";
    });
}