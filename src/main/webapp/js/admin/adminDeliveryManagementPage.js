function inputWayBill(purchaseNo){
    let modalHeadEL = document.querySelector(".modal-title");
    let modalBodyEL = document.querySelector(".modal-body");
    let str =      "<div class=\"input-group input-group-sm mb-3 w-50\">\n" +
        "    <span class=\"input-group-text\">운송장 번호</span>\n" +
        `<input type="text" name="purchaseNo" value="${purchaseNo}" hidden="hidden"/>` +
        "    <input type=\"number\" class=\"form-control\" name=\"wayBill\" required>\n" +
        "</div>";
    modalBodyEL.innerHTML = str;


}