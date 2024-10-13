function modifyProudct(productNo) {
    let modalHeadEL = document.querySelector(".modal-title");
    let modalBodyEL = document.querySelector(".modal-body");
    let modalFooterEL = document.querySelector(".modal-footer");

    $.ajax({
        url: "selectProduct.pd",
        data: {
            productNo: productNo
        },
        success: function (productInfo) {
            if (productInfo) {
                console.log(productInfo);
                modalHeadEL.innerText = productInfo.productName + " 상품 수정";

                // key값 배열 생성
                let proArr = Object.keys(productInfo)
                let str = "";
                // 프론트 그리기
                for(let property of proArr){
                    console.log("프론트 그리는 중 ")
                    switch (property){
                        case "productNo":
                            str += "<div class=\"input-group input-group-sm mb-3 w-50\">\n" +
                                "    <span class=\"input-group-text\">상품 코드</span>\n" +
                                "    <input type=\"number\" class=\"form-control\" readonly  name=\"productNo\" value=" + productInfo.productNo +">\n" +
                                "</div>";
                            break;
                        case "productCategory":
                            str += "<div class=\"input-group input-group-sm mb-3 w-50\">\n" +
                                "    <span class=\"input-group-text\">카테고리</span>\n" +
                                "    <input type=\"text\" class=\"form-control\" readonly name=\"productCategory\" value =" + productInfo.productCategory + ">\n" +
                                "</div>"
                            break;
                        case "productName":
                            str += "<div class=\"input-group input-group-sm mb-3 w-50\">\n" +
                                "    <span class=\"input-group-text\">상품명</span>\n" +
                                "    <input type=\"text\" class=\"form-control\" readonly name=\"productName\" value=\"" + productInfo.productName + "\">\n" +
                                "</div>"
                            break;
                        case "company":
                            str += "<div class=\"input-group input-group-sm mb-3 w-50\">\n" +
                                "    <span class=\"input-group-text\">제조사</span>\n" +
                                "    <input type=\"text\" class=\"form-control\" required name=\"company\" value=" + productInfo.company + ">\n" +
                                "</div>"
                            break;
                        case "price":
                            str += "<div class=\"input-group input-group-sm mb-3 w-50\">\n" +
                                "    <span class=\"input-group-text\">상품 가격</span>\n" +
                                "    <input id=\"money\" type=\"text\" class=\"form-control\" required name=\"price\"placeholder='원' value="+productInfo.price + ">\n" +
                                "</div>"
                            break;
                        case "inventory":
                            str += "<div class=\"input-group input-group-sm mb-3 w-50\">\n" +
                                "    <span class=\"input-group-text\">상품 재고 수량</span>\n" +
                                "    <input type=\"number\" class=\"form-control\" required name=\"inventory\" placeholder=\"개\" value="+productInfo.inventory + ">\n" +
                                "</div>"
                            break;
                        case "ingredient":
                            str += "<div class=\"input-group input-group-sm mb-3 w-50\">\n" +
                                "    <span class=\"input-group-text\">주원료</span>\n" +
                                "    <input type=\"text\" class=\"form-control\" required name=\"ingredient\" value=\""+productInfo.ingredient + "\">\n" +
                                "</div>"
                            break;
                        case "origin":
                            str += "<div class=\"input-group input-group-sm mb-3 w-50\">\n" +
                                "    <span class=\"input-group-text\">원산지</span>\n" +
                                "    <input type=\"text\" class=\"form-control\" required name=\"origin\" value="+productInfo.origin + ">\n" +
                                "</div>"
                            break;
                        case "productWeight":
                            str += "<div class=\"input-group input-group-sm mb-3 w-50\">\n" +
                                "    <span class=\"input-group-text\">중량</span>\n" +
                                "    <input type=\"text\" class=\"form-control\" required name=\"productWeight\" placeholder=\"kg\" value="+productInfo.productWeight + ">\n" +
                                "</div>"
                            break;
                        case "kcal":
                            str += "<div class=\"input-group input-group-sm mb-3 w-50\">\n" +
                                "    <span class=\"input-group-text\">칼로리</span>\n" +
                                "    <input type=\"text\" class=\"form-control\" required name=\"kcal\" placeholder=\"Kcal\" value="+productInfo.kcal + ">\n" +
                                "</div>"
                            break;
                        case "enrollDate":
                            str += "<div class=\"input-group input-group-sm mb-3 w-50\">\n" +
                                "    <span class=\"input-group-text\">상품 등록일</span>\n" +
                                "    <input type=\"text\" class=\"form-control\" readonly name=\"none\" value=" + productInfo.enrollDate + ">\n" +
                                // "    <span class='form-control'>" + productInfo.enrollDate +"</span>"
                                "</div>"
                            break
                        default:
                            str+= "<div class=\"input-group input-group-sm mb-3 w-75\">\n" +
                                "    <span class=\"input-group-text\">썸네일 사진</span>\n" +
                                "    <input type=\"file\" class=\"form-control\" name=\"thumbnail\" required>\n" +
                                "</div>\n" +
                                "<div class=\"input-group input-group-sm mb-3 w-75\">\n" +
                                "    <span class=\"input-group-text\">상품 상세페이지 사진</span>\n" +
                                "    <input type=\"file\" class=\"form-control\" name=\"detail\" required>\n" +
                                "</div>"
                    }
                }
                // Modal Body 에 적용
                modalBodyEL.innerHTML = str;
            } else {
                console.log("상품 정보가 없습니다.");
            }
        },
        error: function () {
            console.log("상품 정보 AJAX 요청 실패");
        }
    });
}
document.querySelector(".modal-body input[name=none]").onclick = function (_this){
    _this.value = "none";
}
